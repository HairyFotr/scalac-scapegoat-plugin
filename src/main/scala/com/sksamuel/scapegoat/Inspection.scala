package com.sksamuel.scapegoat

import scala.reflect.api.Position
import scala.tools.nsc.Global

/** @author Stephen Samuel */
trait Inspection {
  def inspector(context: InspectionContext): Inspector
}

abstract class Inspector(val context: InspectionContext) {
  def traverser: context.Traverser
  def postInspection(): Unit = ()
}

case class InspectionContext(global: Global, feedback: Feedback) {

  def warn(text: String, pos: Position, level: Level, inspection: Inspection) = {
    feedback.warn(text, pos, level, inspection)
  }
  def warn(text: String, pos: Position, level: Level, snippet: String, inspection: Inspection) = {
    feedback.warn(text, pos, level, snippet, inspection)
  }

  trait Traverser extends global.Traverser {

    import global._

    private val SuppressWarnings = typeOf[SuppressWarnings]

    private def inspectionClass(klass: Class[_]): Class[_] = Option(klass.getEnclosingClass) match {
      case None => klass
      case Some(k) => inspectionClass(k)
    }

    private def isAllDisabled(an: AnnotationInfo) = {
      an.javaArgs.head._2.toString.toLowerCase.contains("\"all\"")
    }

    private def isThisDisabled(an: AnnotationInfo) = {
      an.javaArgs.head._2.toString.toLowerCase.contains(inspectionClass(getClass).getSimpleName.toLowerCase)
    }

    private def isSuppressed(symbol: Symbol) = {
      symbol != null && symbol.annotations.exists(an =>
        an.tree.tpe =:= SuppressWarnings && (isAllDisabled(an) || isThisDisabled(an)))
    }

    protected def continue(tree: Tree) = super.traverse(tree)

    protected def inspect(tree: Tree): Unit

    override final def traverse(tree: Tree): Unit = {
      tree match {
        // ignore synthetic methods added to case classes
        case DefDef(mods, _, _, _, _, _) if mods.isCase && mods.isSynthetic =>
        case dd@DefDef(_, _, _, _, _, _) if isSuppressed(dd.symbol) =>
        case block@Block(_, _) if isSuppressed(block.symbol) =>
        case iff@If(_, _, _) if isSuppressed(iff.symbol) =>
        case tri@Try(_, _, _) if isSuppressed(tri.symbol) =>
        case _ => inspect(tree)
      }
    }
  }
}





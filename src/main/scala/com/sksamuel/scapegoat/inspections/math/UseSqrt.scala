package com.sksamuel.scapegoat.inspections.math

import com.sksamuel.scapegoat._

/** @author Stephen Samuel */
class UseSqrt extends Inspection {

  def inspector(context: InspectionContext): Inspector = new Inspector(context) {
    override def traverser = new context.Traverser {

      import context.global._

      override def inspect(tree: Tree): Unit = {
        tree match {
          case Apply(Select(pack, TermName("pow")), List(_, Literal(Constant(0.5d))))
            if pack.toString() == "java.this.lang.Math" =>
            context.warn("Use Math.sqrt", tree.pos, Levels.Info,
              "Math.sqrt is clearer and more performance than Math.pow(x, 0.5)",
              UseSqrt.this)
          case _ => continue(tree)
        }
      }
    }
  }
}

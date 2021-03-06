package com.sksamuel.scapegoat.inspections.empty

import com.sksamuel.scapegoat.PluginRunner
import org.scalatest.{FreeSpec, Matchers}

/** @author Stephen Samuel */
class EmptyMethodTest extends FreeSpec with Matchers with PluginRunner {

  override val inspections = Seq(new EmptyMethod)

  "empty method" - {
    "should report warning" in {

      val code = """object Test {
                      def foo = { }
                      def foo2 = true
                      def foo3 = {
                        ()
                      }
                      def foo4 = {
                        println("sammy")
                        ()
                      }
                    } """.stripMargin

      compileCodeSnippet(code)
      compiler.scapegoat.feedback.warnings.size shouldBe 2
    }
  }
}

package com.sksamuel.scapegoat.inspections.collections

import com.sksamuel.scapegoat.PluginRunner
import org.scalatest.{FreeSpec, Matchers}

/** @author Stephen Samuel */
class TraversableHeadTest extends FreeSpec with Matchers with PluginRunner {

  override val inspections = Seq(new TraversableHead)

  "option.head use" - {
    "should report warning" in {

      val code = """class Test {
                      Seq("sam").head
                      List("sam").head
                      Vector("sam").head
                      Iterable("sam").head
                    } """.stripMargin

      compileCodeSnippet(code)
      compiler.scapegoat.feedback.warnings.size shouldBe 4
    }
  }
}

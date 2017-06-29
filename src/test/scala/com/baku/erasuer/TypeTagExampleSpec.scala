package com.baku.erasuer

import com.baku.erasures.{TypeTagExample, TypeTagResut}
import org.scalatest.{FlatSpec, Matchers}

class SampleClass

class TypeTagExampleSpec extends FlatSpec with Matchers {

  val sample = new SampleClass

  it should "recognize strings" in {
    TypeTagExample.recognize("a").uSymbol shouldEqual "class String"
  }

  it should "recognize integers" in {
    TypeTagExample.recognize(5).uSymbol shouldEqual "class Int"
  }

  it should "recognize doubles" in {
    TypeTagExample.recognize(2.3).uSymbol shouldEqual "class Double"
  }

  it should "recognize defined type" in {
    TypeTagExample.recognize(sample).uSymbol shouldEqual "class SampleClass"
  }

}

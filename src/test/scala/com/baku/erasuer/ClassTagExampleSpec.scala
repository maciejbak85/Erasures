package com.baku.erasuer

import com.baku.erasures.ClassTagExample
import org.scalatest.{FlatSpec, Matchers}

trait TestType

class ATestType extends TestType
class BTestType extends TestType

class ClassTagExampleSpec extends FlatSpec with Matchers {

  val aType = new ATestType
  val bType = new ATestType
  val list = List(1,2, "a", List.empty, 3.5, 9.9, 12.3, aType, bType)

  it should "extract strings" in {
    ClassTagExample.extract[String](list) shouldEqual List("a")
  }

  it should "extract integers" in {
    ClassTagExample.extract[Int](list) shouldEqual List(1, 2)
  }

  it should "extract doubles" in {
    ClassTagExample.extract[Double](list) shouldEqual List(3.5, 9.9, 12.3)
  }

  it should "extract defined type" in {
    ClassTagExample.extract[TestType](list) shouldEqual List(aType, bType)
  }

}

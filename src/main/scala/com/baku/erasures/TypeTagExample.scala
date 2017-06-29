package com.baku.erasures

import scala.reflect.runtime.universe._

case class TypeTagResut(uType: String, uSymbol: String, arg: String)

object TypeTagExample {

  def recognize[T](x: T)(implicit tag: TypeTag[T]): TypeTagResut = tag.tpe match {
    case TypeRef(uType, uSymbol, arg) =>
      TypeTagResut(uType.toString, uSymbol.toString, arg.mkString)
  }

}

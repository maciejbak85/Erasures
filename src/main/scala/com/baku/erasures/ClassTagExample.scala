package com.baku.erasures

import scala.reflect.ClassTag

object ClassTagExample {

  //def extract[T](list: List[Any])(implicit tag: ClassTag[T])
  def extract[T : ClassTag](list: List[Any]) = list.flatMap {
    case el: T => Some(el)
    case _ => None
  }

}

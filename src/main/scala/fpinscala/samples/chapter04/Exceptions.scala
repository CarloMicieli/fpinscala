package fpinscala.samples.chapter04

object Exceptions {
 def failingFn(i: Int): Int = {
   val y: Int = if (i == 0) throw new Exception("fail!") else i
   try {
     val x = 42 + 5
     x + y
   } catch {
     case e: Exception => 43
   }
 }
}

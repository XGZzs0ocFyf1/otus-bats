package me.chuwy.otusbats



//import cats.Show
//import cats.implicits._

object Example {

  def example[A: Show, B: Show](a: A, b: B) =
    ???// show"A is $a, B is $b"

  def example[A, B](implicit eva: Show[A], evb: Show[B]) = ???

  def main(args: Array[String]): Unit = {

    import Show._
    val list: List[Int] = List(1, 2, 3)
    val r = list.show(showList)
    println(r)
  }
}

package me.chuwy.otusbats

trait Monoid[A] extends Semigroup[A] {
  def zero: A
}

object Monoid {

  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    def zero: Int = 1

    def combine(x: Int, y: Int): Int = x * y
  }


  implicit def optionMonoid[A](implicit f: (A, A) => A): Monoid[Option[A]] = new Monoid[Option[A]] {
    override def zero: Option[A] = None

    override def combine(x: Option[A], y: Option[A]): Option[A] = for {
      a <- x
      b <- y
    } yield f(a, b)

  }
}


object Test{
  def main(args: Array[String]): Unit = {

    implicit val combineRule = (n1: Int, n2: Int) => n1 + n2
    val m1 = Monoid.optionMonoid[Int]


    val n3 = m1.combine(Option(1), Option(3))
    println(n3)


  }
}

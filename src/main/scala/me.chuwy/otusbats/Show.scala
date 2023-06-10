package me.chuwy.otusbats


trait Show[A] {
  def show(a: A): String
}

object Show {

  // 1.1 Instances (`Int`, `String`, `Boolean`)

  implicit def showInt: Show[Int] = (a: Int) => a.toString

  implicit def showString: Show[String] = (a: String) => a

  implicit def showBoolean: Show[Boolean] = (a: Boolean) => a.toString

  implicit def showList[A](implicit ev: Show[A]): Show[List[A]] = (a: List[A]) => a.map(elem => ev.show(elem)).mkString(", ")


  implicit class ShowOps[A](a: A) {
    def show(implicit ev: Show[A]): String = ev.show(a)

  // 4. Helper constructors
  }
  /** Just use JVM `toString` implementation, available on every object */
  def fromJvm[A]: Show[A] = _.toString

  /** Provide a custom function to avoid `new Show { ... }` machinery */
  def fromFunction[A](f: A => String): Show[A] = (a: A) => f(a)




}

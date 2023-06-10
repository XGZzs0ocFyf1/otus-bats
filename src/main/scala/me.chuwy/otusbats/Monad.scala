package me.chuwy.otusbats

trait Monad[F[_]] extends Functor[F] {
  self =>
  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B] = {


    val mapped: F[F[B]] = self.map(fa)(el => f(el))
    val out = self.flatten(mapped)
    out
  }

  def point[A](a: A): F[A] = ???

  def flatten[A](fa: F[F[A]]): F[A] = ???
}

object Monad {

}

package advance.exercises

import scala.io.Source.stdin
object PartialFunction extends App {

  val partianFun: PartialFunction[Int, String] = {
    case 1 => "One"
    case 2 => "Two"
  }

  println(partianFun(1))
  println(partianFun(2))

  val partFun: PartialFunction[String, String] = {
    case "Hello" => "Hi"
    case "Hi" => "Bi"
  }
  stdin.getLines().foreach(line => println( partFun(line)))
}

package begineers.lectures.part1basics

object ValuesVariablesTypes extends App {

  var x: Int = 42
  println(x)
  val b : Boolean = true
  println(if(b)  5 else 6 )
  val aWhile = {
    x += 1
    x
  }
  print(aWhile)
}

package begineers.lectures.part5

object MapFilterFlatmapFor extends App {

  val number = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c')

  def concat(a: Char, numbers: List[Int]): List[String] =
    numbers.map(a +"" + _)

  val concatinatedList = chars.flatMap(concat(_, number) )
  print(concatinatedList)

  val combination = chars.flatMap(c => number.map(n => "" + c+n))
  println(combination)
}

package begineers.exercises

object ToStringTest extends App {

  class Point(var x: Int, var y: Int){

    def this(x: Int, y: Int, z: Int) = {
      this(x, 0)
    }
    override def toString: String = {
      s"$x-$y"
    }
  }

  val point: Point = new Point(3, 4, 5)
  println(point)
}

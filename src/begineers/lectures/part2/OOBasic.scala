package begineers.lectures.part2

object OOBasic extends  App {
  val counter = new Counter
  counter.inc
}

class Writer (firstName: String, surname: String, val yob: Int){
  def fullName : String = firstName + " " +  surname
}

class  Novel(name : String, yor : Int, author : Writer) {
  def authorAge: Int = yor - author.yob
  def  isWrittenBy(author: Writer) : Boolean = author == this.author

  def copy(newYear: Int) = new Novel(name, newYear, author)
}

class Counter(val count: Int = 0) {
  def  inc = {
    println("incrementing")
    new Counter(count + 1)
  }
}
package advance.exercises

object PatternMatching extends App {

  object Condition {
    def unapply(x: Int): Option[String] = {
      if(x < 10) Some("single digit")
      else if(x%2 == 0) Some("an even number")
      else None
    }
  }

  object singleDigit {
    def unapply(arg: Int): Boolean = arg > -10 && arg < 10
  }

  object even {
    def unapply(arg: Int): Boolean = arg % 2 == 0
  }
  val n : Int = 40

  val mathCondition = n match {
    case singleDigit() => "single digit"
    case even() => " an even number"
    case _ => "No Property"
  }

  println(mathCondition)

}

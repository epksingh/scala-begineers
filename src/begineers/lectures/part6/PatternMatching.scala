package begineers.lectures.part6

object PatternMatching extends  App {

  trait Expr

  case class Number(n: Int) extends Expr
  case class Sum(expr1: Expr, expr2: Expr) extends  Expr
  case class Product(expr1: Expr, expr2: Expr) extends  Expr

  def show(expr: Expr): String = {
    expr match {
      case Number(n) => s"$n"
      case Sum(expr1, expr2) => show(expr1) + " + " + show(expr2)

      case Product(expr1, expr2) => {
        def mayBeWithParentheses(expr: Expr) : String = expr match {
          case Number(_) => show(expr)
          case Product(_, _) => show(expr)
          case _ => "(" + show(expr) + ")"
        }
        mayBeWithParentheses(expr1) + " * " + mayBeWithParentheses(expr2)
      }

    }
  }

  println(show(Number(1)))
  println(show(Sum(Number(1), Number(2))))
  println(show(Product(Number(1), Number(2) )))

  println(show(Sum(Product(Number(1), Number(2)), Number(3))))

  println(show(Product(Sum(Number(1), Number(2)), Number(3))))

  println(show(Product(Sum(Number(1), Number(2)), Sum(Number(3), Number(4)))))
  println(show(Sum(Product(Number(1), Number(2)), Product(Number(3), Number(4)))))

}


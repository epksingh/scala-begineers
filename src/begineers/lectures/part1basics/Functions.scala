package begineers.lectures.part1basics

import scala.annotation.tailrec

object Functions extends  App {
  def greetings( name:String, age:Int) : Unit = {
    println(s"Hi, my name is ${name} and I am ${age} year old")
  }

  def factorial(n : Int) : BigInt = {
    def factorialHelper(n:Int, acc: BigInt): BigInt ={
      if(n <= 1) acc
      else
        factorialHelper(n-1, n*acc);
    }
    factorialHelper(n, 1)
  }

  def concatString(concatString:String, n:Int): String ={
    @tailrec
    def concatStringHelper(n:Int, accumulator:String): String ={
      if(n == 0) accumulator
      else concatStringHelper( n -1,  accumulator + concatString)

    }
    concatStringHelper(n, "");
  }

  @tailrec
  def concatStringTailRec(n: Int, concatString:String, acc:String) : String = {
    if(n <= 0) acc
    else concatStringTailRec(n-1, concatString, acc + concatString)
  }

  def isPrime(n : Int) :  Boolean ={
    @tailrec
    def isPrimeHelper(d:Int, isPrimeAcc:Boolean) : Boolean ={
      if(!isPrimeAcc) false
      else if (d <= 1) true
      else
        isPrimeHelper(d - 1, n % d != 0 && isPrimeAcc)

    }
    isPrimeHelper(n/2, true)
  }

  def fibonacci(n: Int):Int = {
    def fibHelper(n:Int, a:Int, b : Int) : Int = {
      if(n <= 2) return b
      else fibHelper(n-1, b, a+b)
    }
    fibHelper(n, 1, 1)
  }
  def fibonacci1(n:Int) : Int = {
    def fibTailRec(i:Int, last:Int, prevLast:Int) : Int = {
      if (i == n ) last
      else fibTailRec(i+1, last+prevLast, last)
    }
    if(n <= 2) 1
    else fibTailRec(2, 1, 1)
  }
  println(fibonacci(3))
  println(fibonacci(4))
  println(fibonacci(5))
//  println(concatString("Hello", 30))
//  println(concatStringTailRec(30, "Hello", ""))
////  greetings("Prem", 31)
////  println(factorial(20000))
//  println(isPrime(4))
//  println(isPrime(7))

}

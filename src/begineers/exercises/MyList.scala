package begineers.exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](elem: B): MyList[B]
  def printElements : String
  override def toString: String = "[" + printElements + "]"

  def ++ [B >: A](list : MyList[B] ) : MyList[B]
  def map[B](transformer: A => B ): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(myPredicate: A => Boolean): MyList[A]
}

object Empty extends MyList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](elem: B): MyList[B] = new Cons(elem, Empty)
  def printElements: String = ""

  def ++ [B >: Nothing](list : MyList[B] ) : MyList[B] = list
  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty

  override def filter(myPredicate: Nothing => Boolean): MyList[Nothing] = Empty
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](elem: B): MyList[B] = new Cons(elem, this)

  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def ++ [B >: A](list : MyList[B] ) : MyList[B] = new Cons(h, t ++ list)

  def map[B](transformer:  A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)


  def filter(myPredicate: A => Boolean): MyList[A] = {
    if(myPredicate(h)) new Cons(h, t.filter(myPredicate))
    else this.filter(myPredicate)
  }
}


object TestList extends App {
  val list = new Cons(1, new Cons(2,Empty))
  println(list.toString)
}
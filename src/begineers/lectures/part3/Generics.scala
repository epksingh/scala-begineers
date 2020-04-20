package begineers.lectures.part3

object Generics {

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  class CoverienceList[+A]

  val coverienceList: CoverienceList[Animal] = new CoverienceList[Cat];
  //coverienceList
}

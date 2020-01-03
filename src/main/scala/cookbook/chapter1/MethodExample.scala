package cookbook.chapter1


object MethodExample extends App {
  // anonymous function
  val numList = List.range(1, 10)
  println(numList.filter((i: Int) => i % 2 == 0))
  println(numList.filter(i => i % 2 == 0))
  println(numList.filter(_ % 2 == 0))

  val double = (i: Int) => i * 2
  println(numList.map(double))

  // storing function as variable
  val f: (Int) => Boolean = i => i%2==0


  // method with function as param
  def executeMethod(f:() => Unit): Unit = {
    f()
  }

  val printName = () => println("hello print name")
  executeMethod(printName)


  def executeMethod(f:(Int) => Unit,value: Int): Unit = {
    f(value)
  }

  val addOne = (i:Int) => {
    println(i + 1)
  }

  executeMethod(addOne,100)
}

package cookbook.chapter1


// create hashcode for a string

object StringExample extends App {

  implicit class HashCodeGenarator(val sc:StringContext) extends AnyVal {
    def g(args: Any*): Int = {
      sc.parts.foreach(println)
      args.foreach(println)
      sc.parts.hashCode()
    }
  }

  /**
   * String in scala is very much like Java but has extra operaation because of StringOps,StringLike,WrappedString and so on
   * all because of implicits
   */
  "hello".foreach(println)

  "hello".filter(_ != 'l').foreach(println)

  println("hello" == "hello")

  val multilineString1 =
    """Hello wojadkj a
       asksdj asjkda
       jkdajk djkajka
      """
  println(multilineString1)

  val multilineString2 =
    """Hello wojadkj a
      #asksdj asjkda
      #jkdajk djkajka
      """
  println(multilineString2.stripMargin('#'))


  val splitString = "john, rick, morty  "
  splitString.split(",").map(_.trim).foreach(println)

  // string interpolation
  val name = "john"
  println(s"My name is : $name")
  println(g"hello world")
  println(g"hello world ${name}")
}

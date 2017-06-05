case class FizzBuzz() {

  def generate(start: Int, end: Int): String = {
    if (start > end) s"Invalid range: $start is higher than $end"
    else {
      val asList = fizzBuzzList(start, end)
      (asList ++ report(asList)).mkString(" ")
    }
  }

  private def fizzBuzzList(start: Int, end: Int): List[String] = {
    (start to end map {
      case luckyNumber if luckyNumber.toString.contains("3") => "lucky"
      case nonLuckyNumber =>
        (nonLuckyNumber % 5, nonLuckyNumber % 3) match {
          case (0, 0) => "fizzbuzz"
          case (0, _) => "buzz"
          case (_, 0) => "fizz"
          case _      => nonLuckyNumber.toString
        }
    }).toList
  }

  private def report(fizzBuzzList: List[String]) = {
    val orderedList = List("fizz", "buzz", "fizzbuzz", "lucky")

    val (replacements, integers) = fizzBuzzList
      .groupBy(identity)
      .partition(grouped => orderedList.contains(grouped._1))

    val replaced: List[String] = orderedList.flatMap(r => replacements.get(r).map(items => s"$r: ${items.length}"))
    replaced :+ s"integer: ${integers.size}"
  }
}

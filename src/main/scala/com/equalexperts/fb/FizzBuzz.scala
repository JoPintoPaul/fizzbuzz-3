package com.equalexperts.fb

case class FizzBuzz() {

  private val orderForReport = List("fizz", "buzz", "fizzbuzz", "lucky")

  def generate(start: Int, end: Int): String = {
    if (start > end) s"Invalid range: $start is higher than $end"
    else {
      val asList = generateFizzBuzzList(start, end)
      (asList ++ generateReport(asList)).mkString(" ")
    }
  }

  private def generateFizzBuzzList(start: Int, end: Int): List[String] = {
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

  private def generateReport(fizzBuzzList: List[String]) = {
    val (replacements, integers) = fizzBuzzList
      .groupBy(identity)
      .partition(grouped => orderForReport.contains(grouped._1))

    val replaced: List[String] = orderForReport.flatMap(key => replacements.get(key).map(values => s"$key: ${values.length}"))
    replaced :+ s"integer: ${integers.size}"
  }
}

import org.specs2.mutable.Specification

class FizzBuzzSpec extends Specification {

  "Given a contiguous range of integers, calling generate on a FizzBuzz" should {
    "return a string with integers containing 3 replaced by lucky" in {
      FizzBuzz().generate(1, 3) must_=== "1 2 lucky"
    }

    "return a string with integers containing 3 replaced by lucky, and multiples of 5 replaced by buzz" in {
      FizzBuzz().generate(1, 5) must_=== "1 2 lucky 4 buzz"
    }

    "return a string with integers containing 3 replaced by lucky, multiples of 3 replaced by fizz, and of 5 replaced by buzz, and of 15 replaced by fizzbuzz" in {
      FizzBuzz().generate(1, 20) must_=== "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz"
    }

    "return a string with correctly handled negative integers, assuming that zero is divisible by any number" in {
      FizzBuzz().generate(-3, 3) must_=== "lucky -2 -1 fizzbuzz 1 2 lucky"
    }

    "return a string with an informative error if the start value is greater than the end value" in {
      FizzBuzz().generate(20, 1) must_=== "Invalid range: 20 is higher than 1"
    }
  }
}

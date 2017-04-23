package application

import org.scalatest._

class PermutedMultiplesSpec extends FlatSpec with Matchers {
  val permutedMultiples = new PermutedMultiples()

  "The permuted multiples class" should "have an instance type" in {
    assume(permutedMultiples.isInstanceOf[PermutedMultiples])
  }

  "The permuted multiples class" should "have an x variables" in {
    permutedMultiples.x shouldEqual 10
  }

  "The permuted multiples class" should "have an setter for x" in {
    permutedMultiples.setX(15) shouldEqual 15
  }

  "The permuted multiples class" should "have an getter for x" in {
    permutedMultiples.getX() shouldEqual 15
  }

  "The permuted multiples class" should "thrown a multiplication exception for initial value" in {
    a [InitialMultiplicationException] should be thrownBy {
      permutedMultiples.by(1)
    }
  }

  "The permuted multiples class" should "have a multiplication by two" in {
    permutedMultiples.by(2) shouldEqual 30
  } 

  "The permuted multiples class" should "have a multiplication by a number gt six" in {
    a [GreaterThanSixMultiplicationException] should be thrownBy {
      permutedMultiples.by(7)
    }
  }

  "The permuted multiples class" should "have a digit occurrences" in {
    permutedMultiples.digitOccurrences("7","1234789732985") shouldEqual 2
  } 
}

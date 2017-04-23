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

  "The permuted multiples class" should "have a conjunction by method" in {
    a [InitialMultiplicationException] should be thrownBy {
      permutedMultiples.by(1)
    }
  }
}

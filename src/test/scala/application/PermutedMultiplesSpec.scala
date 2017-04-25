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
    permutedMultiples.digitOccurrences("3","1234789732985") shouldEqual 2
    permutedMultiples.digitOccurrences("2","1231234878984123") shouldEqual 3
  } 

  "The permuted multiples class" should "have a digit split" in {
    permutedMultiples.digitSplit("123") shouldEqual Array("1","2","3")
    permutedMultiples.digitSplit("17890251") shouldEqual Array("1","7","8","9","0","2","5","1")
  }

  "The permuted multiples class" should "have a array string type" in {
    assume(permutedMultiples.digitSplit("1234").isInstanceOf[Array[String]])
  }

  "The permuted multiples class" should "have a digit array" in {
    permutedMultiples.digitsArr shouldEqual Array(Array("1","2","3"),Array("1","7","8","9","0","2","5","1"),Array("1","2","3","4"))
  }

  "The permuted multiples class" should "have unique digits" in {
    permutedMultiples.uniqueDigits("1111112222223333") shouldEqual Array("1","2","3")
    permutedMultiples.uniqueDigits("1011205305105") shouldEqual Array("1","0","2","5","3")
  } 

  "The permuted multiples class" should "have a unique digit array" in {
    permutedMultiples.uniqueDigitsArr shouldEqual Array(Array("1","2","3"),Array("1","0","2","5","3"))
  }

  "The permuted multiples class" should "have a unique digit array of strings" in {
    assume(permutedMultiples.uniqueDigitsArr.isInstanceOf[Array[Array[String]]])
  }

  "The permuted multiples class" should "have digits occurrences" in {
    permutedMultiples.digitsOccurrences("1234789732985") shouldEqual Array(1,2,2,1,2,2,2,1)
  }

  "The permuted multiples class" should "have digits occurrences type of array of ints" in {
    assume(permutedMultiples.digitsOccurrences("14778349165328").isInstanceOf[Array[Int]])
  }

  //"The permuted multiples class" should "have digits six occurrences" in {
  //  permutedMultiples.digitsSixOccurences(125874) shouldEqual 
  //}
}

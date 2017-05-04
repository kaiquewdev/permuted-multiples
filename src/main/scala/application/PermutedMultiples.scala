package application

class InitialMultiplicationException extends Exception {}
class GreaterThanSixMultiplicationException extends Exception {}

class PermutedMultiples extends Object with PermutedMultiplesDefinition {
  var digitsArr: Array[Array[String]] = Array.empty
  var uniqueDigitsArr: Array[Array[String]] = Array.empty

  def digitOccurrences(dgt: String, dgtSeq: String): Int = {
    var occurrs: Int = 0
    for (i <- (0 to dgtSeq.length - 1)) {
      if (dgtSeq(i).toString() == dgt) {
        occurrs += 1
      }
    }
    occurrs
  }

  def digitSplit(dgts: String): Array[String] = {
    var digits: Array[String] = Array.empty
    for (i <- (0 to dgts.length-1)) {
      digits = digits :+ dgts(i).toString() 
    }
    digitsArr = digitsArr :+ digits
    digits
  }

  def uniqueDigits(dgts: String): Array[String] = {
    var digits: Array[String] = Array.empty
    for (i <- (0 to dgts.length-1)) {
      if (digits.indexOf(dgts(i).toString()) == -1) {
        digits = digits :+ dgts(i).toString()
      }
    }
    uniqueDigitsArr = uniqueDigitsArr :+ digits
    digits
  }

  def digitsOccurrences(dgtSeq: String): Array[Int] = {
    var uniqueDigitsLocal: Array[String] = uniqueDigits(dgtSeq)
    var occurrs: Array[Int] = Array.empty
    for (i <- (0 to uniqueDigitsLocal.length-1)) {
      occurrs = occurrs :+ digitOccurrences(uniqueDigitsLocal(i),dgtSeq)
    }
    occurrs
  }

  def pairdDigitsOccurrences(dgtSeq: String): Map[String,Array[Int]] = {
    var multiples: Map[String,Array[Int]] = Map(dgtSeq -> digitsOccurrences(dgtSeq))
    setX(dgtSeq.toInt)
    for (i <- (2 to 6)) {
      multiples += (by(i).toString() -> digitsOccurrences(by(i).toString()))
    }
    multiples
  }
}

object PermutedMultiplesExplanation extends App {
  println("Permuted Multiples Explanation")
  val permutedMultiples = new PermutedMultiples()
  val sequence = "1001"
  permutedMultiples.setX(1001)
  println(permutedMultiples.getX() + ": " + permutedMultiples.pairdDigitsOccurrences(sequence)(sequence).map(v => v.toString()).reduce((r,l) => r + "-" + l))
}

trait PermutedMultiplesDefinition {
  var x: Int = 10
  def setX(v: Int): Int = {
    x = v
    v
  }
  def getX(): Int = x
  def by(t: Int): Int = {
    if (t == 1) {
      throw new InitialMultiplicationException()
    } else if (t > 6) {
      throw new GreaterThanSixMultiplicationException()
    } else {
      x * t
    }
  }
}

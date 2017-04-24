package application

class InitialMultiplicationException extends Exception {}
class GreaterThanSixMultiplicationException extends Exception {}

class PermutedMultiples extends Object with PermutedMultiplesDefinition {
  var digitsArr: Array[Array[String]] = Array.empty

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
    digits
  }
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

package application

class InitialMultiplicationException extends Exception {}

class PermutedMultiples extends Object with PermutedMultiplesDefinition {}

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
    } else {
      x
    }
  }
}

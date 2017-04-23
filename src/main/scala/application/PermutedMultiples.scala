package application

class PermutedMultiples extends Object with PermutedMultiplesDefinition {
  
}

trait PermutedMultiplesDefinition {
  var x: Int = 10
  def setX(v: Int): Int = {
    x = v
    v
  }
}

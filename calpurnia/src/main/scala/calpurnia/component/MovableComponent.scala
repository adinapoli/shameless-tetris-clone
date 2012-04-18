package calpurnia.component

import calpurnia.Component

trait MovableComponent extends Component{
  Id = "MovableComponent"
  var X : Int = 0
  var Y : Int = 0
  var Z : Int = 0
  var rotX : Float = 0.0f
  var rotY : Float = 0.0f
  var rotZ : Float = 0.0f

  def move(newX : Int, newY : Int)
  {
    X = newX
    Y = newY
  }

  def move(newX : Int, newY : Int, newZ : Int)
  {
    X = newX
    Y = newY
    Z = newZ
  }

  def move(newX : Int, newY : Int, newZ : Int,
           newRX : Float, newRY : Float, newRZ : Float)
  {
    X = newX
    Y = newY
    Z = newZ
    rotX = newRX
    rotY = newRY
    rotZ = newRZ
  }
}

package calpurnia.entity

import calpurnia.component.MovableComponent
import calpurnia.messaging.UpdatePositionMsg
import calpurnia.{Msg, Entity}

trait MovableEntity extends Entity{
  Id = "MovableEntity"
  var X : Int = 0
  var Y : Int = 0
  var Z : Int = 0
  var rotX : Float = 0.0f
  var rotY : Float = 0.0f
  var rotZ : Float = 0.0f

  def move(newX : Float, newY : Float)
  {
    X = newX.asInstanceOf[Int]
    Y = newY.asInstanceOf[Int]
    //Propagate a new UpdatePositionMsg to all components
    var argList = List(newX, newY)
    components.values.foreach(_.handleMessage(new UpdatePositionMsg(this, argList)))
  }

  def move(newX : Float, newY : Float, newZ : Float)
  {
    X = newX.asInstanceOf[Int]
    Y = newY.asInstanceOf[Int]
    Z = newZ.asInstanceOf[Int]
    var argList = List(newX, newY, newZ)
    components.values.foreach(_.handleMessage(new UpdatePositionMsg(this, argList)))
  }

  def move(newX : Float, newY : Float, newZ : Float,
           newRX : Float, newRY : Float, newRZ : Float)
  {
    X = newX.asInstanceOf[Int]
    Y = newY.asInstanceOf[Int]
    Z = newZ.asInstanceOf[Int]
    rotX = newRX
    rotY = newRY
    rotZ = newRZ
    var argList = List(newX, newY, newZ,
                       rotX, rotY, rotZ)
    components.values.foreach(_.handleMessage(new UpdatePositionMsg(this, argList)))
  }


  override def handleMessage(msg : Msg)
  {
    msg match
    {
      case UpdatePositionMsg(p, argList) =>
      {
        //Update every MovableComponent
        argList match
        {
          case List(newX, newY) =>
          {
            //Simply call move method, so that it will
            //forward another UpdatePositionMsg to every component
            this.move(newX, newY)
          }

          case List(newX, newY, newZ) =>
          {
            this.move(newX, newY, newZ)
          }

          case List(newX, newY, newZ, newRX, newRY, newRZ) =>
          {
            this.move(newX, newY, newZ, newRX, newRY, newRZ)
          }

          case _ => ()
        }

      }

      case _ => ()
    }
  }
}

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

  def move(newX : Int, newY : Int)
  {
    X = newX
    Y = newY
    val filtered = components.values.filter(_.isInstanceOf[MovableComponent])
    filtered.foreach(_.asInstanceOf[MovableComponent].move(newX, newY))
  }

  def move(newX : Int, newY : Int, newZ : Int)
  {
    X = newX
    Y = newY
    Z = newZ
    val filtered = components.values.filter(_.isInstanceOf[MovableComponent])
    filtered.foreach(_.asInstanceOf[MovableComponent].move(newX, newY, newZ))
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
    val filtered = components.values.filter(_.isInstanceOf[MovableComponent])
    filtered.foreach(_.asInstanceOf[MovableComponent].move(newX, newY, newZ,
                                                           newRX, newRY, newRZ))
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
            val filtered = components.values.filter(_.isInstanceOf[MovableComponent])
            filtered.foreach(_.asInstanceOf[MovableComponent].move(
              newX.asInstanceOf[Int],
              newY.asInstanceOf[Int])
            )
          }

          case List(newX, newY, newZ) =>
          {
            val filtered = components.values.filter(_.isInstanceOf[MovableComponent])
            filtered.foreach(_.asInstanceOf[MovableComponent].move(
              newX.asInstanceOf[Int],
              newY.asInstanceOf[Int],
              newZ.asInstanceOf[Int])
            )
          }

          case List(newX, newY, newZ, newRX, newRY, newRZ) =>
          {
            val filtered = components.values.filter(_.isInstanceOf[MovableComponent])
            filtered.foreach(_.asInstanceOf[MovableComponent].move(
              newX.asInstanceOf[Int],
              newY.asInstanceOf[Int],
              newZ.asInstanceOf[Int],
              newRX, newRY, newRZ)
            )
          }

          case _ => ()
        }

      }

      case _ => ()
    }
  }
}

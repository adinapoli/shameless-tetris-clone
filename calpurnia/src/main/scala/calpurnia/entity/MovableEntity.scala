package calpurnia.entity

import calpurnia.component.MovableComponent
import calpurnia.messaging.UpdatePositionMsg
import calpurnia.{Component, Msg, Entity}

trait MovableEntity extends Entity{
  Id = "MovableEntity"
  var X : Int = 0
  var Y : Int = 0

  def move(newX : Int, newY : Int)
  {
    X = newX
    Y = newY
    val filtered = components.values.filter(_.isInstanceOf[MovableComponent])
    filtered.foreach(_.asInstanceOf[MovableComponent].move(newX, newY))
  }

  override def handleMessage(msg : Msg)
  {
    msg match
    {
      case UpdatePositionMsg(p, argMap) =>
      {
        //Update every MovableComponent
        val newX : Int = argMap("newX").asInstanceOf[Int]
        val newY : Int = argMap("newY").asInstanceOf[Int]
        val filtered = components.values.filter(_.isInstanceOf[MovableComponent])
        filtered.foreach(_.asInstanceOf[MovableComponent].move(newX, newY))
      }

      case _ => ()
    }
  }
}

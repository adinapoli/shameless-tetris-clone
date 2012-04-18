package calpurnia.component.physics.box2d

import com.badlogic.gdx.physics.box2d._
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import calpurnia.manager.PhysicsManager
import calpurnia.messaging.UpdatePositionMsg
import calpurnia.entity.MovableEntity
import util.logging.ConsoleLogger


class DynamicBoxComponent(parent: MovableEntity, width: Float,
                          height: Float, density: Float)
  extends PhysicComponent with ConsoleLogger{

  Id = "DynamicBoxComponent"
  onCreate

  def onCreate {
    //Create a box
    val definition: BodyDef = new BodyDef()
    definition.`type` = BodyType.DynamicBody

    PhysicsManager.world match {
      case Some(w) => {
        body = Some(w.createBody(definition))
        val poly: PolygonShape = new PolygonShape()
        poly.setAsBox(width / 2.0f, height / 2.0f)
        body.get.createFixture(poly, density)
        poly.dispose()
      }

      case None => ()
    }
  }

  def onAttach {
    //Set the position accordingly to parent position
    body.get.setTransform(
      parent.X + width / 2.0f,
      parent.Y + height / 2.0f,
      parent.rotZ
    )
  }


  def onDetach {}


  def update {

    //Tell the world the new position for this entity.
    val newX: Float = body.get.getTransform.getPosition.x - width / 2.0f
    val newY: Float = body.get.getTransform.getPosition.y - height / 2.0f
    val newAngle: Float = body.get.getTransform.getRotation

    if (newX != X || newY != Y || newAngle != rotZ) {
      val argList = List(
        newX,
        newY,
        0.0f,
        0.0f,
        0.0f,
        newAngle)
      parent.handleMessage(UpdatePositionMsg(this, argList))
    }
  }


  override def move(newX: Int, newY: Int) {

    body match {
      case Some(b) => {
        val px = newX + width / 2.0f
        val py = newY + height / 2.0f
        b.setTransform(px, py, 0)
      }
      case None => ()
    }

    super.move(newX, newY)
  }

  override def move(newX : Int, newY : Int, newZ : Int,
                    newRX : Float, newRY : Float, newRZ : Float)
  {
    body match {
      case Some(b) => {
        val px = newX + width / 2.0f
        val py = newY + height / 2.0f
        b.setTransform(px, py, newRZ)
      }
      case None => ()
    }

    super.move(newX, newY, newZ, newRX, newRY, newRZ)
  }
}

package calpurnia.component.physics

import com.badlogic.gdx.physics.box2d._
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import calpurnia.manager.PhysicsManager
import calpurnia.messaging.UpdatePositionMsg
import calpurnia.entity.MovableEntity


class DynamicBoxComponent(parent: MovableEntity, width: Float,
                          height: Float, density: Float)
  extends PhysicComponent{

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
        poly.setAsBox(width/2.0f, height/2.0f)
        body.get.createFixture(poly, density)
        poly.dispose()
      }

      case None => ()
    }
  }

  def onAttach {
    //Set the position accordingly to parent position
    body.get.setTransform(parent.X + width/2.0f,
                          parent.Y + height/2.0f, 0)
  }


  def onDetach {}


  def update {

    //Tell the world the new position for this entity.
    val newX = body.get.getTransform.getPosition.x - width/2.0f
    val newY = body.get.getTransform.getPosition.y - height/2.0f

    if (newX != X || newY != Y) {
      val argMap = Map("newX" -> newX.asInstanceOf[Int],
                       "newY" -> newY.asInstanceOf[Int])
      parent.handleMessage(UpdatePositionMsg(this, argMap))
    }
  }


  override def move(newX: Int, newY: Int) {

    //Coordinates arrives from the outside in pixels,
    //we need to convert into world coords.
    body match {
      case Some(b) =>
        {
          val px = newX + width/2.0f
          val py = newY + height/2.0f
          b.setTransform(px,py, 0)
        }
      case None => ()
    }

    super.move(newX, newY)
  }
}

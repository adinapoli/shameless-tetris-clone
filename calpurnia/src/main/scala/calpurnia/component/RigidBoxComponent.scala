package calpurnia.component


import com.badlogic.gdx.physics.box2d._
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import calpurnia.{PhysicManager}
import calpurnia.messaging.UpdatePositionMsg
import calpurnia.entity.MovableEntity

/**
 * Created with IntelliJ IDEA.
 * User: alfredodinapoli
 * Date: 12/04/12
 * Time: 20:43
 * A simple rigidBox component, that model a box who responds to
 * physics stimulus.
 */

class RigidBoxComponent(parent : MovableEntity, width : Float,
                        height : Float, density : Float)
  extends PhysicComponent{

  Id = "RigidBoxComponent"
  onCreate

  def onCreate{
    //Create a box
    val definition : BodyDef = new BodyDef()
    definition.`type` = BodyType.DynamicBody

    PhysicManager.world match{
      case Some(w) =>
      {
        body = Some(w.createBody(definition))
        val poly : PolygonShape = new PolygonShape()
        poly.setAsBox(width, height)
        body.get.createFixture(poly, density)
        poly.dispose()
      }

      case None => ()
    }
  }

  def onAttach {
    //Set the position accordingly to parent position
    body.get.setTransform(parent.X, parent.Y, 0)
  }


  def onDetach {}


  def update {

    //Tell the world the new position for this entity.
    val newX = body.get.getTransform.getPosition.x.asInstanceOf[Int]
    val newY = body.get.getTransform.getPosition.y.asInstanceOf[Int]
    val argMap = Map("newX" -> newX, "newY" -> newY)
    parent.handleMessage(UpdatePositionMsg(this, argMap))
  }


  override def move(newX : Int, newY : Int)
  {
    //Set also the position of the rigid body
    body match
    {
      case Some(b) => b.setTransform(newX, newY, 0)
      case None => ()
    }

    super.move(newX,newY)
  }
}

package calpurnia.component.physics.box2d

import calpurnia.entity.MovableEntity
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import calpurnia.manager.PhysicsManager
import com.badlogic.gdx.physics.box2d.{PolygonShape, BodyDef}

/**
 * Created with IntelliJ IDEA.
 * User: alfredodinapoli
 * Date: 14/04/12
 * Time: 18:27
 * A kinematic box component, i.e a component that doesn't respond
 * to physics stimulations, but can be used for static object that
 * requires collision detection and other handy features.
 */

class KinematicBoxComponent(parent: MovableEntity, width: Float,
                            height: Float, density: Float)
  extends PhysicComponent {

  Id = "KinematicBoxComponent"
  onCreate

  def onCreate {

    val definition: BodyDef = new BodyDef()
    definition.`type` = BodyType.KinematicBody

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
    //To decide
  }


  override def handleMessage(msg : Msg)
  {
    //Move logic
    msg match
    {
      case UpdatePositionMsg(p, argList) =>
      {
        argList match
        {
          case List(newX, newY) =>
          {
            //Updates body position in the world
            body match {
              case Some(b) => b.setTransform(newX + width / 2.0f,
                                             newY + height / 2.0f, 0)
              case None => ()
            }
          }

          case _ => ()
        }
      }
      case _ => ()
    }
  }
}

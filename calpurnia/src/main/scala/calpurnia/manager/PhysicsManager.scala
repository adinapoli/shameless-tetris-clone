package calpurnia.manager

import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.Gdx


/**
 * Created with IntelliJ IDEA.
 * User: alfredodinapoli
 * Date: 12/04/12
 * Time: 21:06
 * A simple PhysicService. Need to decide if is worth using it or not.
 */

object PhysicsManager {

  var gravity : (Float, Float) = (0,-20)
  val world : Option[World] = Some(new World(new Vector2(gravity._1, gravity._2), true))


  def gravity_(newValue : (Float, Float))
  {
    gravity = newValue
    world match
    {
      case Some(w) => w.setGravity(new Vector2(gravity._1, gravity._2))
      case None => ()
    }
  }

  def update: Unit = {
    world match {
      case Some(w) => w.step(Gdx.graphics.getDeltaTime, 4, 4)
      case None => ()
    }

  }
}

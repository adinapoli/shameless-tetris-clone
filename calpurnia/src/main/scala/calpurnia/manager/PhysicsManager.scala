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
  val world_ : Option[World] = Some(new World(new Vector2(0, -20), true))

  //In box2D world, 1 meter = 30 pixel
  private val PIXEL_TO_METER : Float = 30.0f

  def ScreenToWorld(n : Int) : Float =
  {
    n / PIXEL_TO_METER
  }

  def WorldToScreen(n : Float) : Int =
  {
    (n * PIXEL_TO_METER).asInstanceOf[Int]
  }

  def world: Option[World] = {
    world_
  }

  def update: Unit = {
    world_ match {
      case Some(w) => w.step(Gdx.graphics.getDeltaTime, 4, 4)
      case None => ()
    }

  }
}

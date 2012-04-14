package calpurnia

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

object PhysicManager {
  val world_ : Option[World] = Some(new World(new Vector2(0, -20), true))
  def world : Option[World] = { world_ }

  def update : Unit = {
    world_ match
    {
      case Some(w) => w.step(Gdx.graphics.getDeltaTime, 3, 3)
      case None => ()
    }

  }
}

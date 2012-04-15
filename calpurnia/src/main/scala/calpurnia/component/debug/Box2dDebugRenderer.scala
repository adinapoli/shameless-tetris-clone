package calpurnia.component.debug

import calpurnia.component.DrawableComponent
import calpurnia.manager.PhysicsManager
import com.badlogic.gdx.physics.box2d.{Box2DDebugRenderer => DebugRenderer}
import com.badlogic.gdx.graphics.OrthographicCamera

/**
 * Created with IntelliJ IDEA.
 * User: alfredodinapoli
 * Date: 14/04/12
 * Time: 19:09
 * Debug purpose only. Do not use in production!
 */

class Box2dDebugRenderer(width : Int, height : Int) extends DrawableComponent{

  Id = "Box2dRenderer"
  val camera = new OrthographicCamera(width, height)
  val renderer = new DebugRenderer(true, true, true, true)
  onCreate

  def onCreate {
    camera.position.set(width/2,height/2,0)
  }

  def onAttach {}

  def onDetach {}

  def update {

    PhysicsManager.world match
    {
      case Some(w) =>
      {
        camera.update()
        renderer.render(w, camera.combined)
      }
      case None => ()
    }
  }

  def draw {}
}

package asoup

import com.badlogic.gdx._
import graphics.{GL10}
import calpurnia.entity.{DrawableEntity, FPSCounter}
import calpurnia.component.{RigidBoxComponent, TextRenderer, Renderer2D}
import calpurnia.{PhysicManager, Manager}

class Game extends ApplicationListener {

  var debugHUD : Manager = new Object with Manager
  var graphicsManager : Manager = new Object with Manager

  def create(): Unit = {

    graphicsManager.Id = "GraphicsManager"
    graphicsManager.attach(new DrawableEntity {
      Id = "bgEntity"
      attach(new Renderer2D(this, "backgrounds/bluebg.jpg"))
    })
    graphicsManager.attach(new DrawableEntity {
      Id = "crateEntity"
      attach(new RigidBoxComponent(this, 200, 200, 0))
      attach(new Renderer2D(this, "sprites/crate.png"))
      move(200, 200)
    })

    //Debug HUD creation
    debugHUD.Id = "DebugHUD"
    debugHUD.attach(new DrawableEntity {
      attach(new TextRenderer(this, "Shameless Tetris Clone"))
      move(150,470)
    })
    debugHUD.attach(new FPSCounter{
      move(10, 470)
    })
  }

  def render(){

    Gdx.gl.glClearColor(1.0f, 0.0f, 0.0f, 0.0f)
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)

    graphicsManager.update
    debugHUD.update
    PhysicManager.update
  }

  def resize(width: Int, height: Int): Unit = {}

  def pause(): Unit = {}

  def resume(): Unit = {}

  def dispose(): Unit = {}

}

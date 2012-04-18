package asoup

import com.badlogic.gdx._
import controllers.ShowPositionMouseController
import graphics.{GL10}
import calpurnia.entity.{DrawableEntity, FPSCounter}
import calpurnia.component.physics.box2d.{KinematicBoxComponent, DynamicBoxComponent}
import calpurnia.component.{TextRenderer, Renderer2D}
import calpurnia.manager.PhysicsManager
import calpurnia.{Entity, Manager}
import calpurnia.component.debug.Box2dDebugRenderer
import Const.{screenWidth, screenHeight}

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
      Id = "platformEntity"
      attach(new KinematicBoxComponent(this, 320, 32, 10))
      attach(new Renderer2D(this, "sprites/platform.png"))
    })
    graphicsManager.attach(new DrawableEntity {
      Id = "crateEntity"
      attach(new DynamicBoxComponent(this, 32, 32, 10))
      attach(new Renderer2D(this, "sprites/crate.png"))
      move(50, 400)
    })
    graphicsManager.attach(new DrawableEntity {
      Id = "crate2Entity"
      attach(new DynamicBoxComponent(this, 32, 32, 10))
      attach(new Renderer2D(this, "sprites/crate.png"))
      move(25, 32)
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

    debugHUD.attach(new Entity {
      attach(new ShowPositionMouseController(this, screenWidth, screenHeight))
    })

    debugHUD.attach(new Entity {
      attach(new Box2dDebugRenderer(screenWidth, screenHeight))
    })
  }

  def render(){

    Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 0.0f)
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)

    graphicsManager.update
    debugHUD.update
    PhysicsManager.update
  }

  def resize(width: Int, height: Int): Unit = {}

  def pause(): Unit = {}

  def resume(): Unit = {}

  def dispose(): Unit = {}

}

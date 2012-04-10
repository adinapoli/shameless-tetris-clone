package asoup

import com.badlogic.gdx._
import graphics.g2d.{TextureRegion, Sprite, BitmapFont, SpriteBatch}
import graphics.{Texture, GL10}
import calpurnia.Entity
import calpurnia.component.Renderer2D

class Game extends ApplicationListener {

  val textToDisplay : String = "Hello from Libgdx"
  var textBatch : Option[SpriteBatch] = None
  var font: Option[BitmapFont] = None
  var ent : Entity = new Object with Entity
  ent.id = "SoupEntity"

  def create(): Unit = {
    textBatch = Some(new SpriteBatch())
    font = Some(new BitmapFont())
    ent.attach(new Renderer2D("backgrounds/bluebg.jpg", 0, 0))
    ent.attach(new Renderer2D("sprites/soup.png", 200, 200))
    ent.attach(new Renderer2D("sprites/cake.png", 250, 250))
  }

  def render(): Unit = {

    Gdx.gl.glClearColor(1.0f, 0.0f, 0.0f, 0.0f)
    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT)

//    textBatch match {
//      case Some(batch) =>
//        batch.begin()
//        //Assuming that BitmapFont exists
//        font.get.draw(batch, textToDisplay, 100.0f, 100.0f)
//        batch.end()
//      case None => ()
//    }

    ent.update

  }

  def resize(width: Int, height: Int): Unit = {}

  def pause(): Unit = {}

  def resume(): Unit = {}

  def dispose(): Unit = {}

}

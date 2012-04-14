package calpurnia.entity

import calpurnia.Entity
import calpurnia.component.{DrawableComponent, TextRenderer}
import com.badlogic.gdx.Gdx

/**
 * Created with IntelliJ IDEA.
 * User: alfredodinapoli
 * Date: 10/04/12
 * Time: 18:46
 * A VERY simple FPS counter for the sake of not reinventing it every time.
 */

class FPSCounter extends DrawableEntity{

  Id = "FPSCounter"
  X = 10
  Y = 470
  private var elapsedTime_ : Float = 0.0f
  private var frameRate_ : Int = 0
  private var frameCounter_ : Int = 0
  onCreate

  def this(posX : Int, posY : Int)
  {
    this()
    this.X = posX
    this.Y = posY
  }

  override def onCreate {
      this.attach(new TextRenderer(this, "FPS:"))
  }

  override def update
  {
    elapsedTime_ = elapsedTime_ + Gdx.graphics.getDeltaTime()
    elapsedTime_ match
    {
      case e if e >= 1.0f =>
      {
        elapsedTime_ = 0.0f
        frameRate_ = frameCounter_
        frameCounter_ = 0
      }
      case _ => frameCounter_ = frameCounter_ + 1
    }

    ComponentById("FPS:") match
    {
      case Some(c) => c.asInstanceOf[TextRenderer].textToRender = "FPS:" ++ frameRate_.toString()
      case None => ()
    }

    //Call the traditional update-draw cycle of
    //every component
    super.update
  }


}

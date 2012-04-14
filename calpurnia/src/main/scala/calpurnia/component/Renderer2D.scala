package calpurnia.component

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.Gdx
import util.logging.ConsoleLogger
import calpurnia.{Entity, GraphicServices}

class Renderer2D(val parent : Entity,
                 val resourceName : String)
  extends DrawableComponent with ConsoleLogger
{
  //Primary constructor, call onCreate right after
  Id = resourceName.split("/").reverse(0) //Get as id the image name
  var texture : Option[Texture] = None
  onCreate

  def onCreate {
    texture = Some(new Texture((Gdx.files.internal(resourceName))))
    batch match
    {
      case Some(b) => ()
      case None => batch = GraphicServices.spriteBatch
    }
  }

  def onAttach {}

  def update {}

  override def move(newX : Int, newY : Int)
  {
    log("Rendered2d: Updating my position!")
    super.move(newX, newY)
  }

  def draw
  {
    batch match{
      case Some(b) =>

        texture match
        {
          case Some(t) => b.draw(texture.get, X, Y)
          case None => ()
        }

      case None => ()
    }
  }

  def onDetach {}
}
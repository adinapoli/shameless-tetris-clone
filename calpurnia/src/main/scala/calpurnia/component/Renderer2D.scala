package calpurnia.component

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.Gdx
import calpurnia.{Entity, GraphicServices}

class Renderer2D(val parent : Entity,
                 val resourceName : String)
  extends DrawableComponent
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
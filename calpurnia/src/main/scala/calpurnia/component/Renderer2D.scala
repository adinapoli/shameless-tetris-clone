package calpurnia.component

import calpurnia.ComponentTypes._
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.Gdx
import calpurnia.GraphicServices

class Renderer2D(val resourceName : String) extends DrawableComponent
{
  //Primary constructor, call onCreate right after
  Id = resourceName.split("/").reverse(0) //Get as id the image name
  var texture : Option[Texture] = None
  onCreate

  def this(name : String, x : Int, y : Int)
  {
    this(name)
    this.x = x
    this.y = y
    onCreate //call onCreate
  }

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
          case Some(t) => b.draw(texture.get, x, y)
          case None => ()
        }

      case None => ()
    }
  }

  def onDetatch {}
}
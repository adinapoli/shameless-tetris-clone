package calpurnia.component

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.Gdx
import calpurnia.{Entity, GraphicServices}
import com.badlogic.gdx.graphics.g2d.Sprite

class Renderer2D(val parent : Entity,
                 val resourceName : String)
  extends DrawableComponent
{
  //Primary constructor, call onCreate right after
  Id = resourceName.split("/").reverse(0) //Get as id the image name
  var texture : Option[Texture] = None
  var sprite : Option[Sprite] = None
  onCreate

  def onCreate {
    texture = Some(new Texture((Gdx.files.internal(resourceName))))
    sprite = Some(new Sprite(texture.get))
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
    sprite match
    {
      case Some(s) =>
      {
        s.setX(newX)
        s.setY(newY)
        super.move(newX, newY)
      }

      case None => ()
    }
  }

  override def move(newX : Int, newY : Int, newZ : Int,
                    newRX : Float, newRY : Float, newRZ : Float)
  {
    sprite match
    {
      case Some(s) =>
      {
        s.setX(newX)
        s.setY(newY)
        s.setRotation(newZ)
        super.move(newX, newY, newZ, newRX, newRY, newRZ)
      }

      case None => ()
    }


  }

  def draw
  {
    batch match{
      case Some(b) =>

        sprite match
        {
          case Some(s) => s.draw(b)
          case None => ()
        }

      case None => ()
    }
  }

  def onDetach {}
}
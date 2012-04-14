package calpurnia.component

import com.badlogic.gdx.graphics.g2d.BitmapFont
import calpurnia.{Entity, GraphicServices}

/**
 * Created with IntelliJ IDEA.
 * User: alfredodinapoli
 * Date: 10/04/12
 * Time: 18:36
 * A simple Component that display text
 */

class TextRenderer(val parent : Entity, var textToRender : String)
  extends DrawableComponent{

  Id = textToRender
  var font: Option[BitmapFont] = None
  onCreate

  def onCreate {

    font = Some(new BitmapFont())
    batch match
    {
      case Some(b) => ()
      case None => batch = GraphicServices.spriteBatch
    }
  }


  def onAttach {}


  def onDetach {}


  def update {}


  def draw {
    batch match{
      case Some(b) =>

        font match
        {
          case Some(f) => f.draw(b, textToRender, X, Y)
          case None => ()
        }

      case None => ()
    }
  }
}

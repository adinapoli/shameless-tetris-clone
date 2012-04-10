package calpurnia

import com.badlogic.gdx.graphics.g2d.SpriteBatch

/**
 * Created with IntelliJ IDEA.
 * User: Alfredo Di Napoli
 * Date: 10/04/12
 * Time: 17:11
 * This is a shared, immutable, and efficient place to get
 * a single spriteBatch that get all the drawing calls. It's thread
 * safe because the call to the draw method are serialized.
 */

object GraphicServices {
  val spriteBatch_ : Option[SpriteBatch] = Some(new SpriteBatch())
  def spriteBatch : Option[SpriteBatch] = { spriteBatch_ }
}

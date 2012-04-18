package calpurnia.component

import com.badlogic.gdx.graphics.g2d.SpriteBatch


trait DrawableComponent extends MovableComponent{

  Id = "DrawableComponent"
  var batch : Option[SpriteBatch] = None

  def draw
}

package calpurnia.component

import com.badlogic.gdx.graphics.g2d.SpriteBatch


trait DrawableComponent extends MovableComponent{

  Id = "DrawableComponentId"
  var batch : Option[SpriteBatch] = None

  def draw
}

package calpurnia.component

import calpurnia.Component
import calpurnia.ComponentTypes._
import com.badlogic.gdx.graphics.g2d.SpriteBatch


trait DrawableComponent extends Component{

  Id = "DrawableComponentId"
  var x : Int = 0
  var y : Int = 0
  var batch : Option[SpriteBatch] = None

  def move(newX : Int, newY : Int)
  {
    x = newX
    y = newY
  }

  def draw
}

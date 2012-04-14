package calpurnia.component

import calpurnia.Component

/**
 * Created with IntelliJ IDEA.
 * User: alfredodinapoli
 * Date: 11/04/12
 * Time: 10:07
 * To change this template use File | Settings | File Templates.
 */

trait MovableComponent extends Component{
  Id = "MovableComponent"
  var X : Int = 0
  var Y : Int = 0

  def move(newX : Int, newY : Int)
  {
    X = newX
    Y = newY
  }
}

package calpurnia.component

import com.badlogic.gdx.physics.box2d._

/**
 * Created with IntelliJ IDEA.
 * User: alfredodinapoli
 * Date: 12/04/12
 * Time: 20:38
 * A simple component bound to Box2D (rigidbody? Box? Physics?)
 */

trait PhysicComponent extends MovableComponent{

  Id = "PhysicComponent"
  var body : Option[Body] = None
}

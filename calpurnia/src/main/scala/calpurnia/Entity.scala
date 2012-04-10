package calpurnia

import calpurnia.ComponentTypes._
import component.DrawableComponent
import scala.collection.mutable.{LinkedHashMap => MutableMap, _}
import util.logging.ConsoleLogger

trait Entity{

  import EntityTypes._

  var id: EntityId = "GenericId"
  val components: MutableMap[ComponentId, Component] = MutableMap()

  /**
   * Attach a Component to the entity.
   * @param c A valid Component
   */
  def attach(c: Component) { components(c.Id) = c; c.onAttach }

  /**
   * Detach a Component from the entity.
   * @param c A valid Component
   */
  def detach(c: Component) { components -= c.Id; c.onDetatch }

  /**
   * Updates every Component, calling the update method on it.
   */
  def update {

    for (c <- components.values) c.update

    //Serialize all the drawing call to a single
    //spriteBatch for max performance
    GraphicServices.spriteBatch match
    {
      case Some(batch) =>
      {
        batch.begin()
        for (c <- components.values)
        {
          c match
          {
            case dc : DrawableComponent => dc.draw
            case _ => ()
          }
        }
        batch.end()
      }

      case None => ()
    }


  }
}

object EntityTypes {
  type EntityId = String
}
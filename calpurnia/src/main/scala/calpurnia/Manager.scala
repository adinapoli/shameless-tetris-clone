package calpurnia

/**
 * Created with IntelliJ IDEA.
 * User: alfredodinapoli
 * Date: 11/04/12
 * Time: 19:27
 * A simple container of related entities
 */

import scala.collection.mutable.{ LinkedHashMap => MutableMap, _}

trait Manager {

  import ManagerTypes._
  import EntityTypes._

  var Id: ManagerId = "ManagerId"
  val entities: MutableMap[EntityId, Entity] = MutableMap()

  /**
   * Attach an Entity to the manager.
   * @param e A valid entity
   */
  def attach(e: Entity) { entities(e.Id) = e; e.onAttach }

  /**
   * Detach an Entity from the manager.
   * @param e A valid entity
   */
  def detach(e: Entity) { entities -= e.Id; e.onDetach }


  /**
   * Retrieves the entity with the given id, if present.
   * @param id A valid Entity id
   */
  def EntityById(id : EntityId) : Option[Entity] =
  {
    try
      Some(this.entities(id))
    catch{ case _ => None }

  }


  /**
   * Perform some operation on the creation of thi entity.
   */
  def onCreate {}

  /**
   * Updates every Component, calling the update method on it.
   */
  def update { entities.values.foreach(_.update) }

}


object ManagerTypes {
  type ManagerId = String
}
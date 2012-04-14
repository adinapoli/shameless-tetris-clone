package calpurnia

import calpurnia.ComponentTypes._
import scala.collection.mutable.{LinkedHashMap => MutableMap, _}

trait Entity{

  import EntityTypes._

  var Id: EntityId = "GenericId"
  val components: MutableMap[ComponentId, Component] = MutableMap()


  /**
   * Speficy a set of actions performed when this entity
   * is created.
   */
  def onCreate{}


  /**
   * Specify a set of actions performed when this entity
   * is attached to a manager
   */
  def onAttach{}


  /**
   * Attach a Component to the entity.
   * @param c A valid Component
   */
  def attach(c: Component) { components(c.Id) = c; c.onAttach }


  /* Specify a set of actions performed when this entity is
   * detached from a manager.
   */
  def onDetach{}

  /**
   * Detach a Component from the entity.
   * @param c A valid Component
   */
  def detach(c: Component) { components -= c.Id; c.onDetach }


  /**
   * Retrieves the component with the given id, if present.
   * @param id A valid Component id
   */
  def ComponentById(id : ComponentId) : Option[Component] =
  {
    try
      Some(this.components(id))
    catch{ case _ => None }

  }


  def handleMessage(msg : Msg){}

  /**
   * Updates every Component, calling the update method on it.
   */
  def update { components.values.foreach(_.update) }
}

object EntityTypes {
  type EntityId = String
}
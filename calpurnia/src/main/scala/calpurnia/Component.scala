package calpurnia

trait Component {
  import calpurnia.ComponentTypes._
  var Id : ComponentId = "ComponentId"


  /**
   * Specify a set of operations that can be performed
   * by the component on its creation.
   */
  def onCreate : Unit

  /**
   * Specify a set of operations that can be performed
   * when the component is attached to an Entity.
   */
  def onAttach : Unit

  /**
   * Specify the behaviour of the component. The "meat"
   * goes here.
   */
  def update : Unit


  /**
   * Specify a set of operations that can be performed
   * when a component is detached from an Entity
   */
  def onDetach : Unit

}

object ComponentTypes {
  type ComponentId = String
}
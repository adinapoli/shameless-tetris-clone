package calpurnia.component

import calpurnia.{Entity, Component}


/**
 * Created with IntelliJ IDEA.
 * User: alfredodinapoli
 * Date: 11/04/12
 * Time: 19:47
 * A simple component to handle mouse input
 */

abstract class MouseInputHandler(relatedEntity : Entity,
                                 screenWidth : Int,
                                 screenHeight : Int) extends Component{

  def onCreate {}


  def onAttach {}


  def onDetach {}


  //Logic goes here
  def update
}

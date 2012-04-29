package calpurnia.component

import calpurnia.Component
import calpurnia.Msg
import calpurnia.messaging.UpdatePositionMsg

trait MovableComponent extends Component{
  Id = "MovableComponent"
  var X : Int = 0
  var Y : Int = 0
  var Z : Int = 0
  var rotX : Float = 0.0f
  var rotY : Float = 0.0f
  var rotZ : Float = 0.0f


  //Typically a MovableComponent will
  //respond to a single message: a message
  //that contains a position update
  def handleMessage(msg : Msg)
  {
    msg match
    {
      //Handle position change
      case UpdatePositionMsg(p, argList) =>
      {
        //Update my position
        argList match
        {
          case List(newX, newY) =>
          {
            X = newX.asInstanceOf[Int]
            Y = newY.asInstanceOf[Int]
          }

          case List(newX, newY, newZ) =>
          {
            X = newX.asInstanceOf[Int]
            Y = newY.asInstanceOf[Int]
            Z = newZ.asInstanceOf[Int]
          }

          case List(newX, newY, newZ, newRX, newRY, newRZ) =>
          {
            X = newX.asInstanceOf[Int]
            Y = newY.asInstanceOf[Int]
            Z = newZ.asInstanceOf[Int]
            rotX = newRX
            rotY = newRY
            rotZ = newRZ
          }

          case _ => ()
        }
      }

      //Fallback case: Unknown msg
      case _ => ()
    }
  }
}

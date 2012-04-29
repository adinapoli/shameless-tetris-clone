package calpurnia.messaging

import calpurnia.{Component, Msg}

class UpdatePositionMsg(val sender : Object,
                        val argList : List[Float]) extends Msg{
}


object UpdatePositionMsg
{

  def apply(sender : Object, argList : List[Float]) =
  {
    new UpdatePositionMsg(sender, argList)
  }

  def unapply(input : UpdatePositionMsg) =
  {
    Some((input.sender, input.argList))
  }
}

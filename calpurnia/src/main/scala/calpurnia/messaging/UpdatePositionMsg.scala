package calpurnia.messaging

import calpurnia.{Component, Msg}


class UpdatePositionMsg(val sender : Component,
                        val argMap : Map[String, AnyVal]) extends Msg{
}


object UpdatePositionMsg
{

  def apply(sender : Component, argMap : Map[String, AnyVal]) =
  {
    new UpdatePositionMsg(sender, argMap)
  }

  def unapply(input : UpdatePositionMsg) =
  {
    Some((input.sender, input.argMap))
  }
}

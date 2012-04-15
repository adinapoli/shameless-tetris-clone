package asoup.controllers

import calpurnia.component.MouseInputHandler
import calpurnia.Entity
import calpurnia.entity.MovableEntity
import com.badlogic.gdx.Input.Buttons
import com.badlogic.gdx.Gdx
import util.logging.ConsoleLogger


class ShowPositionMouseController(e : Entity, width : Int, height : Int)
  extends MouseInputHandler(e, width, height) with ConsoleLogger{


  def update{

    if(Gdx.input.isButtonPressed(Buttons.LEFT))
    {
      log("(" + Gdx.input.getX + "," + (height - Gdx.input.getY) + ")")
    }
  }
}

package asoup.controllers

import calpurnia.component.MouseInputHandler
import calpurnia.Entity
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Buttons
import calpurnia.entity.MovableEntity
import calpurnia.Utils._


class CrateMouseController(e : Entity, width : Int, height : Int)
  extends MouseInputHandler(e, width, height){

  def update{

    when(Gdx.input.isButtonPressed(Buttons.LEFT))
    {
      //try an hazardous cast into a MovableEntity
      e.asInstanceOf[MovableEntity].move(Gdx.input.getX, height - Gdx.input.getY)
    }
  }
}

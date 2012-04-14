package calpurnia.entity

import calpurnia.component.DrawableComponent
import calpurnia.{GraphicServices, Entity}


trait DrawableEntity extends MovableEntity{


  override def update
  {
    super.update

    //Also draw every component
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

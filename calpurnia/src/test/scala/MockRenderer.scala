import calpurnia.component.DrawableComponent
import calpurnia.Entity


class MockRenderer(val entity : Entity) extends DrawableComponent {

  Id = "MockRenderer"
  var upgradeCounter = 0

  def draw {}
  def onAttach {}
  def onCreate {}
  def onDetach {}
  def update {}

  override def move(newX : Int, newY : Int)
  {
    upgradeCounter += 1
    super.move(newX, newY)
  }

  override def move(newX : Int, newY : Int, newZ : Int,
                    newRX : Float, newRY : Float, newRZ : Float)
  {
    upgradeCounter += 1
    super.move(newX, newY, newZ, newRX, newRY, newRZ)
  }
}

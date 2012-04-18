import calpurnia.component.{MovableComponent, DrawableComponent}
import org.scalatest._

class DrawableComponentSpec extends FlatSpec {


  def fixture =
    new {
      val c = new Object with DrawableComponent {
        def onAttach {}

        def onCreate {}

        def onDetach {}

        def update {}

        def draw{}
      }
    }


  "A DrawableComponent" should "have a well-defined starting Id" in
    {
      val f = fixture
      assert(f.c.Id == "DrawableComponent")
    }

  it should "preserves its id when casted down to MovableComponent" in
    {
      val f = fixture
      f.c.Id = "newId"
      assert(f.c.asInstanceOf[MovableComponent].Id == "newId")
    }

  it should "change its (X,Y,Z) correctly" in
    {
      val f = fixture
      val (newX, newY, newZ) = (10,20,30)
      f.c.move(newX, newY, newZ)
      assert(f.c.X == newX)
      assert(f.c.Y == newY)
      assert(f.c.Z == newZ)
    }

  it should "change its (rotX, rotY, rotZ) correctly" in
    {
      val f = fixture
      val (newX, newY, newZ) = (10,20,30)
      val (newRX, newRY, newRZ) = (3.0f, 4.0f, 5.0f)
      f.c.move(newX, newY, newZ, newRX, newRY, newRZ)
      assert(f.c.X == newX)
      assert(f.c.Y == newY)
      assert(f.c.Z == newZ)
      assert(f.c.rotX == newRX)
      assert(f.c.rotY == newRY)
      assert(f.c.rotZ == newRZ)
    }

  it should "preserves its (X,Y,Z) when casted down to MovableComponent" in
    {
      val f = fixture
      val (newX, newY, newZ) = (10,20,30)
      f.c.move(newX, newY, newZ)
      val castedDown = f.c.asInstanceOf[MovableComponent]
      assert(castedDown.X == newX, "expected " + newX + ", found: " + castedDown.X)
      assert(castedDown.Y == newY, "expected " + newY + ", found: " + castedDown.Y)
      assert(castedDown.Z == newZ, "expected " + newZ + ", found: " + castedDown.Z)
    }

  it should "preserves its (rotX, rotY, rotZ) when casted down to MovableComponent" in
    {
      val f = fixture
      val (newRX, newRY, newRZ) = (1.0f,2.0f,3.0f)
      f.c.move(0, 0, 0, newRX, newRY, newRZ)
      val castedDown = f.c.asInstanceOf[MovableComponent]
      assert(castedDown.rotX == newRX, "expected " + newRX + ", found: " + castedDown.rotX)
      assert(castedDown.rotY == newRY, "expected " + newRY + ", found: " + castedDown.rotY)
      assert(castedDown.rotZ == newRZ, "expected " + newRZ + ", found: " + castedDown.rotZ)
    }
}

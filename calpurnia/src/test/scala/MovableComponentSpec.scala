import calpurnia.Component
import calpurnia.component.MovableComponent
import org.scalatest.FlatSpec

class MovableComponentSpec extends FlatSpec {

  def fixture =
    new
      {
        val c = new Object with MovableComponent
        {
          def onAttach {}
          def onCreate {}
          def onDetach {}
          def update {}
        }
      }

  "A MovableComponent" should "have a well-defined starting Id" in
    {
      val f = fixture
      assert(f.c.Id == "MovableComponent")
    }

  it should "preserves its id when casted down" in
    {
      val f = fixture
      f.c.Id = "newId"
      assert(f.c.asInstanceOf[Component].Id == "newId")
    }

  it should "have a well-defined starting position" in
    {
      val f = fixture
      assert(f.c.X == 0)
      assert(f.c.Y == 0)
      assert(f.c.Z == 0)
    }

  it should "have a well-defined starting rotation angles" in
    {
      val f = fixture
      assert(f.c.rotX == 0.0f)
      assert(f.c.rotY == 0.0f)
      assert(f.c.rotZ == 0.0f)
    }

  it should "change its (X,Y) position when asked to" in
    {
      val f = fixture
      val (newX, newY) = (10,20)
      f.c.move(newX,newY)
      assert(f.c.X == newX)
      assert(f.c.Y == newY)
    }

  it should "change its (X,Y,Z) position when asked to" in
    {
      val f = fixture
      val (newX, newY, newZ) = (10,20,30)
      f.c.move(newX,newY, newZ)
      assert(f.c.X == newX)
      assert(f.c.Y == newY)
      assert(f.c.Z == newZ)
    }

  it should "change its (X,Y,Z, rotX, rotY, rotZ) when asked to" in
    {
      val f = fixture
      val (newX, newY, newZ) = (10,20,30)
      val (newRX, newRY, newRZ) = (2.0f, 3.0f, 4.0f)
      f.c.move(newX,newY, newZ, newRX, newRY, newRZ)
      assert(f.c.X == newX)
      assert(f.c.Y == newY)
      assert(f.c.Z == newZ)
      assert(f.c.rotX == newRX)
      assert(f.c.rotY == newRY)
      assert(f.c.rotZ == newRZ)
    }

}

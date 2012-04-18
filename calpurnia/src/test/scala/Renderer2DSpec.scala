import calpurnia.entity.DrawableEntity
import org.scalatest.FlatSpec

class Renderer2DSpec extends FlatSpec {
  def fixture =
    new
      {
        val e = new DrawableEntity { Id = "Entity1"}
        val c = new MockRenderer(e)
      }

    "A Renderer2D" should "have a well defined starting Id" in
      {
        val f = fixture
        assert(f.c.Id == "MockRenderer")
      }

    it should "upgrade its own state when moved by (X,Y)" in
      {
        val f = fixture
        f.c.move(10,20)
        assert(f.c.X == 10)
        assert(f.c.Y == 20)
        assert(f.c.upgradeCounter == 1)
      }

    it should "upgrade its own state when moved by (X,Y,Z,Rx,Ry,Rz)" in
      {
        val f = fixture
        f.c.upgradeCounter = 0
        f.c.move(10,20,30,1.0f,2.0f,3.0f)
        assert(f.c.X == 10)
        assert(f.c.Y == 20)
        assert(f.c.Z == 30)
        assert(f.c.rotX == 1.0f)
        assert(f.c.rotY == 2.0f)
        assert(f.c.rotZ == 3.0f)
        assert(f.c.upgradeCounter == 1, "found: " + f.c.upgradeCounter)
      }
}

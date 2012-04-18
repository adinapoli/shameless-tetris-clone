import calpurnia.{Entity, Component}
import org.scalatest.FlatSpec


class ComponentSpec extends FlatSpec{

  def fixture =
    new {
      val c = new Object with Component
      {
        def onAttach {}
        def onCreate {}
        def onDetach {}
        def update {}
      }
    }

  "A component" should "have a fixed Id on creation" in
    {
      val f = fixture
      assert(f.c.Id == "ComponentId")
    }

  it should "change its Id when required" in
    {
      val f = fixture
      f.c.Id = "newId"
      assert(f.c.Id == "newId")
    }
}

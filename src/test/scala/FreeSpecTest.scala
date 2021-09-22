import org.scalatest.freespec.AnyFreeSpec
import org.junit.jupiter.api.Assertions.assertFalse

class FreeSpecTest extends AnyFreeSpec {

  "A Set" - {
    "when empty" - {
      "should have size 0" in {
        assert(Set.empty.size == 0)
      }
      "should produce NoSuchElementException when head is invoked" in {
        assertThrows[NoSuchElementException] {
          Set.empty.head
        }
      }
    }
    "when non empty" - {
      val a:Set[Int] = Set(1,2,3)

      "should contains something" in {
        assertFalse(a.isEmpty)
      }
    }
  }
}
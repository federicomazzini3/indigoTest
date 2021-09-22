import org.scalatest.flatspec.AnyFlatSpec
import org.junit.jupiter.api.Assertions.assertFalse

class FlatSpecTest extends AnyFlatSpec {

  "An empty Set" should "have size 0" in {
    assert(Set.empty.size == 0)
  }

  it should "produce NoSuchElementException when head is invoked" in {
    assertThrows[NoSuchElementException] {
      Set.empty.head
    }
  }

  "A non empty set" should "contains something" in {
    val a = Set(1,2,3)
    assertFalse(a.isEmpty)
  }
}

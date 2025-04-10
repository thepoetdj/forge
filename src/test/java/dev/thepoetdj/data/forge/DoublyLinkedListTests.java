package dev.thepoetdj.data.forge;

import dev.thepoetdj.data.forge.api.LinkedList;
import dev.thepoetdj.data.forge.service.LinkedListFactory;
import java.util.Optional;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTests {
  LinkedList<Integer> list;

  @BeforeEach
  void initialize() {
    list = LinkedListFactory.bi();
  }

  @Test
  void itShouldNotAllow_toAppend_nullElementToLinkedList() {
    Assertions.assertFalse(list.append(null));
  }

  @Test
  void itShould_remove_theLastElementFromLinkedList() {
    IntStream.rangeClosed(1, 7).forEach(list::append);
    boolean removedMatchingLast = IntStream.iterate(7, i -> i - 1)
        .limit(7)
        .allMatch(i -> list.remove().filter(integer -> i == integer).isPresent());
    Assertions.assertTrue(removedMatchingLast);
  }

  @Test
  void itShouldNotAllow_toRemove_fromEmptyLinkedList() {
    Assertions.assertTrue(list.remove().isEmpty());
  }

  @Test
  void itShouldNotAllow_toGet_fromEmptyLinkedList() {
    Assertions.assertTrue(list.last().isEmpty());
  }

  @Test
  void itShould_get_theLastElementFromLinkedList() {
    IntStream.rangeClosed(1, 10).forEach(list::append);
    Optional<Integer> last = list.last();
    Assertions.assertTrue(last.isPresent());
    Assertions.assertEquals(10, last.get());
  }
}

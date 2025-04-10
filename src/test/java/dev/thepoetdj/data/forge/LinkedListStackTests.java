package dev.thepoetdj.data.forge;

import dev.thepoetdj.data.forge.api.Stack;
import dev.thepoetdj.data.forge.service.StackFactory;
import java.util.Optional;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListStackTests {
  Stack<Integer> stack;

  @BeforeEach
  void initialize() {
    stack = StackFactory.create();
  }

  @Test
  void itShouldNotAllow_toPush_nullElementOnTheStack() {
    Assertions.assertFalse(stack.push(null));
  }

  @Test
  void itShouldNotAllow_toPop_fromAnEmptyStack() {
    Assertions.assertTrue(stack.pop().isEmpty());
  }

  @Test
  void itShouldNotAllow_toPeek_fromAnEmptyStack() {
    Assertions.assertTrue(stack.peek().isEmpty());
  }

  @Test
  void itShouldAllow_toPush_nonNullElementsOnTheStack() {
    Assertions.assertTrue(IntStream.rangeClosed(1, 10).allMatch(stack::push));
  }

  @Test
  void itShould_pop_theTopElementFromTheStack() {
    int range = 13;
    IntStream.rangeClosed(1, range).forEach(stack::push);
    boolean poppedMatching = IntStream.iterate(range, i -> i - 1)
        .limit(range)
        .allMatch(expected ->
            stack.pop().filter(popped -> expected == popped).isPresent());
    Assertions.assertTrue(poppedMatching);
  }

  @Test
  void itShould_peek_theTopElementOfTheStack() {
    IntStream.rangeClosed(1, 4).forEach(stack::push);
    Optional<Integer> peeked = stack.peek();
    Optional<Integer> popped = stack.pop();
    Assertions.assertTrue(peeked.isPresent());
    Assertions.assertTrue(popped.isPresent());
    Assertions.assertEquals(popped.get(), peeked.get());
  }
}

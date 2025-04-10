package dev.thepoetdj.data.forge;

import dev.thepoetdj.data.forge.api.Stack;
import dev.thepoetdj.data.forge.service.StackFactory;
import java.util.Optional;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ArrayListStackTests {
  @ParameterizedTest
  @ValueSource(ints = {Integer.MIN_VALUE, 0})
  void itShouldNotAllow_toInitializeStack_withInvalidCapacity(int capacity) {
    Assertions.assertTrue(StackFactory.create(capacity).isEmpty());
  }

  @Nested
  class InitializedArrayListStackTests {
    private static final int TEST_CAPACITY = 5;
    Stack<Integer> result;

    @BeforeEach
    void initialize() {
      Optional<Stack<Integer>> maybeCreated = StackFactory.create(TEST_CAPACITY);
      result = maybeCreated.orElseThrow();
    }

    @Test
    void itShouldNotAllow_toPush_beyondAllowedCapacityOfStack() {
      boolean allPushed = IntStream.rangeClosed(1, TEST_CAPACITY).allMatch(result::push);
      Assertions.assertTrue(allPushed);
      Assertions.assertFalse(result.push(3924));
    }

    @Test
    void itShouldNotAllow_toPush_nullElementsOnStack() {
      Assertions.assertFalse(result.push(null));
    }

    @Test
    void itShouldNotAllow_toPop_fromAnEmptyStack() {
      IntStream.rangeClosed(1, TEST_CAPACITY).forEach(result::push);
      IntStream.rangeClosed(1, TEST_CAPACITY).forEach(i -> result.pop());
      Assertions.assertFalse(result.pop().isPresent());
    }

    @Test
    void itShould_pop_theTopElementOfStack() {
      IntStream.rangeClosed(1, TEST_CAPACITY).forEach(result::push);
      Assertions.assertEquals(TEST_CAPACITY, result.pop().orElseThrow());
    }

    @Test
    void itShouldNotAllow_toPeek_fromAnEmptyStack() {
      IntStream.rangeClosed(1, TEST_CAPACITY).forEach(result::push);
      IntStream.rangeClosed(1, TEST_CAPACITY).forEach(i -> result.pop());
      Assertions.assertFalse(result.peek().isPresent());
    }

    @Test
    void itShould_peek_theTopElementOfStack() {
      IntStream.rangeClosed(1, TEST_CAPACITY).forEach(result::push);
      Assertions.assertEquals(TEST_CAPACITY, result.peek().orElseThrow());
    }
  }
}

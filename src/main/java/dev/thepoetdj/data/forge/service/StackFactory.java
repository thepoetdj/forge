package dev.thepoetdj.data.forge.service;

import dev.thepoetdj.data.forge.api.Stack;
import dev.thepoetdj.data.forge.core.ArrayStack;
import dev.thepoetdj.data.forge.core.LinkedListStack;
import java.util.Optional;

/**
 * A factory to create instances of the {@link Stack}.
 *
 * @author Dhruv Joshi
 * @since 0.1.0
 */
public final class StackFactory {
  /**
   * Initializes a fixed capacity {@link Stack}.
   *
   * @param capacity the maximum allowed capacity of returned stack.
   * @param <T> Type of stored elements.
   * @return an {@code Optional} containing the instance of a fixed capacity {@code Stack}, or an empty
   *     {@code Optional} when capacity is negative or zero.
   * @since 0.1.0
   */
  public static <T> Optional<Stack<T>> create(int capacity) {
    if (capacity <= 0) return Optional.empty();
    return Optional.of(new ArrayStack<>(capacity));
  }

  /**
   * Initializes a {@link Stack} with no predefined capacity. The stack will be allowed to grow dynamically, limited
   * only by the available free memory of the underlying system.
   *
   * @param <T> Type of stored elements.
   * @return a dynamically growable {@code Stack}.
   * @since 0.1.0
   */
  public static <T> Stack<T> create() {
    return new LinkedListStack<>();
  }
}

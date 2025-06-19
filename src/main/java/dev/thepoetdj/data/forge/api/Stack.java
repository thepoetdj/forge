package dev.thepoetdj.data.forge.api;

import dev.thepoetdj.data.forge.core.ArrayStack;
import java.util.Optional;

/**
 * A {@code Stack} to store and retrieve elements in last-in-first-out (LIFO) manner.
 *
 * @param <T> Type of stored elements.
 * @author Dhruv Joshi
 * @since 0.1.0
 */
public sealed interface Stack<T> permits ArrayStack {
  /**
   * Stores the {@code element} at the top of this stack.
   *
   * @param element the element to be stored.
   * @return {@code true} when the element is stored, or {@code false} when this stack has reached its maximum allowed
   *     capacity.
   * @since 0.1.0
   */
  boolean push(T element);

  /**
   * Removes the top element from this stack.
   *
   * @return an {@code Optional} with the removed element, or an empty {@code Optional} when this stack has no
   *     elements.
   * @since 0.1.0
   */
  Optional<T> pop();

  /**
   * Provides the top element from this stack without removing it.
   *
   * @return an {@code Optional} containing the top element of this stack, or an empty {@code Optional} when this
   *     stack has no elements.
   * @since 0.1.0
   */
  Optional<T> peek();
}

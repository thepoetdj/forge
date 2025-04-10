package dev.thepoetdj.data.forge.api;

import dev.thepoetdj.data.forge.core.DoublyLinkedList;
import java.util.Optional;

/**
 * A {@code LinkedList} to store and search elements sequentially.
 *
 * @param <T> Type of stored elements.
 * @author Dhruv Joshi
 * @since 0.1.0
 */
public sealed interface LinkedList<T> permits DoublyLinkedList {
  /**
   * Inserts the given element at the end of this list, except {@code null}. This operation guarantees insertion of
   * non-null elements.
   *
   * @param element the element to insert.
   * @return {@code true} when element was inserted, otherwise {@code false}.
   * @since 0.1.0
   */
  boolean append(T element);

  /**
   * Removes the last element from this list.
   *
   * @return an {@code Optional} representing the value of the last node, or an empty {@code Optional} when this list
   *     has no elements.
   * @since 0.1.0
   */
  Optional<T> remove();

  /**
   * Provides the last element of this list.
   *
   * @return an {@code Optional} with the last element, or an empty {@code Optional} when this list has no elements.
   * @since 0.1.0
   */
  Optional<T> last();

  /**
   * Checks whether this linked list contains any elements.
   *
   * @return {@code true} when there is at least one element present, {@code false} otherwise.
   * @since 0.2.0
   */
  boolean hasElements();
}

package dev.thepoetdj.data.forge.core;

import dev.thepoetdj.data.forge.api.LinkedList;
import java.util.Objects;
import java.util.Optional;

/**
 * Implements a {@code LinkedList} with bidirectional flow.
 *
 * @param <T> Type of stored elements.
 * @author Dhruv Joshi
 * @since 0.1.0
 */
public final class DoublyLinkedList<T> implements LinkedList<T> {
  private Node<T> tail;

  @Override
  public boolean append(T element) {
    if (Objects.isNull(element)) {
      return false;
    }
    Node<T> next = new Node<>(element);
    if (this.hasElements()) {
      next.prev = this.tail;
      this.tail.next = next;
    }
    this.tail = next;
    return true;
  }

  @Override
  public Optional<T> remove() {
    if (!this.hasElements()) return Optional.empty();
    Optional<T> lastElement = Optional.of(this.tail.element);
    if (Objects.isNull(this.tail.prev) && Objects.isNull(this.tail.next)) {
      this.tail = null;
    } else {
      this.tail = this.tail.prev;
      this.tail.next = null;
    }
    return lastElement;
  }

  @Override
  public Optional<T> last() {
    return this.hasElements() ? Optional.of(this.tail.element) : Optional.empty();
  }

  @Override
  public boolean hasElements() {
    return Objects.nonNull(this.tail);
  }
}

package dev.thepoetdj.data.forge.core;

import dev.thepoetdj.data.forge.api.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * An {@code ArrayList} implementation of {@code Stack}.
 *
 * @param <T> Type of stored elements of the underlying list.
 * @author Dhruv Joshi
 * @since 0.1.0
 */
public final class ArrayListStack<T> implements Stack<T> {
  private final List<T> elements;
  private final int capacity;

  /**
   * Constructs an instance of the {@code ArrayListStack} with given capacity.
   *
   * @param capacity the total capacity of this stack.
   * @since 0.1.0
   */
  public ArrayListStack(int capacity) {
    this.elements = new ArrayList<>(capacity);
    this.capacity = capacity;
  }

  @Override
  public boolean push(T element) {
    if (element == null || this.capacity == this.elements.size()) return false;
    return this.elements.add(element);
  }

  @Override
  public Optional<T> pop() {
    return this.isEmpty() ? Optional.empty() : Optional.of(this.elements.removeLast());
  }

  @Override
  public Optional<T> peek() {
    return this.isEmpty() ? Optional.empty() : Optional.of(this.elements.getLast());
  }

  private boolean isEmpty() {
    return this.elements.isEmpty();
  }
}

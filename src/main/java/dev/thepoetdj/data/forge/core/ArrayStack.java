package dev.thepoetdj.data.forge.core;

import dev.thepoetdj.data.forge.api.Stack;
import java.util.Optional;

/**
 * An {@code Array} implementation of {@code Stack}.
 *
 * @param <T> Type of stored elements of the underlying list.
 * @author Dhruv Joshi
 * @since 0.1.0
 */
public final class ArrayStack<T> implements Stack<T> {
  private static final int EMPTY = -1;
  private final Object[] elements;
  private final int capacity;
  private int top;

  /**
   * Constructs an instance of the {@code ArrayStack} with given capacity.
   *
   * @param capacity the total capacity of this stack.
   * @since 0.1.0
   */
  public ArrayStack(int capacity) {
    this.elements = new Object[capacity];
    this.capacity = capacity;
    this.top = EMPTY;
  }

  @Override
  public boolean push(T element) {
    if (element == null || this.capacity == this.top + 1) return false;
    this.elements[++this.top] = element;
    return true;
  }

  @SuppressWarnings({"unchecked"})
  @Override
  public Optional<T> pop() {
    return this.isEmpty() ? Optional.empty() : Optional.of((T) this.elements[this.top--]);
  }

  @SuppressWarnings({"unchecked"})
  @Override
  public Optional<T> peek() {
    return this.isEmpty() ? Optional.empty() : Optional.of((T) this.elements[this.top]);
  }

  private boolean isEmpty() {
    return this.top == EMPTY;
  }
}

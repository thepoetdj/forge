package dev.thepoetdj.data.forge.core;

import dev.thepoetdj.data.forge.api.LinkedList;
import dev.thepoetdj.data.forge.api.Stack;
import dev.thepoetdj.data.forge.service.LinkedListFactory;
import java.util.Optional;

/**
 * A {@code LinkedList} implementation of {@code Stack}.
 *
 * @param <T> Type of stored elements of LinkedList nodes.
 * @author Dhruv Joshi
 * @since 0.1.0
 */
public final class LinkedListStack<T> implements Stack<T> {
  LinkedList<T> top;

  public LinkedListStack() {
    this.top = LinkedListFactory.bi();
  }

  @Override
  public boolean push(T element) {
    return this.top.append(element);
  }

  @Override
  public Optional<T> pop() {
    return this.top.remove();
  }

  @Override
  public Optional<T> peek() {
    return this.top.last();
  }
}

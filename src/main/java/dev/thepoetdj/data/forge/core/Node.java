package dev.thepoetdj.data.forge.core;

/**
 * A {@code Node} containing the actual element, and links of the previous and next {@code Node}s in a list.
 *
 * @param <T> Type of element this node can have.
 * @since 0.2.0
 */
class Node<T> {
  final T element;
  Node<T> prev;
  Node<T> next;

  public Node(T element) {
    this.element = element;
  }
}

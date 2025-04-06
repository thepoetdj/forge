package dev.thepoetdj.data.forge.api;

import dev.thepoetdj.data.forge.core.DoublyLinkedList;

import java.util.Optional;

/**
 * A {@code LinkedList} to store and search elements sequentially.
 *
 * @param <T> Type of stored elements.
 *
 * @author Dhruv Joshi
 * @since 0.1.0
 */
public sealed interface LinkedList<T> permits DoublyLinkedList {
    /**
     * Inserts the given element at the end of this list, except {@code null}.
     * This operation guarantees insertion of non-null elements.
     *
     * @param element the element to insert.
     * @return {@code true} when element was inserted, otherwise {@code false}.
     *
     * @since 0.1.0
     */
    boolean append(T element);

    /**
     * Removes the last element from this list.
     *
     * @return an {@code Optional} representing the value of the last node, or
     *         an empty {@code Optional} when this list has no elements.
     *
     * @since 0.1.0
     */
    Optional<T> remove();

    /**
     * Provides the last element of this list.
     *
     * @return an {@code Optional} with the last element, or an empty
     *         {@code Optional} when this list has no elements.
     *
     * @since 0.1.0
     */
    Optional<T> last();

    /**
     * A {@code Node} containing the actual element, and links of the previous
     * and next {@code Node}s in a list.
     *
     * @param <T> Type of element this node can have.
     *
     * @since 0.1.0
     */
    class Node<T> {
        private final T element;
        private Node<T> prev;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
            this.prev = null;
            this.next = null;
        }

        public T getElement() {
            return this.element;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return this.prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}

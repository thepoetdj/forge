package dev.thepoetdj.data.forge.core;

import dev.thepoetdj.data.forge.api.LinkedList;

import java.util.Objects;
import java.util.Optional;

/**
 * Implements a {@code LinkedList} with bidirectional flow.
 *
 * @param <T> Type of stored elements.
 *
 * @author Dhruv Joshi
 * @since 0.1.0
 */
public final class DoublyLinkedList<T> implements LinkedList<T>, Verifiable {
    private Node<T> tail;

    @Override
    public boolean append(T element) {
        if (Objects.isNull(element)) {
            return false;
        }
        Node<T> next = new Node<>(element);
        if (!isEmpty()) {
            next.setPrev(this.tail);
            this.tail.setNext(next);
        }
        this.tail = next;
        return true;
    }

    @Override
    public Optional<T> remove() {
        if (isEmpty())
            return Optional.empty();
        Node<T> last = this.tail;
        this.tail = this.tail.getPrev();
        if (!isEmpty()) {
            this.tail.setNext(null);
        }
        return Optional.of(last.getElement());
    }

    @Override
    public Optional<T> last() {
        if (isEmpty())
            return Optional.empty();
        return Optional.of(this.tail.getElement());
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(this.tail);
    }
}

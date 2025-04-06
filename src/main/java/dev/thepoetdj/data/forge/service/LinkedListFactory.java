package dev.thepoetdj.data.forge.service;

import dev.thepoetdj.data.forge.api.LinkedList;
import dev.thepoetdj.data.forge.core.DoublyLinkedList;

/**
 * A factory to create instances of the {@link LinkedList}.
 *
 * @author Dhruv Joshi
 * @since 0.1.0
 */
public final class LinkedListFactory {
    /**
     * Initialize a linked list that can be traversed in both directions.
     *
     * @return a bidirectional {@code LinkedList}.
     * @param <T> Type of stored elements.
     *
     * @since 0.1.0
     */
    public static <T> LinkedList<T> bi() {
        return new DoublyLinkedList<>();
    }
}

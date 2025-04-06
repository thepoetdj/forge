package dev.thepoetdj.data.forge.core;

/**
 * A {@code Verifiable} lets its underlying data structure to verify its
 * current state before performing some operation.
 *
 * @author Dhruv Joshi
 * @since 0.1.0
 */
public interface Verifiable {
    /**
     * Checks whether there are any elements present.
     *
     * @return {@code true} when this data structure has no elements, otherwise
     *         {@code false}.
     *
     * @since 0.1.0
     */
    boolean isEmpty();
}

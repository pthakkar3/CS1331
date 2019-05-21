import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author rkaul7, mclayton34
 * @version 0.1
 * @param <E> the type of object contained in this list
 */
public class MyLinkedList<E> implements SimpleList<E>, Iterable<E> {
    private Node<E> head;
    private int size;

    /**
     * @return number of elements in this list
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * @return true if the list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Appends the specified element at the end of the list.
     *
     * @param e element to be inserted
     * @return true if the list has been modified, false otherwise
     */

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<E>(e);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> probe = head;
            while (probe.getNext() != null) {
                probe = probe.getNext();
            }
            probe.setNext(newNode);
        }
        size++;
        return true;
    }

    /**
     * Removes all of the elements from this list
     * The list will be empty after this call returns.
     */

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index of the element to return
     * @return element at the specified position in the list
     */
    @Override
    public E get(int index) {
        if (index >= size) {
            throw new NoSuchElementException();
        }
        Node<E> probe = head;
        for (int i = 0; i < index; i++) {
            probe = probe.getNext();
        }
        return probe.getData();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int cursor = 0;
            private boolean canRemove = false;
            public boolean hasNext() {
                return cursor < size();
            }
            public E next() {
                if (!(hasNext())) {
                    throw new NoSuchElementException();
                }
                E nextObj = get(cursor++);
                canRemove = true;
                return nextObj;
                }
            public void remove() {
                if (!(canRemove)) {
                    throw new IllegalStateException();
                }
                canRemove = false;
                if (cursor == 1) {
                    head = head.getNext();
                } else {
                    Node<E> prev = head;
                    for (int i = 0; i < cursor - 2; i++) {
                        prev = prev.getNext();
                    }
                    Node<E> toRemove = head;
                    for (int i = 0; i < cursor - 1; i++) {
                        toRemove = toRemove.getNext();
                    }
                    Node<E> current = head;
                    for (int i = 0; i < cursor; i++) {
                        current = current.getNext();
                    }
                    prev.setNext(current);
                    toRemove = null;
                    size--;
                }
            }
        };
    }

    //****** Do not modify anything below this line! ********

    /**
     * For grading, returns the head
     *
     * @return the head of the list
     */
    public Node<E> getHead() {
        return head;
    }

    /**
     * @author mclayton34
     * @version 0.1
     * @param <E> the type of object contained in this node
     */
    public class Node<T> {
        private T data;
        private Node<T> next;

        /**
         * Constructor for node, creates a node with data
         * equal to parameter data
         *
         * @param data the data to exist in the node
         */
        public Node(T data) {
            this.data = data;
        }

        /**
         * @param data constructs a node with the reference
         *             to the next node already included
         * @param next the next node
         */
        public Node(T data, Node<T> next) {
            this(data);
            this.next = next;
        }

        /**
         * @return the next node from this one
         */
        public Node<T> getNext() {
            return next;
        }

        /**
         * sets the next node for this node
         *
         * @param next the node to set as next
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }

        /**
         * Gets the data for this node
         *
         * @return the data for this node
         */
        public T getData() {
            return data;
        }
    }
}

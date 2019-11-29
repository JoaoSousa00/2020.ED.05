package Nodes;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Class that represents
 * </p>
 */
public class DoubleNode<T> {

    /**
     * reference to the next node in list
     */
    private DoubleNode<T> next;
    /**
     * element stored at this node
     */
    private T element;
    /**
     * reference to the previous node in list
     */
    private DoubleNode<T> previous;

    /**
     * Creates an empty node.
     */
    public DoubleNode() {
        next = null;
        previous = null;
        element = null;
    }

    /**
     * Creates a node storing the specified element.
     *
     * @param elem element to be stored into the new node
     */
    public DoubleNode(T elem) {
        next = null;
        previous = null;
        element = elem;
    }

    /**
     * Returns the node that follows this one.
     *
     * @return the node that follows the current one
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     * Sets the node that follows this one.
     *
     * @param next the node to be set as the one to follow the current one
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Returns the element stored in this node.
     *
     * @return the element stored in this node
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element stored in this node.
     *
     * @param element the element to be stored in this node
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * @return the previous
     */
    public DoubleNode<T> getPrevious() {
        return previous;
    }

    /**
     * Sets the node that precedes this one.
     *
     * @param previous the node to be set as the one to precede the current one
     */
    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
}

package edu.iastate.cs228.hw5;

/**
 * 
 * @author Caleb Brose
 *
 */

/**
 * 
 * This class represents a tree node. This class is fully implemented and should not 
 * be modified.
 * 
 */

public class Node<E extends Comparable<? super E>> {
    private E data;
    private Node<E> parent;
    private Node<E> left;
    private Node<E> right;

    public Node(E dat) {
        this(dat, null, null);
    }

    public Node(E dat, Node<E> left, Node<E> right) {
        this.data = dat;
        this.left = left;
        this.right = right;
        this.parent = null;
    }

    /**
     * Write the value of the instance variable named data.
     */
    public String toString() {
        return this.data.toString();
    }

    public E getData() {
        return this.data;
    }

    public void setData(E dat) {
        this.data = dat;
    }

    public Node<E> getParent() {
        return this.parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public Node<E> getLeft() {
        return this.left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return this.right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
    
    public boolean isRightChild() {
        return this.parent != null && this.parent.right == this;
    }
    
    public boolean isLeftChild() {
        return this.parent != null && this.parent.left == this;
    }
}

package edu.iastate.cs228.hw5;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * Splay tree implementation of the Set interface.  The contains() and
 * remove() methods of AbstractSet are overridden to search the tree without
 * using the iterator.
 *
 */
public class SplayTreeSet<E extends Comparable<? super E>> extends AbstractSet<E>
{
  // The root of the tree containing this set's items	
  Node<E> root;
	
  // The total number of elements stored in this set
  int size;
  
  /**
   * Default constructor.  Creates a new, empty, SplayTreeSet
   */
  public SplayTreeSet() {
	// TODO  
	  root = null;
	  size = 0;
  }
  
  /**
   * Shallow copy constructor.  This method is fully implemented and should not be
   * modified.
   */
  public SplayTreeSet(Node<E> root, int size) {
	this.root = root;
	this.size = size;
  }

  /**
   * Gets the root of this tree.  Used only for testing. This method is fully implemented
   * and should not be modified.
   * @return the root of this tree.
   */
  public Node<E> getRoot() 
  {
    return root; 
  }

  /**
   * Determines whether the set contains an element.  Splays at the node that stores the 
   * element.  If the element is not found, splays at the last node on the search path.
   * @param  obj  element to be determined whether to exist in the tree
   * @return true if the element is contained in the tree and false otherwise
   */
  @Override
  public boolean contains(Object obj)
  {
	  // TODO
	  return true; 
  }

  /**
   * Inserts an element into the splay tree. In case the element was not contained, this  
   * creates a new node and splays the tree at the new node. If the element exists in the 
   * tree already, it splays at the node containing the element. 
   * @param  key  element to be inserted
   * @return true if insertion is successful and false otherwise
   */
  @Override
  public boolean add(E key)
  {
	  // TODO
	  return true; 
  }

  /**
   * Removes the node that stores an element.  Splays at its parent node after removal
   * (No splay if the removed node was the root.) If the node was not found, the last node 
   * encountered on the search path is splayed to the root.
   * @param obj  element to be removed from the tree
   * @return true if the object is removed and false if it was not contained in the tree. 
   */  
  @Override
  public boolean remove(Object obj)
  {
	  // TODO
	  return true; 
  }
  
  /**
   * Returns the node containing key, or null if the key is not
   * found in the tree.  Called by contains().
   * @param key
   * @return the node containing key, or null if not found
   */
  protected Node findEntry(E key)
  {
    // TODO
    return null; 
  }
  
  
  /**
   * Returns the successor of the given node.
   * @param n
   * @return the successor of the given node in this tree, 
   *   or null if there is no successor
   */
  protected Node successor(Node<E> n)
  {
	  // TODO
	  return null; 
  }
  
  /**
   * Removes the given node, preserving the binary search
   * tree property of the tree.
   * @param n node to be removed
   */
  protected void unlinkNode(Node<E> n)
  {
	  // TODO
  }
  
  @Override
  public Iterator<E> iterator()
  {
    return new SplayTreeIterator();
  }

  @Override
  public int size()
  {
	  // TODO
	  return 0; 
  }
 
  /**
   * Returns a representation of this tree as a multi-line string as
   * explained in the project description.
   */
  @Override
  public String toString()
  {
	  // TODO
	  return null; 
  }

  /**
   * Splay at the current node.  This consists of a sequence of zig, zigZig, or zigZag 
   * operations until the current node is moved to the root of the tree.
   * @param current  node at which to splay.
   */
  protected void splay(Node<E> current)
  {
    // TODO
  }	

  /**
   * Performs the zig operation on a node.
   * @param current  node at which to perform the zig operation.
   */
  protected void zig(Node<E> current)
  {
    // TODO
  }

  /**
   * Performs the zig-zig operation on a node.
   * @param current  node at which to perform the zig-zig operation.
   */
  protected void zigZig(Node<E> current)
  {
    // TODO
  }

  /**
   * Performs the zig-zag operation on a node.
   * @param current  node to perform the zig-zag operation on
   */
  protected void zigZag(Node<E> current)
  {
    // TODO
  }    
  
  /**
   *
   * Iterator implementation for this splay tree.  The elements are
   * returned in ascending order according to their natural ordering.
   *
   */
  private class SplayTreeIterator implements Iterator<E>
  {
    Node<E> cursor;

    public SplayTreeIterator()
    {
    	// TODO
    }
    
    @Override
    public boolean hasNext()
    {
    	// TODO
    	return true; 
    }

    @Override
    public E next()
    {
    	// TODO
    	return null; 
    }

    @Override
    public void remove()
    {
      // TODO
    }
  }
}
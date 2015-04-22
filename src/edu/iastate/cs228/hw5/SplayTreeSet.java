package edu.iastate.cs228.hw5;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * Splay tree implementation of the Set interface. The contains() and remove()
 * methods of AbstractSet are overridden to search the tree without using the
 * iterator.
 *
 */
public class SplayTreeSet<E extends Comparable<? super E>> extends
		AbstractSet<E> {
	// The root of the tree containing this set's items
	Node<E> root;

	// The total number of elements stored in this set
	int size;

	/**
	 * Default constructor. Creates a new, empty, SplayTreeSet
	 */
	public SplayTreeSet() {
		// TODO
		root = null;
		size = 0;
	}

	/**
	 * Shallow copy constructor. This method is fully implemented and should not
	 * be modified.
	 */
	public SplayTreeSet(Node<E> root, int size) {
		this.root = root;
		this.size = size;
	}

	/**
	 * Gets the root of this tree. Used only for testing. This method is fully
	 * implemented and should not be modified.
	 * 
	 * @return the root of this tree.
	 */
	public Node<E> getRoot() {
		return root;
	}

	/**
	 * Determines whether the set contains an element. Splays at the node that
	 * stores the element. If the element is not found, splays at the last node
	 * on the search path.
	 * 
	 * @param obj
	 *            element to be determined whether to exist in the tree
	 * @return true if the element is contained in the tree and false otherwise
	 */
	@Override
	public boolean contains(Object obj) {
		if (obj.getClass() != root.getClass())
			return false;
		Node<E> current = root;
		Node<E> goal = (Node<E>) obj;
		// find node
		while (current.equals(goal) == false) {
			// are we at the end of the tree?
			if (current.getLeft() == null && current.getRight() == null)
				break;
			// check if we should move left or right
			if (goal.getData().compareTo(current.getData()) == 1) { // figure
																	// out what
																	// this
																	// does...s

			}
		}
		// splay the tree at current
		splay(current);

		return true;
	}

	/**
	 * Inserts an element into the splay tree. In case the element was not
	 * contained, this creates a new node and splays the tree at the new node.
	 * If the element exists in the tree already, it splays at the node
	 * containing the element.
	 * 
	 * @param key
	 *            element to be inserted
	 * @return true if insertion is successful and false otherwise
	 */
	@Override
	public boolean add(E key) {
		// TODO
		if (key == null)
			throw new NullPointerException();
		if (contains(key));
		return true;
	}

	/**
	 * Removes the node that stores an element. Splays at its parent node after
	 * removal (No splay if the removed node was the root.) If the node was not
	 * found, the last node encountered on the search path is splayed to the
	 * root.
	 * 
	 * @param obj
	 *            element to be removed from the tree
	 * @return true if the object is removed and false if it was not contained
	 *         in the tree.
	 */
	@Override
	public boolean remove(Object obj) {
		
		//REDO THIS - Need to remove based on hash, not node
		//https://bb.its.iastate.edu/webapps/discussionboard/do/message?action=list_messages&forum_id=_174859_1&nav=discussion_board&conf_id=_107369_1&course_id=_41863_1&message_id=_1526103_1#msg__1526103_1Id
		
		// TODO
		//verify we are dealing with a node
		if(obj.getClass() != root.getClass()) return false;
		//search for the thing
		
		//if we find it, remove it
		//then splay the largest value to the point of removal, put obj's right child as largest value's right child
		//see the notes if you forget
		return true;
	}

	/**
	 * Returns the node containing key, or null if the key is not found in the
	 * tree. Called by contains().
	 * 
	 * @param key
	 * @return the node containing key, or null if not found
	 */
	protected Node findEntry(E key) {
		// TODO
		return null;
	}

	/**
	 * Returns the successor of the given node.
	 * 
	 * @param n
	 * @return the successor of the given node in this tree, or null if there is
	 *         no successor
	 */
	protected Node successor(Node<E> n) {
		// TODO
		return null;
	}

	/**
	 * Removes the given node, preserving the binary search tree property of the
	 * tree.
	 * 
	 * @param n
	 *            node to be removed
	 */
	protected void unlinkNode(Node<E> n) {
		// TODO
		remove(n);
	}

	@Override
	public Iterator<E> iterator() {
		return new SplayTreeIterator();
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns a representation of this tree as a multi-line string as explained
	 * in the project description.
	 */
	@Override
	public String toString() {
		// TODO
		return null;
	}

	/**
	 * Splay at the current node. This consists of a sequence of zig, zigZig, or
	 * zigZag operations until the current node is moved to the root of the
	 * tree.
	 * 
	 * @param current
	 *            node at which to splay.
	 */
	protected void splay(Node<E> current) {
		// TODO test this
		while(current.isLeftChild() || current.isRightChild()) zig(current);
		
		root = current;
	}

	/**
	 * Performs the zig operation on a node.
	 * 
	 * @param current
	 *            node at which to perform the zig operation.
	 */
	protected void zig(Node<E> current) {
		// TODO test this
		if(current == null) return;
		if (current.getParent() == null) { // root
			return; // no action needed, you are trying to splay the root.
		}

		Node<E> parent = current.getParent();
		current.setParent(parent.getParent());
		// point the grandparent to the new parent(aka grandchild)
		if (parent.isLeftChild()) current.getParent().setLeft(current);
		if (parent.isRightChild()) current.getParent().setRight(current);

		// figure out how splaying should be done
		if (current.isLeftChild()) { // left child
			parent.setLeft(current.getRight());
			if (current.getLeft() != null)
				current.getLeft().setParent(parent);

			current.setRight(parent);
			parent.setParent(current);
			return;
		}
		if (current.isRightChild()) { // right child
			parent.setRight(current.getLeft());
			if (current.getRight() != null)
				current.getRight().setParent(parent);

			current.setLeft(parent);
			parent.setParent(current);
			return;
		}
	}

	/**
	 * Performs the zig-zig operation on a node.
	 * 
	 * http://digital.cs.usu.edu/~allan/DS/Notes/Ch22.pdf
	 * 
	 * @param current
	 *            node at which to perform the zig-zig operation.
	 */
	protected void zigZig(Node<E> current) {
		// TODO
		Node<E> x = current;
		Node<E> p = current.getParent();
		Node<E> g = p.getParent();
		
		//point the grandparent's parent to the new grandparent - aka current
		if(g.isLeftChild()) g.getParent().setLeft(x);
		if(g.isRightChild()) g.getParent().setRight(x);
		
		//establish basic hierarchy
		x.setParent(g.getParent());
		p.setParent(x);
		g.setParent(p);
		
		if(x.isLeftChild()){
			p.setLeft(x.getRight());
			x.getRight().setParent(p);
			g.setLeft(p.getRight());
			p.getRight().setParent(g);
			
			x.setRight(p);
			p.setRight(g);
			return;
		}
		if(x.isRightChild()){
			g.setRight(p.getLeft());
			p.setRight(x.getLeft());
			
			x.setLeft(p);
			p.setLeft(g);
			return;
		}
	}

	/**
	 * Performs the zig-zag operation on a node.
	 * 
	 * @param current
	 *            node to perform the zig-zag operation on
	 */
	protected void zigZag(Node<E> current) {
		// TODO
		Node<E> x = current;
		Node<E> p = current.getParent();
		Node<E> g = p.getParent();
		
		// for right child
		if (current.isRightChild()) {
			x.setParent(g.getParent());
			
			p.setRight(x.getRight());
			g.setLeft(x.getLeft());

			x.getLeft().setParent(p);
			x.getRight().setParent(g);

			p.setParent(x);
			g.setParent(x);
			x.setRight(g);
			x.setLeft(p);
			return;
		}
		if(current.isLeftChild()) {
			x.setParent(g.getParent());
			
			p.setLeft(x.getLeft());
			g.setRight(x.getRight());
			
			p.getLeft().setParent(p);
			g.getRight().setParent(g);
			
			p.setParent(x);
			x.setRight(p);
			g.setParent(x);
			x.setLeft(g);
		}
		
	}

	/**
	 *
	 * Iterator implementation for this splay tree. The elements are returned in
	 * ascending order according to their natural ordering.
	 *
	 */
	private class SplayTreeIterator implements Iterator<E> {
		Node<E> cursor;

		public SplayTreeIterator() {
			// TODO
			cursor = root;
			while (cursor.getLeft() != null){
				// Keep pushing the cursor down
				cursor = cursor.getLeft();
			}
		}

		@Override
		public boolean hasNext() {
			// TODO
			return true;
		}

		@Override
		public E next() {
			// TODO
			return null;
		}

		@Override
		public void remove() {
			// TODO
		}
	}
	
	private Node<E> findMax(Node<E> obj){
		if(obj == null) obj = root; //if we don't provide a node, assume root
		while(obj.getRight()!=null) obj = obj.getRight();
		return obj;
	}
}
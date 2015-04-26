package edu.iastate.cs228.hw5;

import java.util.Iterator;
import java.util.ArrayList;

/**
 *
 * An implementation of a map based on a splay tree.
 *
 */
public class SplayTreeMap<K extends Comparable<? super K>, V> {
	/**
	 *
	 * The key-value pairs in this Map.
	 *
	 */
	private SplayTreeSet<MapEntry<K, V>> entrySet = new SplayTreeSet<MapEntry<K, V>>();
	
	/**
	 * Default constructor. Creates a new, empty, SplayTreeMap
	 */
	public SplayTreeMap() {
		entrySet = new SplayTreeSet<MapEntry<K, V>>(); 
	}

	/**
	 * Simple copy constructor used only for testing. This method is fully
	 * implemented and should not be modified.
	 */
	public SplayTreeMap(SplayTreeSet<MapEntry<K, V>> set) {
		entrySet = set;
	}

	/**
	 *
	 * @return the number of key-value mappings in this map.
	 */
	public int size() {
		return entrySet.size();
	}

	/**
	 *
	 * @return the value to which key is mapped, or null if this map contains no
	 *         mapping for key.
	 *
	 */
	public V get(K key) {
		MapEntry<K, V> find = new MapEntry<K, V>(key,null);
		MapEntry<K, V> found = (MapEntry<K, V>) entrySet.findEntry(find).getData();
		if(found != null)
			return found.value;
		
		return null;
	}

	/**
	 *
	 * @return true if this map contains a mapping for key.
	 *
	 */
	public boolean containsKey(K key) {
		MapEntry<K, V> val = new MapEntry<K, V>(key, null);
		return entrySet.contains(val);
	}

	/**
	 *
	 * Associates value with key in this map.
	 *
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key.
	 *
	 */
	public V put(K key, V value) {
		MapEntry<K, V> val = new MapEntry<K, V>(key,value);
		Node<MapEntry<K, V>> find = entrySet.findMin(null);
		//search for it
		while(entrySet.successor(find) != null){
			//if we have it, find it, change the value and return the old
			if(find.getData().key == key){
				V val2 = find.getData().value;
				find.setData(val);
				return val2;
			} else {
				find = entrySet.successor(find);
			}
		}
		//if we dont
		return null;
	}

	/**
	 *
	 * Removes the mapping for key from this map if it is present.
	 *
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key.
	 *
	 */
	public V remove(K key) {
		MapEntry<K, V> val = new MapEntry<K, V>(key, null);
		MapEntry<K, V> found = (MapEntry<K, V>) entrySet.findEntry(val).getData();
		if(found == null)
			return null;
		entrySet.remove(found);
		return found.value;
	}

	/**
	 *
	 * @return a SplayTreeSet storing the keys contained in this map.
	 *
	 */
	public SplayTreeSet<K> keySet() {
		SplayTreeSet<K> out = new SplayTreeSet<K>();
		
		Node<MapEntry<K, V>> cur = entrySet.getRoot();
		while(entrySet.successor(cur) != null){
			out.add(cur.getData().key);
		}
		
		return out;
	}

	/**
	 *
	 * @return an ArrayList storing the values contained in this map. The values
	 *         in the ArrayList should be arranged in ascending order of the
	 *         corresponding keys.
	 *
	 */
	public ArrayList<V> values() {
		ArrayList<V> outgoing = new ArrayList<V>();
		Node<MapEntry<K, V>> cur = entrySet.getRoot();
		while(entrySet.successor(cur) != null){
			outgoing.add(cur.getData().value);
		}
		return outgoing;
	}

}
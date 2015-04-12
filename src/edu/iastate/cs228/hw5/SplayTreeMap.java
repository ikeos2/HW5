package edu.iastate.cs228.hw5;

import java.util.Iterator;
import java.util.ArrayList; 

/**
*
* An implementation of a map based on a splay tree.  
*
*/
public class SplayTreeMap<K extends Comparable<? super K>, V>
{
  /**
   *
   * The key-value pairs in this Map.
   *
   */
  private SplayTreeSet<MapEntry<K, V>> entrySet = new SplayTreeSet<MapEntry<K, V>>();
  
  /**
   * Default constructor.  Creates a new, empty, SplayTreeMap
   */
  public SplayTreeMap() {
    // TODO  
  }
  
  /**
   * Simple copy constructor used only for testing.  This method is fully implemented 
   * and should not be modified.
   */
  public SplayTreeMap(SplayTreeSet<MapEntry<K, V>> set) {
    entrySet = set;
  }

  /**
   *
   * @return the number of key-value mappings in this map.
   */
  public int size()
  {
    // TODO
    return 0; 
  }
 
  /**
   *
   * @return the value to which key is mapped, or null if this map contains 
   *         no mapping for key.
   *
   */
  public V get(K key)
  {
    // TODO
    return null; 
  }

  /**
   *
   * @return true if this map contains a mapping for key.
   *
   */
  public boolean containsKey(K key)
  {
    // TODO
    return false; 
  }

  /**
   *
   * Associates value with key in this map.
   *
   * @return the previous value associated with key, or null if there was no mapping 
   *         for key.
   *
   */
  public V put(K key, V value)
  {
    // TODO
    return null; 
  }

  /**
   *
   * Removes the mapping for key from this map if it is present.
   *
   * @return the previous value associated with key, or null if there was no mapping 
   *         for key.
   *
   */
  public V remove(K key)
  {
    // TODO
    return null; 
  }
  
  /**
   *
   * @return a SplayTreeSet storing the keys contained in this map.
   *
   */
  public SplayTreeSet<K> keySet()
  {
    // TODO
    return null; 
  }

  /**
   *
   * @return an ArrayList storing the values contained in this map. The values in
   *         the ArrayList should be arranged in ascending order of the corresponding
   *         keys.
   *
   */
  public ArrayList<V> values()
  {
    // TODO
    return null;  
  }

}
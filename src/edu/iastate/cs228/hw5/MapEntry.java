package edu.iastate.cs228.hw5;

/**
 *
 * The entries for a map. Each entry has a key and a value.  Entries are compared 
 * by key only.
 *
 * This class is fully implemented and should not be modified.
 *
 */
public class MapEntry<K extends Comparable<? super K>, V> implements Comparable<MapEntry<K, V>> 
{
  public K key;
  public V value;
   
  @Override
  public int compareTo(MapEntry<K, V> rhs)
  {
    return key.compareTo(rhs.key);
  }
 
  public MapEntry(K key, V value)
  {
    this.key = key;
    this.value = value;
  }
}
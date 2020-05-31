/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Sun Sep 29 16:19:12 CEST 2019
 */

package uebung03.ml.aufgabe03;

import java.util.Collection;

import uebung02.ml.aufgabe01.BinarySearchTree.Entry;


public class AVLTree <K extends Comparable<? super K>, V> {
  
  //private AVLTreeImpl<K, V> avlTreeImpl = new AVLTreeImpl<K, V>();
  
  // Show in ADV:
  //private AVLTreeImpl<K, V> avlTreeImpl = new AVLTreeImplADV<K, V>("AVL-Tree");
  private AVLTreeImpl<K, V> avlTreeImpl = new AVLTreeImplADV<K, V>("AVL-Tree", 1, 3);
  // Be aware of NodeFixationException!
  
  public V put(K key, V value) {
    return avlTreeImpl.put(key, value);
  }
  
  public V get(K key) {
    return avlTreeImpl.get(key);
  }
  
  public int getHeight() {
    return avlTreeImpl.getHeight();
  }
  
  public int size() {
    return avlTreeImpl.size();
  }
  
  public boolean isEmpty() {
    return avlTreeImpl.isEmpty();
  }
  
  public void clear() {
    avlTreeImpl.clear();
  }
  
  public Collection<Entry<K, V>> inorder() {
    return avlTreeImpl.inorder();
  }
  
  public void printInorder() {
    avlTreeImpl.printInorder();
  }

  public void print() {
    avlTreeImpl.print();
  }
  
  protected AVLTreeImpl<K, V> getImpl() {
    return avlTreeImpl;
  }

  public static void main(String[] args) {

    AVLTree<Integer, String> avlTree = new AVLTree<Integer, String>();

    System.out.println("Inserting 2:");
    avlTree.put(2, "Str2");
    avlTree.print();
    System.out.println("================================");
    System.out.println("Inserting 1:");
    avlTree.put(1, "Str1");
    avlTree.print();
    System.out.println("================================");
    System.out.println("Inserting 5:");
    avlTree.put(5, "Str5");
    avlTree.print();
    System.out.println("================================");
    System.out.println("Inserting 3:");
    avlTree.put(3, "Str3");
    avlTree.print();
    System.out.println("================================");
    System.out.println("Inserting 6:");
    avlTree.put(6, "Str6");
    avlTree.print();
    System.out.println("================================");
    System.out.println("Inserting 4:1:");
    avlTree.put(4, "Str4:1");
    avlTree.print();
    System.out.println("================================");
    System.out.println("Inserting 4:2:");
    avlTree.put(4, "Str4:2");
    avlTree.print();
    System.out.println("================================");
    System.out.println("Getting 3 :" + avlTree.get(3));
    System.out.println("Getting 4 :" + avlTree.get(4));
    System.out.println("Getting 7 :" + avlTree.get(7));
    
  }

}


/* Session-Log:

Inserting 2:
 2 - Str2   : h=0 ROOT  
================================
Inserting 1:
 1 - Str1   : h=0 / parent(key)=2  
 2 - Str2   : h=1 ROOT  
================================
Inserting 5:
 1 - Str1   : h=0 / parent(key)=2  
 2 - Str2   : h=1 ROOT  
 5 - Str5   : h=0 \ parent(key)=2  
================================
Inserting 3:
 1 - Str1   : h=0 / parent(key)=2  
 2 - Str2   : h=2 ROOT  
 3 - Str3   : h=0 / parent(key)=5  
 5 - Str5   : h=1 \ parent(key)=2  
================================
Inserting 6:
 1 - Str1   : h=0 / parent(key)=2  
 2 - Str2   : h=2 ROOT  
 3 - Str3   : h=0 / parent(key)=5  
 5 - Str5   : h=1 \ parent(key)=2  
 6 - Str6   : h=0 \ parent(key)=5  
================================
Inserting 4:1:
 1 - Str1   : h=0 / parent(key)=2  
 2 - Str2   : h=3 ROOT  
 3 - Str3   : h=1 / parent(key)=5  
 4 - Str4:1 : h=0 \ parent(key)=3  
 5 - Str5   : h=2 \ parent(key)=2  
 6 - Str6   : h=0 \ parent(key)=5  
================================
Inserting 4:2:
 1 - Str1   : h=0 / parent(key)=2  
 2 - Str2   : h=3 ROOT  
 3 - Str3   : h=1 / parent(key)=5  
 4 - Str4:2 : h=0 \ parent(key)=3  
 5 - Str5   : h=2 \ parent(key)=2  
 6 - Str6   : h=0 \ parent(key)=5  
================================
Getting 3 :Str3
Getting 4 :Str4:2
Getting 7 :null

*/ 

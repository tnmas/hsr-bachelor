/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Sun Oct  6 19:25:51 CEST 2019
 */

package uebung04.as.aufgabe01;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.commons.tree.logic.domain.ADVBinaryTreeNode;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.tree.logic.binarytree.BinaryTreeModule;

@SuppressWarnings("unchecked")
public class AVLTreeImplADV<K extends Comparable<? super K>, V>
    extends AVLTreeImpl<K, V> {

  protected BinaryTreeModule advTree;
  protected String currentOperation;

  protected class AVLNodeADV extends AVLTreeImpl<K, V>.AVLNode
      implements ADVBinaryTreeNode<String> {

    protected AVLNodeADV(Entry<K, V> entry) {
      super(entry);
    }

    @Override
    public String getContent() {
      return getEntry().getKey() + " / " + getEntry().getValue() + " (" + getHeight() + ")";
    }

    @Override
    public ADVStyle getStyle() {
      return null;
    }

    @Override
    public AVLNodeADV getLeftChild() {
      return (AVLNodeADV) super.getLeftChild();
    }

    @Override
    public AVLNodeADV getRightChild() {
      return (AVLNodeADV) super.getRightChild();
    }

  } // class AVLTreeImplADV.AVLNodeADV

  public AVLTreeImplADV(String sessionName) {
    this(sessionName, -1, -1);
  }

  public AVLTreeImplADV(String sessionName, 
                             int maxLeftHeight, int maxRightHeight) {
    advTree = new BinaryTreeModule(sessionName);
    if ((maxLeftHeight != -1) && (maxLeftHeight != -1)) {
      advTree.setFixedTreeHeight(maxLeftHeight, maxRightHeight);
    }
    try {
      ADV.launch(null);
    } catch (ADVException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  @Override
  protected Node newNode(Entry<K, V> entry) {
    return new AVLNodeADV(entry);
  }

  @Override
  public V put(K key, V value) {
    currentOperation = "put(" + key + "," + value + ")";
    V result = super.put(key,  value);
    displayOnADV(currentOperation);
    currentOperation = null;
    return result;
  }
  
  @Override
  protected AVLNode rotateWithRightChild(AVLNode k1) {
    displayOnADV(currentOperation + ": Next step: rotateWithRightChild(" + k1 + ")");
    AVLNode newRoot = super.rotateWithRightChild(k1);
    return newRoot;
  }
  
  @Override
  protected AVLNode rotateWithLeftChild(AVLNode k2) {
    displayOnADV(currentOperation + ": Next step: rotateWithLeftChild(" + k2 + ")");
    AVLNode newRoot = super.rotateWithLeftChild(k2);
    return newRoot;
  }

  @Override
  public V remove(K key) {
    currentOperation = "remove(" + key + ")";
    V result = super.remove(key);
    displayOnADV(currentOperation);
    currentOperation = null;
    return result;
  }

  protected void displayOnADV(String advMessage) {
    advTree.setRoot((AVLNodeADV) root);
    try {
      ADV.snapshot(advTree, "\n" + advMessage);
    } catch (ADVException e) {
      e.printStackTrace();
      System.exit(2);
    }
  }

}

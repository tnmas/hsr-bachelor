/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Tue Feb 12 11:57:58 CET 2019
 */

package uebung01.as.aufgabe03;

import static java.lang.System.out;

public class Sequence {

  public static void main(String[] args) {
    for (int n = 1; n <= 5; n++) {
      out.println("n = " + n);
      out.println("  recursive: " + recursive(n));
      out.println("  iterative: " + iterative(n));
      out.println("  explicit:  " + explicit(n));
    }
  }

  static int recursive(int n) {
    
    // TODO Implement here...

    return -1;
  }

  static int iterative(int n) {
    
    // TODO Implement here...

    return -1;
  }

  static int explicit(int n) {
    
    // TODO Implement here...

    return -1;
  }

}

/* Session-Log (SOLL):

n = 1
  recursive: 5
  iterative: 5
  explicit:  5
n = 2
  recursive: 13
  iterative: 13
  explicit:  13
n = 3
  recursive: 21
  iterative: 21
  explicit:  21
n = 4
  recursive: 29
  iterative: 29
  explicit:  29
n = 5
  recursive: 37
  iterative: 37
  explicit:  37

*/ 
 
 

/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Mon Mar  4 16:45:58 CET 2019
 */

package uebung03.as.aufgabe01;

import java.util.Arrays;


public class PairSums {
  
  public static void main(String[] args) {
    
    int[] a1 = {47, 73, 21, 17};
    System.out.println("\n" + Arrays.toString(a1) + ":");
    int[] b1 = generateSums(a1);
    printSums(b1, a1.length);
    
    int[] a2 = {1, 2, 3, 4, 5, 7};
    System.out.println("\n" + Arrays.toString(a2) + ":");
    int[] b2 = generateSums(a2);
    printSums(b2, a2.length);
    
    System.out.println("\nRuntime-Measurement:");
    runtimeMeasurement();
    
  }
  
  /**
   * Generates the PAIR-sums.
   * Generates the PAIR-sums in the sequence of: i=1, i=2, ... i=n-1
   * Places the calculated sums in the same sequence in the resulting array.
   * @param a The array with the input-data: a1, ... , an 
   *          (e.g. [47, 73, 21, 17]) 
   * @return The resulting array with all sums 
   *          (e.g. [120, 68, 64, 94, 90, 38])
   */
  static int[] generateSums(int[] a) {
    
    // TODO Implement here...
    
    return null;
  }
  
  /**
   * Prints the sums to stdout.
   * @param b The array with all PAIR-Sums.
   * @param n The size n of the orignal sequence of numbers.
   */
  private static void printSums(int[] b, int n) {
    
    // TODO Implement here...
    
  }
  
  /**
   * Makes a runtime-measurement of generateSums().
   * See the 'Session-Log' below. 
   */
  private static void runtimeMeasurement() {
    
    // TODO Implement here...
    
  }

}



/* Session-Log:

$ java -Xint -Xms100m -Xmx100m uebung03/as/aufgabe01/PairSums

[47, 73, 21, 17]:
120     68      64
        94      90
                38

[1, 2, 3, 4, 5, 7]:
3       4       5       6       8
        5       6       7       9
                7       8       10
                        9       11
                                12

Runtime-Measurement:
Size:    256    Time:     0.6 ms    Ratio to last: 0.0
Size:    512    Time:     2.2 ms    Ratio to last: 4.0
Size:  1,024    Time:     8.9 ms    Ratio to last: 3.9
Size:  2,048    Time:    35.3 ms    Ratio to last: 4.0
Size:  4,096    Time:   144.7 ms    Ratio to last: 4.1

*/

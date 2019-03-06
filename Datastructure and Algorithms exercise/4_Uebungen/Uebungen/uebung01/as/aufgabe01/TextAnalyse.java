/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Tue Feb 12 18:08:43 CET 2019
 */

package uebung01.as.aufgabe01;

public class TextAnalyse { 

  public static void main(String[] args) {

    final String text = "Test string to exercise....";
    final char[] chars = { 'a', 'o', 'i', 'e', 'u' };
    
    TextAnalyse textAnalyse = new TextAnalyse();
    int[] charsCounts = textAnalyse.doIt(text.toLowerCase(), chars);
    for (int i = 0; i < chars.length; i++) {
      System.out.println("Output: " + chars[i] + " = " + charsCounts[i]);
    }
  }

  public int[] doIt(String text, char[] chars) {
    int[] charsCounts = new int[chars.length];
    for (int i = 0; i < chars.length; i++) {
      charsCounts[i] = doIt(text, chars[i], text.length());
    }
    return charsCounts;
  }
  
  private int doIt(String text, char c, int len) {
    if (len > 1) {
      if (text.charAt(len - 1) == c)
        return doIt(text, c, len - 1) + 1;
      else
        return doIt(text, c, len - 1);
    } else {
      if (text.charAt(len - 1) == c)
        return 1;
      else
        return 0;
    }
  }
  
}
 
 

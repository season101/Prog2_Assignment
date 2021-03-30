/**
 * Main method to test the methods of the BabyGrid class.
 */
public class Main {
  public static void main(String[] args) {
    int matching;

    try {
     
      //Test-1
      BabyGrid puzzle0 = new BabyGrid("puzzle235.txt", 3);
      System.out.println("SOLUTION:\n\n" + puzzle0);
      matching = countMatches(puzzle0.solution(), "|235|523|352|");

      if (matching == 9)
        System.out.println("Problem 0 solved!!");
      else
        System.out.println("Problem 0: " + matching + " matching characters");


/*
      //Test-2
      BabyGrid puzzle1 = new BabyGrid("puzzle369.txt", 3);
      System.out.println("SOLUTION:\n\n" + puzzle1);
      matching = countMatches(puzzle1.solution(), "|396|963|639|");
      if (matching == 9)
        System.out.println("Problem 1 solved!!");
      else
        System.out.println("Problem 1: " + matching + " matching characters");

/*
      //Test-3
      BabyGrid puzzle2 = new BabyGrid("puzzle5678.txt", 4);
      System.out.println("SOLUTION:\n\n" + puzzle2);
      matching = countMatches(puzzle2.solution(), "|6857|7586|5768|8675|");
      if (matching == 16)
        System.out.println("Problem 2 solved!!");
      else
        System.out.println("Problem 2: " + matching + " matching characters");
      */
    } 
    
    catch (Exception e) {
      System.out.println("EXCEPTION " + e);
    }
  }

  /**
   * Counts the number of matching characters (other than '|') between two
   * strings.
   * 
   * @param str1 one of the strings to be compared
   * @param str2 the second string to be compared
   * @returns the number of matching characters, excluding '|'
   */
  public static int countMatches(String str1, String str2) {
    int count = 0;
    int limit = Math.min(str1.length(), str2.length());
    for (int i = 0; i < limit; ++i)
      if (str1.charAt(i) == str2.charAt(i) && str1.charAt(i) != '|')
        count++;
    return count;
  }
}

import java.util.*;
import java.io.*;

public class decode{

  public static double[] distance(String crypted, String reference) throws FileNotFoundException {
    double[] shift = new double[26];
    try{
      double[] english = frequency(reference);
      double[] encrypted = frequency(crypted);
      for(int k = 0; k < 26; k++) {
        english[k] = english[k]/english[26];
        encrypted[k] = encrypted[k]/encrypted[26];
      }
      for(int i = 0; i < 26; i++) {
        double total = 0;
        for(int j = 0; j < 26; j++) {
          int k = j + i;
          if(k > 25) {
            k = j + i - 26;
          }
          double x = english[j] - encrypted[k];
          total = total + (x * x);
        }
        shift[i] = Math.sqrt(total);
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("Sorry, file not found");
    }
    return shift;
  }

  public static void toString(double[] array) {
    for(int i = 0; i < array.length; i++) {
      System.out.println(i + ": " + array[i]);
    }
  }

  public static int smallest(double[] shift) {
    double smallestDistance = shift[0];
    int shiftAmount = 0;
    for(int i = 1; i < 26;i++) {
      if(shift[i] < smallestDistance) {
        smallestDistance = shift[i];
        shiftAmount = i;
      }
    }
    return Math.abs(26 - shiftAmount);
  }

  public static String simplify(int shift, String s) {
    char[] lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    int length = s.length();
    String result = "";
    for(int j = 0; j < length; j++) {
      char test = s.charAt(j);
      for(int i = 0; i < 26; i++) {
        if(test == lower[i]) {
          if(i + shift > 25) {
            int local = i + shift - 26;
            result = result + lower[local];
          }
          else {
            result = result + lower[i + shift];
          }
          i = 27;
        }
        else if (test == upper[i]) {
          if(i + shift > 25) {
            int local = i + shift - 26;
            result = result + upper[local];
          }
          else {
             result = result + upper[shift + i];
           }
           i = 27;
        }
        if(i == 25) {
          result = result + s.substring(j, j+1);
        }
      }
    }
    return result;
  }

  public static double[] frequency (String fileName) throws FileNotFoundException {
    double[] amount = new double[27];
    String line;
    double[] result = new double[27];
    File s = new File(fileName);
    try{
      Scanner n = new Scanner(s);
      while(n.hasNext()) {
        line = n.nextLine();
        result = findFrequency(line, amount);
      }
    }
    catch(FileNotFoundException e) {
      System.out.println("file not found");
    }
    return result;
  }

  public static double[] findFrequency(String s, double[] previous) {
    double total = previous[26];
    char[] lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    int length = s.length();
    for(int j = 0; j < length; j++) {
      for(int i = 0; i < 26; i++) {
        if(s.charAt(j) == lower[i] || s.charAt(j) == upper[i]) {
          previous[i]++;
          total++;
          i = 26;
        }
      }
    }
    previous[26] = total;
    return previous;
  }

  public static void translate(double[] array) {
    char[] lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    for(int i = 0; i < 26; i++) {
      System.out.println(lower[i] + ": " + array[i]/array[26]);
    }
  }

  public static String decode(String fileName, String reference) throws FileNotFoundException {
    File s = new File(fileName);
    int shift = smallest(distance(fileName, reference));
    String line;
    String result = "";
    try{
      Scanner n = new Scanner(s);
      while(n.hasNext()) {
        line = n.nextLine();
        result = simplify(shift, line);
      }
    }
    catch(FileNotFoundException e) {
      System.out.println("file not found");
    }
    return result;
  }

  public static void main(String args[]) throws FileNotFoundException {
    if(args.length != 2) {
      System.out.println("please input two arguments, the ciphered text first and then the reference text");
    }
    else {
      try{
        System.out.println(decode(args[0], args[1]));
        // System.out.println(smallest(distance("testing", "alice")));
      }
      catch (FileNotFoundException e) {
        System.out.println("file not found");
      }
    }
  }

}

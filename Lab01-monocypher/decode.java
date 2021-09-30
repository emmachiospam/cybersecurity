import java.util.*;
import java.io.*;

public class decode{

  public static double[] distance(String s) throws FileNotFoundException {
    double[] shift = new double[26];
    // try{
      double[] english = frequency("alice");
      double[] encrypted = frequency(s);
      // double[] english = {3,0,1};
      // double[] encrypted = {5,2,0};
      toString(english);
      System.out.println("encrypted");
      toString(encrypted);
      for(int i = 0; i < 26; i++) {
      // for(int i = 0; i < 3; i++) {
        double total = 0;
        // System.out.println(i);
        for(int j = 0; j < 26; j++) {
        // for(int j = 0; j < 3; j++) {
          int k = j + i;
          if(k > 25) {
            k = j + i - 26;
          }
          // if(k > 2) {
          //   k = j + i - 3;
          // }
          double x = english[j] - encrypted[k];
          // System.out.println(j +" " + k);
          // System.out.println(english[i]);
          // System.out.println(encrypted[k]);
          // toString(english);
          total = total + (x * x);
        }
        shift[i] = Math.sqrt(total);
      }
    // }
    // catch (FileNotFoundException e) {
    //   System.out.println("Sorry, file not found");
    // }
    toString(shift);
    return shift;
  }

  public static void toString(double[] array) {
    for(int i = 0; i < array.length; i++) {
      System.out.println(i + ": " + array[i]);
    }
  }

  public static int smallest(double[] shift) {
    double smallestDistance = shift[1];
    int shiftAmount = 0;
    for(int i = 1; i < 26;i++) {
      if(shift[i] < smallestDistance) {
        smallestDistance = shift[i];
        shiftAmount = i;
      }
    }
    return shiftAmount+1;
  }

  public static String decode(int shift, String s) {
    char[] lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    int length = s.length();
    String result = "";
    shift = 1;
    // System.out.println(s.charAt(0));
    for(int j = 0; j < length; j++) {
      char test = s.charAt(j);
      for(int i = 0; i < 26; i++) {
        // System.out.println(test);
        if(test == lower[i]) {
          if(i + shift > 25) {
            int local = i + shift - 26;
            result = result + lower[local];
          }
          else {
            result = result + lower[i + shift];
          }
          i = 26;
        }
        else if (test == upper[i]) {
          if(i + shift > 25) {
            int local = i + shift - 26;
            result = result + upper[local];
          }
          else {
             result = result + upper[shift + i];
           }
           i = 26;
        }
        // else{
        //    result = result + test;
        //    i = 26;
        // }
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
        // findFrequency(line, amount);
      }
      for(int i = 0; i < 26; i++) {
        result[i] = result[i]/result[26];
      }
      // translate(result);
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
      // System.out.println(lower[i] + ": " + array[i]);
      // System.out.println(array[26]);
    }
    // System.out.println("total: " + array[26]);
  }

  public static void main(String args[]) throws FileNotFoundException {
    try{
      int s = smallest(distance("testing"));
      System.out.println(decode(6, "sgdoqhydenqvhmmhmfhrmdudqgzuhmfsnokzxzfzhmsgdmzfzhmsgzsbntkcadsgdoqhydenqknrhmfzrvdkkcdodmchmfnmsgdfzld"));
      // System.out.println(s);
      // distance("testing");
      // System.out.println(smallest(distance("testing")));
      // toString(distance("testing"));
    }
    catch (FileNotFoundException e) {

    }
  }

}

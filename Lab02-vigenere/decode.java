import java.util.*;
import java.io.*;

public class decode{

  public static int[] count(String key) {
    char[] lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    int length = key.length();
    int[] shift = new int[length];
    for(int i = 0; i < length; i++) {
      for(int j = 0; j < 26; j++) {
        if(key.charAt(i) == lower[j] || key.charAt(i) == upper[j]) {
          shift[i] = 26 - j;
        }
      }
    }
    return shift;
  }

  public static String toString(String[] x) {
    String result = "";
    for(int i = 0; i < x.length; i++) {
      result = result + ", " + x[i];
    }
    return result;
  }

  public static String[] split(String encrypted, int length) {
    int eLength = encrypted.length();
    int amount = (eLength / length) + 1;
    String[] buckets = new String[length];
    for(int k = 0; k < length; k++) {
      buckets[k] = "";
    }
    int z = 0;
      for(int i = 0; i < amount; i++) {
        for(int j = 0; j < length; j++) {
          if (z < eLength) {
            buckets[j] = buckets[j] + encrypted.charAt(z);
            z++;
          }
        }
      }
    return buckets;
  }

  public static String shift(int shift, String s) {
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

  public static String putTogether(String[] buckets) {
    String result = "";
    for(int i = 0; i < buckets[1].length(); i++) {
      for(int j = 0; j < buckets.length; j++) {
        if (i < buckets[j].length()) {
          result = result + buckets[j].charAt(i);
        }
      }
    }
    return result.toUpperCase();
  }

  public static String decrypt(String original, String key) throws FileNotFoundException {
    int kLength = key.length();
    String[] result = split(original, kLength);
    int[] shiftAmount = count(key);
    String[] buckets = split(original, kLength);
    for(int i = 0; i < buckets.length; i++) {
      result[i] = shift(shiftAmount[i], buckets[i]);
    }
  return (putTogether(result));
  }

  public static String decodeFile(String plainTextFile, String keyTextFile) throws FileNotFoundException {
    File plainText = new File (plainTextFile);
    File keyText = new File (keyTextFile);
    String line;
    String result = "";
    String key = "";
    try{
      Scanner n = new Scanner(keyText);
      key = n.nextLine();
      Scanner s = new Scanner(plainText);
      while(s.hasNext()) {
        line = s.nextLine();
        result = result + decrypt(line, key);
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("file not found");
    }
    return result;
  }

  public static void main(String[] args) throws FileNotFoundException {
    if(args.length != 2) {
      System.out.println("please input two arguments, the file of text to decode and the file with the key");
    }
    else {
    String decodeFile = args[0];
    String keyFile = args[1];
    try{
      System.out.println(decodeFile(decodeFile, keyFile));
    }
    catch (FileNotFoundException e) {
      System.out.println("file not found");
    }
    }
  }

}

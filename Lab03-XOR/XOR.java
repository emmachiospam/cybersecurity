import java.io.*;
import java.util.*;

public class XOR{

  public static String numberOutput(String key, String message) {
    int kLength = key.length();
    int mLength = message.length();
    char[] keyChars = new char[kLength];
    char[] messageChars = new char[mLength];
    int[] xorList = new int[mLength];
    String result = "";
    for(int i = 0; i < kLength; i++) {
      keyChars[i] = key.charAt(i);
    }
    for(int j = 0; j < mLength; j++) {
      messageChars[j] = message.charAt(j);
    }
    for(int k = 0; k < mLength; k++) {
      int temp = k % kLength;
      xorList[k] = (messageChars[k] ^ keyChars[temp]);
    }
    for(int p = 0; p < mLength; p++) {
      result = result + Integer.toHexString(xorList[p]) + " ";
    }
    return result;
  }

  public static void main(String args[]) {
    // System.out.println((int)'A');
    System.out.println(numberOutput("A", "hello"));
  }

}

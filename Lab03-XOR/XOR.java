import java.io.*;
import java.util.*;

public class XOR{

  public static String numberOutput(String key, String message) throws FileNotFoundException {
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

  public static String numberOutputFile(String keyFileName, String messageFileName) throws FileNotFoundException {
    File plainText = new File (messageFileName);
    File keyText = new File (keyFileName);
    String line;
    String key = "";
    String result = "";
    try{
      Scanner n = new Scanner(keyText);
      key = n.nextLine();
      Scanner s = new Scanner(plainText);
      while(s.hasNext()) {
        line = s.nextLine();
        result = result + numberOutput(key, line);
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("Sorry file not found");
    }
    return result;
  }

  public static void main(String args[]) throws FileNotFoundException {
    String type = args[0];
    String keyFile = args[1];
    String messageFile = args[2];
    if(type.equals("numOut")) {
      System.out.println(numberOutputFile(keyFile, messageFile));
    }
    // System.out.println(numberOutput("A", "hello"));
  }

}

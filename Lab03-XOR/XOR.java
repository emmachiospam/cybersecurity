import java.io.*;
import java.util.*;

public class XOR{

  public static String numberOutput(String key, String message) throws FileNotFoundException {
    int kLength = key.length();
    int mLength = message.length();
    int[] keyChars = new int[kLength];
    int[] messageChars = new int[mLength];
    int[] xorList = new int[mLength];
    String result = "";
    for(int i = 0; i < kLength; i++) {
      keyChars[i] = (int)key.charAt(i);
    }
    for(int j = 0; j < mLength; j++) {
      messageChars[j] = (int)message.charAt(j);
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
    File messageText = new File (messageFileName);
    File keyText = new File (keyFileName);
    String line;
    String key = "";
    String result = "";
    try{
      Scanner n = new Scanner(keyText);
      key = n.nextLine();
      Scanner s = new Scanner(messageText);
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

  public static int[] numberOutputInt(String key, String message) throws FileNotFoundException {
    int kLength = key.length();
    int mLength = message.length();
    int[] keyChars = new int[kLength];
    int[] messageChars = new int[mLength];
    int[] xorList = new int[mLength];
    for(int i = 0; i < kLength; i++) {
      keyChars[i] = (int)key.charAt(i);
    }
    for(int j = 0; j < mLength; j++) {
      messageChars[j] = (int)message.charAt(j);
    }
    for(int k = 0; k < mLength; k++) {
      int temp = k % kLength;
      xorList[k] = (messageChars[k] ^ keyChars[temp]);
    }
    return xorList;
  }

  // public static void humanOutput(String key, String message) {
  //   try{
  //   }
  //   catch (IOException e) {
  //     // e.printStrackTrace();
  //     System.out.println("error");
  //   }
  // }

  public static void humanOutputFile(String keyFileName, String messageFileName) {
    File messageText = new File (messageFileName);
    File keyText = new File (keyFileName);
    String message;
    String key = "";
    try{
      OutputStream output = new FileOutputStream("output");
      Scanner n = new Scanner(keyText);
      key = n.nextLine();
      Scanner s = new Scanner(messageText);
      while(s.hasNext()) {
        message = s.nextLine();
        int[] result = numberOutputInt(key, message);
        for(int i = 0; i < result.length; i++) {
          output.write(result[i]);
        }
      }
    }
    catch (IOException e) {
      System.out.println("sorry, there was an error");
    }
  }

  public static void main(String args[]) throws FileNotFoundException {
    String type = args[0];
    String keyFile = args[1];
    String messageFile = args[2];
    if(type.equals("numOut")) {
      System.out.println(numberOutputFile(keyFile, messageFile));
    }
    else if(type.equals("human")) {
      humanOutputFile(keyFile, messageFile);
    }
  }

}

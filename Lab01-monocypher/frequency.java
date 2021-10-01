import java.util.*;
import java.io.*;

public class frequency{

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
    // translate(result);
  }
  catch(FileNotFoundException e) {
    System.out.println("file not found");
  }
  return result;
}

public static void main(String[] args) throws FileNotFoundException {
  if(args.length != 1) {
    System.out.println("please input file name");
  }
  else {
    try{
      translate(frequency(args[0]));
    }
    catch (FileNotFoundException s){
      System.out.println("file not found");
    }
  }
}

}

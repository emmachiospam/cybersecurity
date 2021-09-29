public class monocypher {

public static float[] frequency(String s) {
  int total = 0;
  char[] lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
  char[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
  float[] frequency = new float[27];
  int length = s.length();
  for(int j = 0; j < length; j++) {
    for(int i = 0; i < 26; i++) {
      if(s.charAt(j) == lower[i] || s.charAt(j) == upper[i]) {
        frequency[i] = frequency[i]+1;
        total++;
        i = 26;
      }
    }
  }
  frequency[26] = total;
  return frequency;
}

public static void translate(float[] array) {
  char[] lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
  for(int i = 0; i < 26; i++) {
    System.out.println(lower[i] + ": " + array[i]/array[26]);
    // System.out.println(lower[i] + ": " + array[i]);
    // System.out.println(array[26]);
  }
  // System.out.println("total: " + array[26]);
}

public static void main(String[] args) {
  String s = "Once upon a time";
  translate(frequency(s));
  // frequency(s);
}

}

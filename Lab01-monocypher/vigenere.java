import java.util.*;
import java.io.*;

public class vigenere{

  public static int distance(String repeating, String original) {
    int previousIndex = 0;
    repeating = repeating.toLowerCase();
    original = original.toLowerCase();
    int rLength = repeating.length();
    int oLength = original.length();
    int smallest = oLength;
    for(int i = 1; i <= oLength-rLength; i++) {
      String compare = original.substring(i, i+rLength);
      // System.out.println(compare);
      if(compare.equals(repeating)) {
        int difference = i - previousIndex;
        if(difference < smallest) {
          smallest = difference;
          previousIndex = i;
        }
      }
    }
    return smallest;
  }

  public static String[] vigenereCrack(String encrypted, int x) throws FileNotFoundException{
    // ArrayList<String> broken = new ArrayList<String>(x);
    String[] broken = new String[x];
    String[] putTogether = new String[x];
    int length = encrypted.length();
    String result = "";
    // try{
      int w = 0;
      int p = length/x;
      if(w < length) {
        for(int q = 0; q < p; q++) {
          for(int j = 0; j < x; j++) {
            // String add = broken.get(j) + encrypted.charAt(w);
            String add = broken[j] + encrypted.charAt(w);
            // broken.set(j, add);
            broken[j] = add;
            w++;
          }
        }
      }
      for(int k = 0; k < x; k++) {
        // broken.set(k, decodeString.decode(broken.get(k), "alice"));
        putTogether[k] = decodeString.decode(broken[k], "alice");
      }
    return putTogether;
  }

  // public static void together(String[] s) {
  //
  // }

  public static void toString(String[] s) {
    for(int i = 0; i < s.length; i++) {
      System.out.println(s[i]);
    }
  }

  public static void main(String args[]) throws FileNotFoundException{
    String repeating = args[0];
    String original = args[1];
    try{
      // System.out.println(vigenereCrack(repeating, Integer.parseInt(original)));
      toString(vigenereCrack(repeating, Integer.parseInt(original)));
      // toString();
    }
    catch (FileNotFoundException e) {
      System.out.println("file not found1");
    }
    // System.out.println("CALLMEISHMAELSOMEYEARSAGONEVERMINDHOWLONGPRECISELYHAVINGLITTLEORNOMONEYINMYPURSEANDNOTHINGPARTICULARTOINTERESTMEONSHOREITHOUGHTIWOULDSAILABOUTALITTLEANDSEETHEWATERYPARTOFTHEWORLDITISAWAYIHAVEOFDRIVINGOFFTHESPLEENANDREGULATINGTHECIRCULATIONWHENEVERIFINDMYSELFGROWINGGRIMABOUTTHEMOUTHWHENEVERITISADAMPDRIZZLYNOVEMBERINMYSOULWHENEVERIFINDMYSELFINVOLUNTARILYPAUSINGBEFORECOFFINWAREHOUSESANDBRINGINGUPTHEREAROFEVERYFUNERALIMEETANDESPECIALLYWHENEVERMYHYPOSGETSUCHANUPPERHANDOFMETHATITREQUIRESASTRONGMORALPRINCIPLETOPREVENTMEFROMDELIBERATELYSTEPPINGINTOTHESTREETANDMETHODICALLYKNOCKINGPEOPLESHATSOFFTHENIACCOUNTITHIGHTIMETOGETTOSEAASSOONASICANTHISISMYSUBSTITUTEFORPISTOLANDBALLWITHAPHILOSOPHICALFLOURISHCATOTHROWSHIMSELFUPONHISSWORDIQUIETLYTAKETOTHESHIPTHEREISNOTHINGSURPRISINGINTHISIFTHEYBUTKNEWITALMOSTALLMENINTHEIRDEGREESOMETIMEOROTHERCHERISHVERYNEARLYTHESAMEFEELINGSTOWARDSTHEOCEANWITHMETHERENOWISYOURINSULARCITYOFTHEMANHATTOESBELTEDROUNDBYWHARVESASINDIANISLESBYCORALREEFSCOMMERCESURROUNDSITWITHHERSURFRIGHTANDLEFTTHESTREETSTAKEYOUWATERWARDITSEXTREMEDOWNTOWNISTHEBATTERYWHERETHATNOBLEMOLEISWASHEDBYWAVESANDCOOLEDBYBREEZESWHICHAFEWHOURSPREVIOUSWEREOUTOFSIGHTOFLANDLOOKATTHECROWDSOFWATERGAZERSTHERE");
  }

}

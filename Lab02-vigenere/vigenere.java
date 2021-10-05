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

  public static String[] split(String encrypted, int length) {
    int eLength = encrypted.length();
    int amount = eLength / length;
    String[] buckets = new String[length];
    for(int k = 0; k < length; k++) {
      buckets[k] = "";
    }
    int z = 0;
    for(int i = 0; i < amount; i++) {
      for(int j = 0; j < length; j++) {
        buckets[j] = buckets[j] + encrypted.charAt(z);
        z++;
      }
    }
    return buckets;
  }

  public static String[] decode(String[] buckets) throws FileNotFoundException {
    String[] result = new String[buckets.length];
    try{
      for(int i = 0; i < buckets.length; i++) {
        result[i] = decodeString.decode(buckets[i], "alice");
      }
      return result;
    }
    catch (FileNotFoundException e) {
      System.out.println("file not found1");
      return result;
    }
  }

  public static String putTogether(String[] buckets) {
    String result = "";
    for(int i = 0; i < buckets[1].length(); i++) {
      for(int j = 0; j < buckets.length; j++) {
        result = result + buckets[j].charAt(i);
      }
    }
    return result;
  }

  public static void toString(String[] s) {
    for(int i = 0; i < s.length; i++) {
      System.out.println(s[i]);
    }
  }

  public static void main(String args[]) throws FileNotFoundException{
    String repeating = args[0];
    int original = Integer.parseInt(args[1]);
    // try{
    //   // System.out.println(vigenereCrack(repeating, Integer.parseInt(original)));
    //   // toString(vigenereCrack(repeating, Integer.parseInt(original)));
    //   // toString();
    // toString(split(repeating, Integer.parseInt(original)));
    // toString(decode(split(repeating, original)));
    System.out.println(putTogether(decode(split(repeating, original))));
    // System.out.println(decode(split(repeating, Integer.parseInt(original))));
    // }
    // catch (FileNotFoundException e) {
    //   System.out.println("file not found1");
    // }
    // System.out.println("CALLMEISHMAELSOMEYEARSAGONEVERMINDHOWLONGPRECISELYHAVINGLITTLEORNOMONEYINMYPURSEANDNOTHINGPARTICULARTOINTERESTMEONSHOREITHOUGHTIWOULDSAILABOUTALITTLEANDSEETHEWATERYPARTOFTHEWORLDITISAWAYIHAVEOFDRIVINGOFFTHESPLEENANDREGULATINGTHECIRCULATIONWHENEVERIFINDMYSELFGROWINGGRIMABOUTTHEMOUTHWHENEVERITISADAMPDRIZZLYNOVEMBERINMYSOULWHENEVERIFINDMYSELFINVOLUNTARILYPAUSINGBEFORECOFFINWAREHOUSESANDBRINGINGUPTHEREAROFEVERYFUNERALIMEETANDESPECIALLYWHENEVERMYHYPOSGETSUCHANUPPERHANDOFMETHATITREQUIRESASTRONGMORALPRINCIPLETOPREVENTMEFROMDELIBERATELYSTEPPINGINTOTHESTREETANDMETHODICALLYKNOCKINGPEOPLESHATSOFFTHENIACCOUNTITHIGHTIMETOGETTOSEAASSOONASICANTHISISMYSUBSTITUTEFORPISTOLANDBALLWITHAPHILOSOPHICALFLOURISHCATOTHROWSHIMSELFUPONHISSWORDIQUIETLYTAKETOTHESHIPTHEREISNOTHINGSURPRISINGINTHISIFTHEYBUTKNEWITALMOSTALLMENINTHEIRDEGREESOMETIMEOROTHERCHERISHVERYNEARLYTHESAMEFEELINGSTOWARDSTHEOCEANWITHMETHERENOWISYOURINSULARCITYOFTHEMANHATTOESBELTEDROUNDBYWHARVESASINDIANISLESBYCORALREEFSCOMMERCESURROUNDSITWITHHERSURFRIGHTANDLEFTTHESTREETSTAKEYOUWATERWARDITSEXTREMEDOWNTOWNISTHEBATTERYWHERETHATNOBLEMOLEISWASHEDBYWAVESANDCOOLEDBYBREEZESWHICHAFEWHOURSPREVIOUSWEREOUTOFSIGHTOFLANDLOOKATTHECROWDSOFWATERGAZERSTHERE");
  }

}

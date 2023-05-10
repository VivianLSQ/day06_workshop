package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//Prof's code--> Method 2 which uses streams (instead of for loops)

public class StreamUniquewords {
   public static void main (String[] args) throws IOException {
       Reader r = new FileReader(args[0]);
      BufferedReader br = new BufferedReader(r);

    Map<String, Integer> wordCount = new HashMap<>();

   // Note: Streams dont need ; after each line of methods
   //Note: Lambda functions cant be used with Maven --> use no built tools option 
    br.lines()
            .map (line-> line.trim().toLowerCase().replaceAll("\\p{Punct}", " ")) //returns a String
            .map(line -> line.split("\\s+") )//change String to an array String[]
            .flatMap(words-> Arrays.asList(words).stream()) //make each individual array into a String - flatten the string using flatMap
            .filter(word -> !(word.trim().length() > 0))
            .filter(word -> !Constants.STOPWORDS_SET.contains(word))
            .forEach(word -> {
                int c = wordCount.computeIfAbsent(word, (w) -> 0); 
                wordCount.put(word, c + 1); 
             }); 
   //Notes:
   // The asList() method of java.util.Arrays class is used to return a fixed-size list backed by the specified array --> aka converts array to List 
             
    br.close(); 

   for(String k:wordCount.keySet()){
         System.out.printf("word: %s, count: %d\n", k, wordCount.get(k));
      }
   
      long single = wordCount.keySet().stream()
      .filter((String word) -> wordCount.get(word) == 1)
      .count();

  System.out.printf(">>> single words: %d\n", single);    

   }
    
}

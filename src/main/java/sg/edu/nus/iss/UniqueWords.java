package sg.edu.nus.iss;

import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader; 
import java.util.HashMap; 


//Prof's code --> uses while loop and lambda expression to avoid code reptition 

public class UniqueWords {
     public static void main(String[]args) throws IOException{
        Reader r = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(r);
        String line;

        Map<String, Integer> wordCount = new HashMap<>();
        //Alternative is to use HashSet instead of HashMap because it doesnt require you to mantain key-value pairs 

        //Uses a while loop to read txt file 
        //First step is to remove all punctuations
        //Good practice to use the trim() method to remove unnecessary spaces 
        while(null!= (line =br.readLine())){
            line = line.trim().toLowerCase().replaceAll("\\p{Punct}", " ");
            for (String w: line.split("\\s+")){
                String tmp = w.trim();
                //if argument length is less than zero, and doesnt contain stop words, add to wordCount
                if(tmp.length() <=0 || Constants.STOPWORDS_SET.contains(tmp))
                    continue;
            //Note: the /tmp directory is used to write temporary data, which is usually removed when not needed 

            //alternative method - 2nd if 
            /*
                if(!wordCount.containsKey(tmp))
                wordCount.put(tmp,0); 
                wordCount.put(tmp, wordCount.get(tmp) +1);
            */ 


            //Use Map interface .computeIfAbsent 
            //The first paramter is the key, the second parameter is the mapping function
            //The mapping function is only called of mapping is not present 
                int count = wordCount.computeIfAbsent(tmp, (String k) -> 0);
                wordCount.put(tmp, count +1); 
            }
        }

     br.close();

     for(String k:wordCount.keySet()){
        System.out.printf("word: %s, count: %d\n", k, wordCount.get(k));
     }
    
     //Count the number of unique words in the Christmas Carol txt file using Java stream 
     //Long data type is used for whole numbers 
     long single = wordCount.keySet().stream()
         .filter((String word) -> (wordCount.get(word) == 1))
         .count();

     System.out.printf(">>>single words: %d\n", single);
}
}

package sg.edu.nus.iss;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set; 
import java.util.Arrays; 

//My Code
//Take note of errors and how it is solved 

public class NumberofUniqueWords {

public static void main(String[] args) throws IOException{
   FileReader fr = new FileReader(args[0]); 
   BufferedReader br = new BufferedReader(fr);

   Set<String> trimmedWordsSet = new HashSet<String>(); 
    
        String[] stopWords = {
            "a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "as", "at", "be",
            "because", "been", "before", "being", "below", "between", "both", "but", "by", "can't", "cannot", "could",
            "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", "down", "during", "each", "few", "for", "from",
            "further", "had", "hadn't", "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll",
            "he's", "her", "here", "here's", "hers", "herself", "him", "himself", "his", "how", "how's", "i", "i'd", "i'll",
            "i'm", "i've", "if", "in", "into", "is", "isn't", "it", "it's", "its", "itself", "let's", "me", "more",
            "most", "mustn't", "my", "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", "ought",
            "our", "ours", "ourselves", "out", "over", "own", "same", "shan't", "she", "she'd", "she'll", "she's", "should",
            "shouldn't", "so", "some", "such", "than", "that", "that's", "the", "their", "theirs", "them", "themselves", "then",
            "there", "there's", "these", "they", "they'd", "they'll", "they're", "they've", "this", "those", "through", "to",
            "too", "under", "until", "up", "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were",
            "weren't", "what", "what's", "when", "when's", "where", "where's", "which", "while", "who", "who's", "whom", "why",
            "why's", "with", "won't", "would", "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your", "yours",
            "yourself", "yourselves"
        };

   //Implement a Scanner object and a while loop to read data from .txt file 
   // Note that the hasNext() method will read true until there are no more Strings in the document (end of doc)
   Scanner wordScanner = new Scanner(br); 
   String word; 
   //alternative to consider: Use InputStreamReader and FileInputStream 
        //InputStreamReader input = new InputStreamReader(new FileInputStream(args[0]);
            //Compile *.java file to get a *.class file 
            //Then run like:
                //java filename input1.txt

   while (wordScanner.hasNext()){
    word = wordScanner.next(); 
   
        //exclude stopwords using boolean function 
        boolean isStopWord = false;

        for(String sw: stopWords){
            if(sw.equals(word)){
                isStopWord = true;
                break;
            }
        }if (!isStopWord){
            word = word.replaceAll("\\p{Punct}", " "); 
            word = word.toLowerCase();
            trimmedWordsSet.addAll(Arrays.asList(word.split("\\s+")));

            //Note: function to replace all punctuations
                    // .replaceAll("\\p{Punct}", " ");

        }
    }
        System.out.println(trimmedWordsSet.size()); 

        wordScanner.close(); 
        br.close();
        fr.close(); 
    
    }
}



    /*

    String line = "";
   line = br.readLine();


    //String compareTo() Method
     int j, i = 0; 
     int count = 0;
        for (i = 0; i<words.length; i++){
         boolean[] array;
             if (!array[i]){
             count++;
          for (j = i +1; j <words.length;i++){
          if(words[j].compareTo(words[i]) == 0) {
                 array[j] = true;
                   count--;
               }
          }
        }
         return count; 
} 

//To ignore upper and lowercases - count as one word 
for(String word:words)
        {String wordCompare = word.toUpperCase();
            if(!stopWordsSet.contains(wordCompare)){
                wordsList.add(word); 
            }
        }
        }

//String contains() method 
if(words.contains().stopWords){
     Object str;
    int count = countNumberOfUniqueWords(str);
    System.out.println("Total number of unique words in \"" + str + "\" are " + count ); }

*/ 

 

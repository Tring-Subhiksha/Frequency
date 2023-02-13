package org.example;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Frequency{
    static void CountWords(String filename, Map<String, Integer> words) throws FileNotFoundException {
        Scanner file = new Scanner(new File(filename));
        while (file.hasNext()) {
            String word = file.next();
            Integer count = words.get(word);
            if (count != null)
                count++;
            else
                count = 1;
            words.put(word, count);
        }
        file.close();
        Queue<Map.Entry<String,Integer>> pq=new PriorityQueue<>((a, b)-> b.getValue()-a.getValue());
        Logger l= Logger.getLogger("subhi");

        pq.addAll(words.entrySet());
        while(!pq.isEmpty())
        {

            l.log(Level.INFO,()-> ""+pq.poll());
        }

    }


    public static void main(String[] args) throws FileNotFoundException {
        Map<String,Integer> words=new HashMap<String, Integer>();
        CountWords("src/main/java/org/example/sample.txt",words);
        
    }


}
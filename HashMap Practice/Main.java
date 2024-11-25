import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // Example input data
        String[] paragraphs = {
                "This This This is the first paragraph. It contains some words, and some words repeat.",
                "This second paragraph paragraph is similar to the first. It also contains some repeating words.",
                "And here's the third paragraph, which has a few words that repeat, like 'words' and 'the'."
        };

        HashMap<String, Integer> wordCounter = WordCountTask.GetHashMap(paragraphs);

        WordCountTask.PrintMaxWord(wordCounter);
    }
}

class WordCountTask
{
    public static HashMap<String,Integer> GetHashMap(String[] paragraphs)
    {
        HashMap<String,Integer> wordCounter = new HashMap<>();
        String regex = "[,\\.\\s]";
        for (String paragraph: paragraphs)
        {
            String[] words = paragraph.split(regex);
            for (String word : words)
            {
                if (word.length() > 1)
                {
                    if (wordCounter.get(word)!= null)
                        wordCounter.put(word,wordCounter.get(word)+1);
                    else
                        wordCounter.put(word,1);
                }
            }
        }
        return wordCounter;
    }

    public static void PrintMaxWord(HashMap<String,Integer> wordCounter)
    {
        int max = 0;
        ArrayList<String> maxWords = new ArrayList<String>(); // Create an ArrayList object
        for (String word : wordCounter.keySet())
        {
            max = wordCounter.get(word)>max ? wordCounter.get(word): max ;
        }
        for (String word : wordCounter.keySet())
        {
            if (wordCounter.get(word) == max)
                maxWords.add(word);
        }

        for (String maxWord: maxWords)
        {
            System.out.println("The word ["+maxWord+"] Appears ["+max+"] Times");

        }
    }
}
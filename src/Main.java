import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

            FileReader file = new FileReader(".idea/TextFiles/RickAndMortyPilot.txt");

            File file2 = new File(".idea/TextFiles/RickAndMortyPilot.txt");

            mostRepeatedWord(file);
            numberOfWords(file2);
            numberOfUniqueWords(file2);
            specificWord();

    }
    public static void mostRepeatedWord(FileReader file) throws IOException {

        String line;
        String word = "";
        int maxCount = 0;

        ArrayList<String> wordsList = new ArrayList<>();

        // Copy the Absolute Path or Content Root Path of the file you want to read

        BufferedReader br = new BufferedReader(file);

        while ((line = br.readLine()) != null) {
            String[] string = line.split("([,.\\s]+) ");
            Collections.addAll(wordsList, string);
        }

        for (int i = 0; i < wordsList.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < wordsList.size(); j++) {
                if (wordsList.get(i).equalsIgnoreCase(wordsList.get(j))) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                word = wordsList.get(i);
            }
        }
        System.out.println("\nThe most repeated word in the given .txt file is: \"" + word + "\" with " + maxCount + " occurrences.");
        br.close();
    }

    public static void specificWord() throws FileNotFoundException {

        System.out.println("\nWrite a word to see the number of occurrences:");

        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        int wordCount = 0;

        File file = new File(".idea/TextFiles/RickAndMortyPilot.txt");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()){
            String str = scanner.next();
            if (str.equalsIgnoreCase(word)) {
                wordCount++;
            }
        }
        System.out.println("The word \"" + word + "\" appears " + wordCount + " times.");
    }

    public static void numberOfWords(File file) throws IOException {

            int wordCount = 0;

            FileReader fr = new FileReader(file);

            BufferedReader br = new BufferedReader(fr);

            String str;

            while((str=br.readLine())!=null)
            {
               String[] words = str.split(" ");
                wordCount += words.length;
            }
            br.close();
            System.out.println("\nNumber of words in the file: " + wordCount);
        }

    public static void numberOfUniqueWords(File file) throws IOException {

        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);

        String str = br.readLine();

        String[] words = str.split(" ");

        boolean[] array = new boolean[words.length];

        int count = 0;

        for (int i = 0; i < words.length; i++) {
            if (!array[i]){
                count++;

                for (int j = i + 1; j < words.length; j++){
                    if (words[j].compareTo(words[i]) == 0) {
                        array[j] = true;
                        count--;
                    }
                }
            }
        }
        System.out.println("\nThe number of distinct words in the file is: " + count);
    }
}

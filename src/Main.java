import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){

        try{
            mostRepeatedWord();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public static void mostRepeatedWord() throws IOException {

        String line;
        String word = "";
        int maxCount = 0;

        ArrayList<String> wordsList = new ArrayList<>();

        // Copy the Absolute Path or Content Root Path of the file you want to read

        FileReader file = new FileReader(".idea/TextFiles/RickAndMortyPilot.txt");

        BufferedReader br = new BufferedReader(file);

        while ((line = br.readLine()) != null) {
            String[] string = line.toLowerCase().split("([,.\\s]+) ");
            Collections.addAll(wordsList, string);
        }

        for (int i = 0; i < wordsList.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < wordsList.size(); j++) {
                if (wordsList.get(i).equals(wordsList.get(j))) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                word = wordsList.get(i);
            }
        }

        System.out.println("The most repeated word in the given .txt file is: " + word);
        br.close();
    }
}

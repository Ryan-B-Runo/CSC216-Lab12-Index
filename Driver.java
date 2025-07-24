import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(System.in);

        String path = "";
        StringBuilder data = new StringBuilder();

        System.out.println("Enter a path to a file:");

        path = s.nextLine();
        File file = new File(path);
        if(!file.canRead()) {
            System.out.println("File is not readable");
        }else{
            Scanner fileScan = new Scanner(file);
            fileScan.useDelimiter("[^a-zA-Z0-9-]+");
            int position = 0;

            TreeMap<String, ArrayList<Integer>> wordLocations = new TreeMap<>();
            HashSet<String> skipWords = new HashSet<>(Arrays.asList("a", "an", "and", "the", "they", "to", "for", "their", "you", "your", "are", "as", "but", "by", "can", "did", "from", "her", "him", "in", "is", "it", "or", "that", "this", "with"));

            while(fileScan.hasNext()) {
                String word = fileScan.next().toLowerCase();

                if(!skipWords.contains(word)) {
                    wordLocations.computeIfAbsent(word, k -> new ArrayList<>()).add(position);
                }

                position++;

            }

            fileScan.close();

            try{
                FileWriter fw = new FileWriter("index.txt");
                BufferedWriter bw = new BufferedWriter(fw);

                for(String word : wordLocations.keySet()) {
                    bw.write(word + ": " + wordLocations.get(word) + "\n");
                }
                bw.close();
                System.out.println("Index written to 'index.txt'");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

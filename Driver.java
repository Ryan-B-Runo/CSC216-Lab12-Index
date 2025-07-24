import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
            while(fileScan.hasNextLine()) {
                data.append(fileScan.nextLine()).append("\n");
            }
            fileScan.close();
        }

        System.out.println(data);

    }

}

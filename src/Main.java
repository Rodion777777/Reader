import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Введите адрес .txt файла в следующем формате \"D:/Desktop/doc1.txt\" : ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufReader = new BufferedReader(new FileReader(reader.readLine()));
        ArrayList<String> listOfLines = new ArrayList<String>();
        String line = bufReader.readLine();
        String result = "";

        while (line != null)
        {
            String[] subStr;
            String delimeter = " "; // Разделитель
            subStr = line.split(delimeter);
            for(int i = 0; i < subStr.length; i++) {
                listOfLines.add(subStr[i]);
            }
            line = bufReader.readLine();
        }
        bufReader.close();

        Collections.sort(listOfLines, String.CASE_INSENSITIVE_ORDER);



        for (String s : listOfLines){
            System.out.println(s);
        }
    }
}
//D:/Desktop/doc1.txt
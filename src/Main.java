import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите в консоли адрес .txt файла в следующем формате D:/Desktop/doc1.txt " +
                "или в формате имя_файла.txt, если файл находится в корневом каталоге проекта: ");

        BufferedReader bufReader = new BufferedReader(new FileReader(reader.readLine()));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();


        while (line != null)
        {
            String[] subStr;
            subStr = line.split("[^a-zа-я]+");
            for(int i = 0; i < subStr.length; i++) {
                listOfLines.add(subStr[i]);
            }
            line = bufReader.readLine();
        }
        bufReader.close();

        Collections.sort(listOfLines, String.CASE_INSENSITIVE_ORDER);


        System.out.println("Слова из файла в алфавитном порядке: ");
        for (String s : listOfLines){
            System.out.println(s);
        }

        Map<String, Integer> statistics = new HashMap<>();
        for (String word : listOfLines) {
            if(!word.isEmpty()) {
                Integer count = statistics.get(word);
                if(count == null) {
                    count = 0;
                }
                statistics.put(word, ++count);
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Статистика встречаемости слов в файле: ");
        for(String word : statistics.keySet()) {
            System.out.println("Слово " + "\"" + word + "\"" +" встречается в файле " + statistics.get(word) + " раз(а).");
        }

        String s = null;
        int p = 0;
        for (String w : statistics.keySet()) {
            if (p < statistics.get(w)) {
                p = statistics.get(w);
                s = w;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Самое повторяющееся слово: " + "\"" + s + "\"" + " (встречается " + statistics.get(s) + " раз(а))");
    }
}
//
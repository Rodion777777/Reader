import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите в консоли адрес .txt файла в следующем формате D:/Desktop/doc1.txt " +
                "или в формате имя_файла.txt, если файл находится в корневом каталоге проекта: ");

        BufferedReader bufReader = new BufferedReader(new FileReader(reader.readLine()));

        String line = bufReader.readLine();


        SortedMap<String, Integer> statistics = new TreeMap<>();

        while (line != null) {
            for (String word : line.split("[^A-Za-zа-яА-Я]+")) {
                if(!word.isEmpty()) {
                    Integer count = statistics.get(word);
                    if(count == null) {
                        count = 0;
                    }
                    statistics.put(word, ++count);
                }
            }
            line = bufReader.readLine();
        }
        bufReader.close();





        System.out.println("Слова из файла в алфавитном порядке: ");
        for (String s : statistics.keySet()){
            System.out.println(s);
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
        for (String w : statistics.keySet()){
            if(p == statistics.get(w)){
                s = w;
                System.out.println("Самое повторяющееся слово: " + "\"" + s + "\"" + " (встречается " + statistics.get(s) + " раз(а))");
            }
        }


    }
}
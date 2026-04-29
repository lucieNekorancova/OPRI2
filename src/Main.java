import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        URL numbersFile = Main.class.getClassLoader().getResource("numbers.csv");
        String path = URLDecoder.decode(numbersFile.getFile());
        File file = new File(path);
        System.out.println("Soubor existuje:" + file.exists());

        {

        //FileReader
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
        String line = br.readLine();

        if(line == null){
            System.out.println("Soubore je prazdny");
        }
        while(line!=null){
            System.out.println(line);
            line = br.readLine();
        }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



            URL JsonUrl = Main.class.getClassLoader().getResource("input.json");
            String InputPathString = URLDecoder.decode(numbersFile.getFile());
            File inputFile = new File(InputPathString);

            try {
              String wholeInputString =  Files.readString(Paths.get(InputPathString));
              Gson gson = new Gson();
              ArrayList<item> items = new ArrayList<>();
                String wholeInputFileString;
                items.addAll(gson.fromJson(wholeInputFileString, TypeToken.getParameterized(item.class)));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
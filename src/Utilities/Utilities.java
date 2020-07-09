package Utilities;



import javax.sound.sampled.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Utilities {



    public static String loadFileAsString(String fileURL){
        StringBuilder builder = new StringBuilder();

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileURL));
            String line;
            while((line = br.readLine()) != null){
                builder.append(line + "\n");

            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();

        }

        return builder.toString(); //Return everything which has been appended
    }

    public static int parseInt(String number){
        try{
            return Integer.parseInt(number);

        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }


}

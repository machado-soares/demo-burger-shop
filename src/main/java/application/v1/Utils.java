package application.v1;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;

public class Utils {

    public static void clearConsole() throws IOException, InterruptedException {
        final String os = System.getProperty("os.name");
        if (os.contains("Windows")){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime().exec("clear");
        }
    }

    public static void printList(List<String> stringList){
        for(int i=0; i< stringList.size();i++){
            System.out.println(i + " - " + stringList.get(i));
        }
    }
}

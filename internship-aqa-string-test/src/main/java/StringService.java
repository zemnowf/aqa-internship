import java.io.*;

public class StringService {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            File file = new File("file.txt");
            if(!file.exists()){
                file.createNewFile();
            }

            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("test string");
            printWriter.close();

            bufferedReader = new BufferedReader(new FileReader("file.txt"));
            String actualLine = bufferedReader.readLine();
            System.out.printf(actualLine);

        } catch (IOException e){
            System.out.println("Error: " + e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e){
                System.out.println("Error: " + e);
            }
        }
    }
}

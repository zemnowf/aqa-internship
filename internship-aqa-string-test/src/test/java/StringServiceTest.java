import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringServiceTest {
    static PrintWriter printWriter;
    static File file;
    BufferedReader bufferedReader;

    @BeforeAll
    static void prepareFile(){
        try {
            file = new File("file.txt");
            if(!file.exists()){
                file.createNewFile();
            }

            printWriter = new PrintWriter(file);
            printWriter.println("testf string");
            printWriter.close();

        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }

    @BeforeEach
    void prepareReader() throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader("file.txt"));
    }

    @Test
    void readFile() throws IOException {
        String actualLine = bufferedReader.readLine();
        assertEquals("test string", actualLine);
    }

//    @Test
//    void assertWrongLine() throws IOException {
//        String actualLine = bufferedReader.readLine();
//        assertEquals("wrong line", actualLine);
//    }

    @AfterEach
    void closeReader() throws IOException {
        bufferedReader.close();
    }

    @AfterAll
    static void vanishFile(){
        //file.delete();
    }

}

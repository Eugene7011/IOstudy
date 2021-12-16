package filemanager;

import com.podzirey.iostudy.filemanager.FileManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

public class FileManagerTest {

    @Test
    public void countFiles(){
        FileManager fileManager = new FileManager();
        String pathFile = System.getProperty("user.dir");

        assertEquals(18, fileManager.countFiles(pathFile));
    }

    @Test
    public void countDirs(){
        FileManager fileManager = new FileManager();
        String path = System.getProperty("user.dir");

        assertEquals(65, fileManager.countDirs(path));
    }

    @Test
    public void copy() throws IOException {
        FileManager fileManager = new FileManager();
        String pathCopyFrom = "testCopyFrom";
        String pathCopyTo = "testCopyTo";

        fileManager.copy(pathCopyFrom, pathCopyTo);

         File fileCopyTo = new File("testCopyTo\\test.docx");

        assertTrue(fileCopyTo.exists());
    }

    @Test
    public void move() throws IOException {
        FileManager fileManager = new FileManager();
        String pathMoveFrom = "testMoveFrom";
        String pathMoveTo = "testMoveTo";

        fileManager.move(pathMoveFrom, pathMoveTo);

        File pathMoveToFile1 = new File("testMoveTo\\Типы данных.jpg");
        File pathMoveToFile2 = new File("testMoveTo\\testFrom");

        assertTrue(pathMoveToFile1.exists());
        assertTrue(pathMoveToFile2.exists());

        File pathMoveFromFile1 = new File("testMoveFrom\\Типы данных.jpg");
        File pathMoveFromFile2 = new File("testMoveFrom\\testFrom");

        assertFalse(pathMoveFromFile1.exists());
        assertFalse(pathMoveFromFile2.exists());
    }

}

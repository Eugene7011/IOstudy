import java.io.*;
import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) throws Exception {
        //writeContent("test2.txt", "Hello java!");
        String content = readContent("test2.txt");
        System.out.println(content);

        //create
//        File path = new File("test.log");
//        System.out.println(path.exists());
//        System.out.println(path.getAbsolutePath());
//        System.out.println(path.createNewFile());
//        System.out.println(path.exists());

        // file directory path
        File path2 = new File("C:\\Windows");
        System.out.println(path2.isDirectory());
        File[] innerPaths = path2.listFiles();
        for (File innerPath : innerPaths) {
            String type = innerPath.isFile() ? "FILE: " : "DIR: ";
            System.out.println(type + innerPath);
        }

//        OutputStream outputStream = new FileOutputStream("test.log");
//        //void write(int value)
//        //void write(byte[] buffer)
//        char c = 'H';
//        byte value = (byte) c;
//        outputStream.write(value);
//        String restStr = "ello IO!";
//        byte[] bytes = restStr.getBytes();
//        outputStream.write(bytes);

    }

    static String readContent(String path) throws IOException {
        File pathToFile = new File(path);
        InputStream inputStream = new FileInputStream(pathToFile);
        // int read();
        // byte  [-128, 127];
        // int value = 100; byte b = (byte) value; => 100
        // int value = 255; byte b = (byte) value; => -1
        // int read(): -> [0, 255] -> (byte) -> [-128, 127]
        // int read() -> -1 -> end of stream

        int fileLength = (int) pathToFile.length();
        byte[] contentArray = new byte[fileLength];
        inputStream.read(contentArray);


        inputStream.close();

        return new String(contentArray);
    }

    static void writeContent (String path, String content) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        byte[] bytes = content.getBytes();
        outputStream.write(bytes);

        outputStream.close();
    }
}

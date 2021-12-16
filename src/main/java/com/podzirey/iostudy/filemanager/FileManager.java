package com.podzirey.iostudy.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileManager {
    private String path;
    private String from;
    private String to;

    public static int countFiles(String path) {
        int count = 0;

        File pathDir = new File(path);
        System.out.println(pathDir.isDirectory());
        while (pathDir.getParent() != null){

            File[] innerPaths = pathDir.listFiles();
            for (File innerPath : innerPaths) {
                if (innerPath.isFile()) {
                    count++;
                }
            }
            pathDir = pathDir.getParentFile();
        }

        return count;
    }

    public static int countDirs(String path){
        int count = 0;

        File pathDir = new File(path);
        System.out.println(pathDir.isDirectory());
        while (pathDir.getParent() != null){

            File[] innerPaths = pathDir.listFiles();
            for (File innerPath : innerPaths) {
                if (innerPath.isDirectory()) {
                    count++;
                }
            }
            pathDir = pathDir.getParentFile();
        }

        return count;
    }

    public static void copy(String from, String to) throws IOException {
        File pathFrom = new File(from);
        File path = new File(to);
        Path pathTo = Paths.get(to);

        System.out.println("Path from is " + pathFrom.exists());
        System.out.println("Path to is " + path.exists());

        File[] listOfFiles = pathFrom.listFiles();
        if(listOfFiles.length == 0){
            System.out.println("Path from is empty");
        }

        for (File file : listOfFiles) {
            Files.copy(file.toPath(), pathTo.resolve(file.getName()),
                    StandardCopyOption.REPLACE_EXISTING);
        }

    }

    public static void move(String from, String to) throws IOException {
        File pathFrom = new File(from);
        File path = new File(to);
        Path pathTo = Paths.get(to);

        System.out.println("Path from is " + pathFrom.exists());
        System.out.println("Path to is " + path.exists());

        File[] listOfFiles = pathFrom.listFiles();
        if(listOfFiles.length == 0){
            System.out.println("Path from is empty");
        }

        for (File file : listOfFiles) {
            Files.move(file.toPath(), pathTo.resolve(file.getName()),
                    StandardCopyOption.REPLACE_EXISTING);
        }
    }

}

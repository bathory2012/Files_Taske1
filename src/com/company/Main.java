package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        final List<String> dirList = new ArrayList<>(Arrays.asList(
                "C:/Games/src",
                "C:/Games/res",
                "C:/Games/save_games",
                "C:/Games/temp",
                "C:/Games/src/main",
                "C:/Games/src/test",
                "C:/Games/res/drawables",
                "C:/Games/res/vectors",
                "C:/Games/res/icons"
        ));

        final List<String> filesList = new ArrayList<>(Arrays.asList(
                "C:/Games/src/main/Main.java",
                "C:/Games/src/main/Utils.java",
                "C:/Games/temp/temp.temp.txt"
        ));

        for (String newDir : dirList) {
            File dir = new File(newDir);
            if (dir.mkdir()) {
                sb.append(dir.getAbsolutePath()).append(" - директория создана\n");
            } else {
                sb.append(dir.getAbsolutePath()).append(" - ошибка при создании директории\n");
            }
        }

        for (String newFile : filesList) {
            try {
                File file = new File(newFile);
                if (file.createNewFile()) {
                    sb.append(file.getAbsolutePath()).append(" - файл создан\n");
                } else {
                    sb.append(file.getAbsolutePath()).append(" - ошибка при создании файла\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sb);
        writeFile(sb);
    }

    public static void writeFile(StringBuilder sb) {
        try (FileWriter wf = new FileWriter("C:/Games/temp/temp.temp.txt", false)) {
            wf.write(sb.toString());
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}

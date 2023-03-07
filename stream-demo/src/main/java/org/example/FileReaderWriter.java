package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2023-03-02 17:00
 */
public class FileReaderWriter {
    public static void main(String[] args) {
        File oldFile = new File("stream-demo/src/main/resources/test.txt");
        File newFile = new File("stream-demo/src/main/resources/newTest.txt");
        readByStreamReader(oldFile, newFile);
    }

    public static void readByStreamReader(File oldFile, File newFile) {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(oldFile), StandardCharsets.UTF_8);
             OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(newFile), StandardCharsets.ISO_8859_1)){
            char[] buffer = new char[1024];
            int len = 0;
            while ((len = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, len);
            }
            writer.write(1234);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
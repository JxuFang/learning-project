package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2023-03-02 10:30
 */
public class FileStreamTest {

    public static void main(String[] args) {
        File oldFile = new File("stream-demo/src/main/resources/test.txt");
        File newFile = new File("stream-demo/src/main/resources/newTest.txt");
//        readByteByByte(oldFile, newFile);
//        readByByteArray(oldFile, newFile);
        readByBufferedStream(oldFile, newFile);
    }

    /**
     * @author Fang Jinxu
     * @Description 一个字节一个字节读取
     * @date 2023/3/2 14:02
     * @param oldFile
     * @param newFile
     * @return void
     */
    public static void readByteByByte(File oldFile, File newFile) {
        try (FileInputStream in = new FileInputStream(oldFile);
             FileOutputStream out = new FileOutputStream(newFile)){
            int len = 0;
            while ((len = in.read()) != -1) {
                out.write(len);
            }
            ServerSocket serverSocket = new ServerSocket();
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @author Fang Jinxu
     * @Description 按照字节数组批量读取
     * @date 2023/3/2 14:02
     * @param oldFile
     * @param newFile
     * @return void
     */
    public static void readByByteArray(File oldFile, File newFile){
        try (FileInputStream in = new FileInputStream(oldFile);
             FileOutputStream out = new FileOutputStream(newFile)) {
            // 定义一个缓冲字节数组，按照字节数组读取，比一个一个读取快
            byte[] buffer = new byte[1024];
            // len用来读取这次读取的字节总数
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                // 按照读取的字节总数，来写入字节
                out.write(buffer, 0, len);
            }
            out.write(123);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readByBufferedStream(File oldFile, File newFile) {
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(oldFile));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(newFile))){
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
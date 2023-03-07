package org.example;

import java.util.Scanner;

/**
 * @Author: Fang Jinxu
 * @Description:
 * @Date: 2023-03-02 10:13
 */
public class ScannerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println("输入数据为："+scanner.nextLine());
        }
        scanner.close();
    }
}
package com.longhu.controller;

import java.io.*;

/**
 * @author: houyong
 * @description:
 * @create: 2019-04-22 14:44
 */
public class Test {
    public static void main(String[] args) {
        /*int bidCount=52;
        double ceil = bidCount / 5;
        double temp = Math.ceil(ceil);
        System.out.println("temp=" + temp);

        ceil = bidCount / 5.0;
        System.out.println("ceil=" + ceil);

        temp = Math.ceil(ceil);
        System.out.println("temp=" + temp);*/

        File resourcePath = new File("e:\\aaa.txt");

        File destPath = new File("d:\\aaa.txt");


        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(resourcePath);
            out = new FileOutputStream(destPath);
            int n;
            byte[] buffer = new byte[2];
            while (-1 != (n = in.read(buffer))) {
                out.write(buffer, 0, n);
                throw new RuntimeException("aa");
            }
        } catch (Exception e) {
            keep(resourcePath, destPath);
        } finally {
        }

    }

    public static void keep(File res, File dest) {
        try {
            RandomAccessFile randomAccessFile = null;
            randomAccessFile = new RandomAccessFile(res, "rw");
            RandomAccessFile randomAccessFilel = new RandomAccessFile(dest, "rw");

            randomAccessFile.seek(2);
            randomAccessFilel.seek(2);

            byte[] bytes = new byte[2];
            int n;
            while (-1 != (n = randomAccessFile.read(bytes))) {
                randomAccessFilel.write(bytes, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

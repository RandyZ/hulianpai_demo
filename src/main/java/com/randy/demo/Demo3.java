package com.randy.demo;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Create with project demo
 *
 * @author randy
 * @date 2019/9/1 15:59
 */
public class Demo3 {
    private final static String FILE_PATH = "/Users/randy/WorkOn/互联派/搜狗语料库-已分词.txt";

    public static void main(String[] args) {
//        testCharStream();
        testByteStream();
    }

    private static void testByteStream() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }
        byte[] buffers = new byte[1024];
        try (
                InputStream inStream = new FileInputStream(new File(FILE_PATH));
        ) {
            while (inStream.read(buffers) > 0) {
                System.out.print(new String(buffers));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testCharStream() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }
        try (
                InputStream inStream = new FileInputStream(new File(FILE_PATH));
                InputStreamReader inputStreamReader = new InputStreamReader(inStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            String line;
            while (StringUtils.isNoneEmpty(line = bufferedReader.readLine())) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

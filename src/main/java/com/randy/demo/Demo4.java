package com.randy.demo;

import io.reactivex.Observable;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

/**
 * Create with project demo
 *
 * @author randy
 * @date 2019/9/1 16:47
 */
public class Demo4 {

    private final static String FILE_PATH = "/Users/randy/WorkOn/互联派/搜狗语料库-已分词.txt";

    public static void main(String[] args) {
//        createStream()
//                .flatMap(s -> {
//                    String[] spliteRet = StringUtils.split(s, " ");
//                    return Arrays.stream(spliteRet);
//                })
//                .forEach(System.out::println);
        createLazyStream()
                .blockingForEach(System.out::println);
    }

    private static Stream<String> createStream() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("文件不存在");
            return Stream.empty();
        }
        try (
                InputStream inStream = new FileInputStream(new File(FILE_PATH));
                InputStreamReader inputStreamReader = new InputStreamReader(inStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            Stream.Builder<String> streamBuilder = Stream.builder();
            String line;
            while (StringUtils.isNoneEmpty(line = bufferedReader.readLine())) {
                streamBuilder.accept(line);
            }
            return streamBuilder.build();
        } catch (IOException e) {
            e.printStackTrace();
            return Stream.empty();
        }
    }

    private static Observable<String> createLazyStream() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("文件不存在");
            return Observable.empty();
        }
        try {
            InputStream inStream = new FileInputStream(new File(FILE_PATH));
            InputStreamReader inputStreamReader = new InputStreamReader(inStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return Observable.fromIterable(new IterableSupporter<>(() -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            })).doOnTerminate(() -> {
                inStream.close();
                inputStreamReader.close();
                bufferedReader.close();
            });
        } catch (Throwable e) {
            return Observable.empty();
        }
    }
}

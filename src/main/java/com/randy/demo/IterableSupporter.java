package com.randy.demo;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Supplier;

/**
 * Created with backend.
 * Date: 2018/5/22.
 * Time: 上午11:59.
 *
 * @author randy.
 */
public class IterableSupporter<T> implements Iterable<T> {
    private Iterator<T> iterator;

    public IterableSupporter(Supplier<T> dataSupplier) {
        Queue<T> bufferQueue = new ConcurrentLinkedQueue<>();
        iterator = new Iterator<T>() {

            @Override
            public boolean hasNext() {
                if (bufferQueue.isEmpty()) {
                    try {
                        T dataItem = dataSupplier.get();
                        if (dataItem != null) {
                            bufferQueue.add(dataItem);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return !bufferQueue.isEmpty();
            }

            @Override
            public T next() {
                T itemData = bufferQueue.poll();
                if (itemData == null) {
                    try {
                        itemData = dataSupplier.get();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return itemData;
            }
        };
    }

    @Override
    public Iterator<T> iterator() {
        return iterator;
    }
}

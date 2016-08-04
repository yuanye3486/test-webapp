package com.fengqiliu.test.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Administrator on 2015/12/29.
 */
public class KafkaConsumerRunner implements Runnable {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final KafkaConsumer consumer;
    private final List<String> topicList = new ArrayList<>();

    KafkaConsumerRunner(KafkaConsumer consumer, String topic) {
        this.consumer = consumer;
        topicList.add(topic);
    }

    public void run() {
        try {
            consumer.subscribe(topicList);
            while (!closed.get()) {
                System.out.println("outer while... ");
                ConsumerRecords records = consumer.poll(10000);
                Iterator<ConsumerRecord> recordsIterator = records.iterator();
                while (recordsIterator.hasNext()) {
                    ConsumerRecord record = recordsIterator.next();
                    System.out.println("*****************************************************");
                    System.out.println("topic:" + record.topic());
                    System.out.println("partition:" + record.partition());
                    System.out.println("key:" + record.key());
                    System.out.println("offset:" + record.offset());
                    System.out.println("value:" + record.value());
                    System.out.println();
                }
            }
        } catch (WakeupException e) {
            // Ignore exception if closing
            if (!closed.get()) throw e;
        } finally {
            consumer.close();
        }
    }

    /**
     * Shutdown hook which can be called from a separate thread
     */
    public void shutdown() {
        closed.set(true);
        consumer.wakeup();
    }
}

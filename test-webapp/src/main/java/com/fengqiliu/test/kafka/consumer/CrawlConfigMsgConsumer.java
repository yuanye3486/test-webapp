package com.fengqiliu.test.kafka.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2015/12/24.
 */
public class CrawlConfigMsgConsumer {
    private static final String TOPIC = "CRAWLRADAR-CHECK-RESULT";//"CRAWLRADAR-CHECK_1";
    private final ExecutorService executor;

    public CrawlConfigMsgConsumer() {
        Properties props = new Properties();
        InputStream in = CrawlConfigMsgConsumer.class.getResourceAsStream("/consumer.properties");
        try {
            props.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        executor = Executors.newFixedThreadPool(1);

        KafkaConsumer<String, String> consumer = new KafkaConsumer(props);
        executor.submit(new KafkaConsumerRunner(consumer, TOPIC));
    }

    public static void main(String[] args) {
        new CrawlConfigMsgConsumer();

    }
}
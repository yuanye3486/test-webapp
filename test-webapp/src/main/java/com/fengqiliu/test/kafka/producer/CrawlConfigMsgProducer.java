package com.fengqiliu.test.kafka.producer;

import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/12/24.
 */
public class CrawlConfigMsgProducer {
    private static final Producer<String, String> producer;
    private static final String TOPIC = "CRAWLPOINT-DEPLOYMENT-TOPIC";

    static {
        Properties props = new Properties();
        InputStream in = CrawlConfigMsgProducer.class.getResourceAsStream("/producer.properties");
        try {
            props.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        producer = new KafkaProducer<>(props);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random(3);
        System.out.println("please input your message:");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (StringUtils.isEmpty(line)) {
                continue;
            }
            if ("exit".equals(line.toLowerCase())) {
                producer.close();
                break;
            }
            int key = random.nextInt(5);
            ProducerRecord<String, String> msg = new ProducerRecord<>(TOPIC, key + "", line);
            producer.send(msg);
            System.out.println("send message success!");
            System.out.println();
            System.out.println("please input your message:");
        }

    }
}
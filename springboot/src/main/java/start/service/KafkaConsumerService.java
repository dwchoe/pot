package start.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

/**
 * Created by z0019mz on 5/14/17.
 */
public class KafkaConsumerService implements Runnable {

    @Override
    public void run() {
        Random random = new Random();

        System.out.println("checking..." + random.nextInt());

        System.out.println( "Starting Consumer..." );
        Properties props = new Properties();

        // in stream properties - just for ease of use - don't implement this way in production
        props.put("bootstrap.servers", "hostname:port");
        props.put("bootstrap.servers", "hostname:port");

        // specify group.id for application - optional but if set multiple processes can be part of same consumer group - competing consumer pattern
        props.put("group.id", "test");

        // specify a unique client.id for your application - should be set by the user to assist in tracing calls, etc
        props.put("client.id", "test-consumer");

        props.put("enable.auto.commit", "true");
        props.put("auto.offset.reset", "earliest");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        //SSL based access details - required for Kafka 0.9
        props.put("security.protocol", "SSL");
        props.put("ssl.protocol", "TLSv1.2");

        // topic for loyalty-guest-enrollment
        props.put("ssl.truststore.location", "/Applications/kafka/kafka_2.10-0.10.0.0/ssl-profile/client.truststore.jks");
        props.put("ssl.truststore.password", "a@t3qhW28E1CXYA%");
        props.put("ssl.keystore.location", "/Applications/kafka/kafka_2.10-0.10.0.0/ssl-profile/server.keystore.jks");
        props.put("ssl.keystore.password", "a@t3qhW28E1CXYA%");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("topic_name"));

        System.out.println("polling for messages");
        try {
            while (true) {

                ConsumerRecords<String, String> records = consumer.poll(1);

                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("offset = %d, partition = %s, key = %s, value = %s\n", record.offset(), record.partition(), record.key(), record.value());


                }
            }
        }
        finally {
            consumer.close();
        }

    }
}

package start.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by z0019mz on 5/14/17.
 */
public class KafkaProducer {
    public static void main(String[] arg) throws InterruptedException {
        String serializer = "org.apache.kafka.common.serialization.StringSerializer";
        String keystorePassword = "a@t3qhW28E1CXYA%";
        Properties props = new Properties();
        props.put("bootstrap.servers", "ttcesvlx1052.target.com:9093");
        props.put("acks", "all");
        props.put("retries", Integer.valueOf(0));
        props.put("batch.size", Integer.valueOf(16384));
        props.put("linger.ms", Integer.valueOf(1));
        props.put("buffer.memory", Integer.valueOf(33554432));
        props.put("client.id", "test-SimpleProducerSSL-1");
        props.put("key.serializer", serializer);
        props.put("value.serializer", serializer);
        props.put("security.protocol", "SSL");
        props.put("ssl.protocol", "TLSv1.2");
        props.put("ssl.truststore.location", "/Applications/kafka/kafka_2.10-0.10.0.0/ssl-profile/client.truststore.jks");
        props.put("ssl.truststore.password", keystorePassword);
        props.put("ssl.keystore.location", "/Applications/kafka/kafka_2.10-0.10.0.0/ssl-profile/server.keystore.jks");
        props.put("ssl.keystore.password", keystorePassword);
        Date curDate = new Date();
        new SimpleDateFormat();
        String topic = "egs-profile-uat-app-supermario";
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ssss");
        String dateToStr = format.format(curDate);
        KafkaProducer producer = new KafkaProducer(props);

        for(int i = 0; i < 1000; ++i) {
            try {
                producer.send(new ProducerRecord(topic, Integer.toString(i), dateToStr + i));
            } catch (Exception var11) {
                ;
            }

            Thread.sleep(100L);
        }

        producer.close();
    }

    public void sendMessage(String topic) {
        String serializer = "org.apache.kafka.common.serialization.StringSerializer";
        String keystorePassword = "a@t3qhW28E1CXYA%";
        Properties props = new Properties();
        props.put("bootstrap.servers", "ttcesvlx1052.target.com:9093");
        props.put("acks", "all");
        props.put("retries", Integer.valueOf(0));
        props.put("batch.size", Integer.valueOf(16384));
        props.put("linger.ms", Integer.valueOf(1));
        props.put("buffer.memory", Integer.valueOf(33554432));
        props.put("client.id", "test-SimpleProducerSSL-1");
        props.put("key.serializer", serializer);
        props.put("value.serializer", serializer);
        props.put("security.protocol", "SSL");
        props.put("ssl.protocol", "TLSv1.2");
        props.put("ssl.truststore.location", "/Applications/kafka/kafka_2.10-0.10.0.0/ssl-profile/client.truststore.jks");
        props.put("ssl.truststore.password", keystorePassword);
        props.put("ssl.keystore.location", "/Applications/kafka/kafka_2.10-0.10.0.0/ssl-profile/server.keystore.jks");
        props.put("ssl.keystore.password", keystorePassword);
        KafkaProducer producer = new KafkaProducer(props);

        try {
            producer.send(new ProducerRecord(topic, "testing", "testing 1 2 3"));
        } catch (Exception var10) {
            ;
        } finally {
            producer.close();
        }

        producer.close();
    }
}

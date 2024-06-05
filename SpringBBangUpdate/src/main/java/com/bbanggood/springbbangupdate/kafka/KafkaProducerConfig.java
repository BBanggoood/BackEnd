package com.bbanggood.springbbangupdate.kafka;

import org.springframework.kafka.support.serializer.JsonSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaProducerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String servers;

    // Producer Factory
    @Bean
    public ProducerFactory<String, BBangVodMessage> producerVodFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }
    @Bean
    public ProducerFactory<String, BBangCastMessage> producerCastFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }
    @Bean
    public ProducerFactory<String, BBangDirectorMessage> producerDirectorFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, BBangVodMessage> kafkaVodAddTemplate() {
        return new KafkaTemplate<>(producerVodFactory());
    }
    @Bean
    public KafkaTemplate<String, BBangCastMessage> kafkaCastAddTemplate() {
        return new KafkaTemplate<>(producerCastFactory());
    }
    @Bean
    public KafkaTemplate<String, BBangDirectorMessage> kafkaDirectorAddTemplate() {
        return new KafkaTemplate<>(producerDirectorFactory());
    }
    @Bean
    public KafkaTemplate<String, BBangVodMessage> kafkaVodDeleteTemplate() {
        return new KafkaTemplate<>(producerVodFactory());
    }
    @Bean
    public KafkaTemplate<String, BBangCastMessage> kafkaCastDeleteTemplate() {
        return new KafkaTemplate<>(producerCastFactory());
    }
    @Bean
    public KafkaTemplate<String, BBangDirectorMessage> kafkaDirectorDeleteTemplate() {
        return new KafkaTemplate<>(producerDirectorFactory());
    }
}

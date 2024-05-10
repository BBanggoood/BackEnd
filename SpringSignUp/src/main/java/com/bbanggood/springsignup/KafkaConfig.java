package com.bbanggood.springsignup;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

// 설정 클래스로 만들어지고 프로젝트를 실행할 때 먼저 내용을 읽어서
// 인스턴스를 만들고 작업을 수행
@Configuration
public class KafkaConfig {
    // 하드 코딩 대신 설정 파일을 이용하고
    // 외부에서 생성한 값을 대입받아서 사용: 의존성 주입
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    // 이 메서드가 리턴한 인스턴스를 Bean으로 생성
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}

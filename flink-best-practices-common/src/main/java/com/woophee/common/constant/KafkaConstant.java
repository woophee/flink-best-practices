package com.woophee.common.constant;

public class KafkaConstant {
    public static final String BOOTSTRAP_SERVERS = "kafka.bootstrap.servers";
    public static final String DEFAULT_BOOTSTRAP_SERVERS = "127.0.0.1:9092";
    public static final String TOPIC = "kafka.topic";
    public static final String DEFAULT_TOPIC = "topic";
    public static final String GROUP_ID = "kafka.group.id";
    public static final String DEFAULT_GROUP_ID = "group";
    public static final String KEY_DESERIALIZER = "kafka.key.deserializer";
    public static final String DEFAULT_KEY_DESERIALIZER = "org.apache.kafka.common.serialization.ByteArraySerializer";
    public static final String VALUE_DESERIALIZER = "kafka.value.deserializer";
    public static final String DEFAULT_VALUE_DESERIALIZER = "org.apache.kafka.common.serialization.ByteArraySerializer";
}

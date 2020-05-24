package com.woophee.common.schema;

import com.alibaba.fastjson.JSON;
import com.woophee.common.message.MetricMessage;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.connectors.kafka.KafkaDeserializationSchema;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class MetricDeserializationSchema implements KafkaDeserializationSchema<MetricMessage> {
    @Override
    public boolean isEndOfStream(MetricMessage metricMessage) {
        return false;
    }

    @Override
    public MetricMessage deserialize(ConsumerRecord<byte[], byte[]> consumerRecord) throws Exception {
        byte[] key = consumerRecord.key();
        byte[] value = consumerRecord.value();
        return JSON.parseObject(value, MetricMessage.class);
    }

    @Override
    public TypeInformation<MetricMessage> getProducedType() {
        return TypeInformation.of(MetricMessage.class);
    }
}

package com.woophee.common.utils;

import com.woophee.common.constant.KafkaConstant;
import org.apache.flink.api.java.utils.ParameterTool;

import java.util.Properties;

public class KafkaConfigUtil {

    public static Properties buildKafkaProps(ParameterTool parameterTool) {
        Properties props = parameterTool.getProperties();
        props.put("bootstrap.servers", parameterTool.get(KafkaConstant.BOOTSTRAP_SERVERS, KafkaConstant.DEFAULT_BOOTSTRAP_SERVERS));
        props.put("group.id", parameterTool.get(KafkaConstant.GROUP_ID, KafkaConstant.DEFAULT_GROUP_ID));
        props.put("key.deserializer", parameterTool.get(KafkaConstant.KEY_DESERIALIZER,KafkaConstant.DEFAULT_KEY_DESERIALIZER));
        props.put("value.deserializer", parameterTool.get(KafkaConstant.VALUE_DESERIALIZER,KafkaConstant.DEFAULT_VALUE_DESERIALIZER));
        return props;
    }
}

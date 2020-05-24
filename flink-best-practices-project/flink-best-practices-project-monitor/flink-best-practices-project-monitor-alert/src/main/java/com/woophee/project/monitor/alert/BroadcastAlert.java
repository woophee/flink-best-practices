package com.woophee.project.monitor.alert;

import com.woophee.common.constant.KafkaConstant;
import com.woophee.common.message.MetricMessage;
import com.woophee.common.schema.MetricDeserializationSchema;
import com.woophee.common.utils.ExecutionEnvUtil;
import com.woophee.common.utils.KafkaConfigUtil;
import com.woophee.common.utils.ParameterToolUtil;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class BroadcastAlert {
    public static void main(String[] args) throws Exception {
        ParameterTool parameterTool = ParameterToolUtil.buildFromAll(args);
        StreamExecutionEnvironment env = ExecutionEnvUtil.buildStreamExecutionEnv(parameterTool);
        Properties properties = KafkaConfigUtil.buildKafkaProps(parameterTool);


        FlinkKafkaConsumer<MetricMessage> consumer = new FlinkKafkaConsumer<>(
                parameterTool.get(KafkaConstant.TOPIC, KafkaConstant.DEFAULT_TOPIC),
                new MetricDeserializationSchema(),
                properties);
        env.addSource(consumer);
    }
}

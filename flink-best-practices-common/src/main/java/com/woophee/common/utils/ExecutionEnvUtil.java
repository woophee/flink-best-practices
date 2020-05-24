package com.woophee.common.utils;

import com.woophee.common.constant.NormalConstant;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class ExecutionEnvUtil {

    /**
     * Build streamExecutionEnvironment by parameterTool
     * @param parameterTool
     * @return
     */
    public static StreamExecutionEnvironment buildStreamExecutionEnv(ParameterTool parameterTool) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(parameterTool.getInt(NormalConstant.JOB_PARALLELISM, NormalConstant.DEFAULT_JOB_PARALLELISM));
        if (parameterTool.getBoolean(NormalConstant.JOB_CHECKPOINT_ENABLE, NormalConstant.DEFAULT_JOB_CHECKPOINT_ENABLE)) {
            env.enableCheckpointing(parameterTool.getLong(NormalConstant.JOB_CHECKPOINT_INTERVAL, NormalConstant.DEFAULT_JOB_CHECKPOINT_INTERVAL));
        }
        env.getConfig().setGlobalJobParameters(parameterTool);
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        return env;
    }

    /**
     * Build default streamExecutionEnvironment
     * @return
     */
    public static StreamExecutionEnvironment buildDefaultStreamExecutionEnv() {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(NormalConstant.DEFAULT_JOB_PARALLELISM);
        if (NormalConstant.DEFAULT_JOB_CHECKPOINT_ENABLE){
            env.enableCheckpointing(NormalConstant.DEFAULT_JOB_CHECKPOINT_INTERVAL);
        }
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        return env;
    }
}

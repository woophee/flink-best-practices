package com.woophee.common.utils;

import com.woophee.common.constant.NormalConstant;
import org.apache.flink.api.java.utils.ParameterTool;

import java.io.IOException;

public class ParameterToolUtil {

    /**
     * Build parameterTool with default properties, args and system properties
     * @param args
     * @return
     * @throws IOException
     */
    public static ParameterTool buildFromAll(final String[] args) throws IOException {
        return ParameterTool
                .fromPropertiesFile(ParameterToolUtil.class.getResourceAsStream(NormalConstant.DEFAULT_PROPERTIES))
                .mergeWith(ParameterTool.fromArgs(args))
                .mergeWith(ParameterTool.fromSystemProperties());
    }

    /**
     * Build parameterTool with default properties
     * @return
     * @throws IOException
     */
    public static ParameterTool buildFromDefaultProperties() throws IOException {
        return ParameterTool
                .fromPropertiesFile(ParameterToolUtil.class.getResourceAsStream(NormalConstant.DEFAULT_PROPERTIES))
                .mergeWith(ParameterTool.fromSystemProperties());
    }

    /**
     * Build from system properties
     * @return
     */
    public static ParameterTool buildFromSystemProperties() {
        return ParameterTool.fromSystemProperties();
    }

    /**
     * Build from args
     * @param args
     * @return
     */
    public static ParameterTool buildFromArgs(final String[] args) {
        return ParameterTool.fromArgs(args);
    }
}

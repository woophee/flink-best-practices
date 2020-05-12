package com.woophee.common.utils;

import com.woophee.common.constant.NormalConstant;
import org.apache.flink.api.java.utils.ParameterTool;

import java.io.IOException;

public class ParameterToolUtil {
    public static ParameterTool buildParameterTool(final String[] args) throws IOException {
        return ParameterTool
                .fromPropertiesFile(ParameterToolUtil.class.getResourceAsStream(NormalConstant.DEFAULT_PROPERTIES))
                .mergeWith(ParameterTool.fromArgs(args))
                .mergeWith(ParameterTool.fromSystemProperties());
    }

    public static ParameterTool buildParameterTool() throws IOException {
        return ParameterTool
                .fromPropertiesFile(ParameterToolUtil.class.getResourceAsStream(NormalConstant.DEFAULT_PROPERTIES))
                .mergeWith(ParameterTool.fromSystemProperties());
    }


}

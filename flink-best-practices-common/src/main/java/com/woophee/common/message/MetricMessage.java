package com.woophee.common.message;

import java.util.Map;

/**
 * Metric message with fields and tags
 * @author woophee
 */
public class MetricMessage {
    /**
     * Metric name
     */
    private String name;

    /**
     * Metric timestamp, unit:ms
     */
    private Long timestamp;

    /**
     * Metric fields
     */
    private Map<String, Object> fieldMap;

    /**
     * Metric tags
     */
    private Map<String, String> tagMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, Object> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(Map<String, Object> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public Map<String, String> getTagMap() {
        return tagMap;
    }

    public void setTagMap(Map<String, String> tagMap) {
        this.tagMap = tagMap;
    }
}

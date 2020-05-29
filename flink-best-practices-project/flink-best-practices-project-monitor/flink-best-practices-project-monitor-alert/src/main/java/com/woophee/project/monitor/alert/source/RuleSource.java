package com.woophee.project.monitor.alert.source;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.woophee.common.model.AlertRule;
import com.woophee.project.monitor.alert.model.AlertExpression;
import org.apache.commons.collections.CollectionUtils;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RuleSource extends RichSourceFunction<List<AlertExpression>> {

    private volatile boolean runningFlag = true;

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
    }

    @Override
    public void run(SourceContext<List<AlertExpression>> sourceContext) throws Exception {
        while (runningFlag) {
            List<AlertRule> alertRuleList = getAllalertRules();
            if (!CollectionUtils.isEmpty(alertRuleList)) {
                List<AlertExpression> alertExpressionList = alertRuleList.stream().map(alertRule -> {
                    Expression expression = AviatorEvaluator.compile(alertRule.getExpression());
                    AlertExpression alertExpression = new AlertExpression();
                    alertExpression.setExpression(expression);
                    return alertExpression;
                }).collect(Collectors.toList());
                sourceContext.collect(alertExpressionList);
                Thread.sleep(60 * 1000);
            }
        }
    }

    @Override
    public void cancel() {
        runningFlag = false;
    }

    private List<AlertRule> getAllalertRules() {
        //get all alert rules from config center
        return new ArrayList<>();
    }
}

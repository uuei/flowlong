/* 
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package com.flowlong.bpm.engine.entity;

import com.flowlong.bpm.engine.core.FlowLongContext;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

/**
 * 流程实例实体类
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
@Getter
@Setter
@ToString
public class FlwInstance extends FlowEntity {
    /**
     * 流程定义ID
     */
    protected Long processId;
    /**
     * 流程实例优先级
     */
    protected Integer priority;
    /**
     * 流程实例编号
     */
    protected String instanceNo;
    /**
     * 业务KEY（用于关联业务逻辑实现预留）
     */
    protected String businessKey;
    /**
     * 变量json
     */
    protected String variable;
    /**
     * 流程实例版本
     */
    protected Integer instanceVersion;
    /**
     * 流程实例期望完成时间
     */
    protected Date expireTime;
    /**
     * 流程实例上一次更新人员ID
     */
    protected String lastUpdateBy;
    /**
     * 流程实例上一次更新时间
     */
    protected Date lastUpdateTime;

    @SuppressWarnings("unchecked")
    public Map<String, Object> getVariableMap() {
        Map<String, Object> map = FlowLongContext.fromJson(this.variable, Map.class);
        if (map == null) return Collections.emptyMap();
        return map;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public void setVariable(Map<String, Object> args) {
        this.variable = FlowLongContext.toJson(args);
    }
}

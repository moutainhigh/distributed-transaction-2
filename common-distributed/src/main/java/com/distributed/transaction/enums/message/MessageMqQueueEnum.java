package com.distributed.transaction.enums.message;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.Map;

/**
 * @author ssk www.8win.com Inc.All rights reserved
 * @version v1.0
 * @date 2018-07-05-下午 2:02
 */
public enum MessageMqQueueEnum {
    /**
     * xml
     */
    RECHARGE_QUEUE("RECHARGE_QUEUE","充值"),
    /**
     * json
     */
    WITHDRAW_QUEUE("WITHDRAW_QUEUE","提现"),
    /**
     * 转账
     */
    TRANSFER_QUEUE("TRANSFER_QUEUE", "转账"),
    ;

    private String name;

    private String desc;

    public String getName() {

        return this.name;
    }

    public String getDesc() {

        return this.desc;
    }

    MessageMqQueueEnum(String name, String desc) {

        this.name = name;

        this.desc = desc;

    }

    private static final Object _LOCK = new Object();
    private static Map<String, MessageMqQueueEnum> _NAME_MAP;
    static {

        synchronized (_LOCK) {
            Map<String, MessageMqQueueEnum> nameMap = Maps.newHashMap();

            for (MessageMqQueueEnum type : MessageMqQueueEnum.values()) {

                if (StringUtils.isNotBlank(type.getName())) {

                    nameMap.put(type.getName(), type);

                }

            }

            _NAME_MAP = Collections.unmodifiableMap(nameMap);
        }
    }

    public static MessageMqQueueEnum getByName(String name){
        try {
            return _NAME_MAP.get(name);
        } catch (Exception e) {
            return null;
        }
    }
}

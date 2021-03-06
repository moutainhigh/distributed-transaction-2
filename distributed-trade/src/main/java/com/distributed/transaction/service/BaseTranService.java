package com.distributed.transaction.service;

import com.distributed.transaction.enums.trade.TradeRequestTypeEnum;
import com.distributed.transaction.exception.DistributedException;
import com.distributed.transaction.trade.api.TradeReq;
import com.distributed.transaction.trade.api.TradeRes;
import lombok.extern.log4j.Log4j2;

/**
 * @author ssk www.8win.com Inc.All rights reserved
 * @version v1.0
 * @date 2018-07-04-下午 2:05
 */
@Log4j2
public abstract class BaseTranService implements IBaseService {

    @Override
    public TradeRes process(TradeRequestTypeEnum requestTypeEnum, TradeReq tradeReq) {

        TradeRes res = new TradeRes();
        try {

            res = exec(requestTypeEnum, tradeReq);

        } catch (Exception e) {
            log.error("交易业务处理异常,[{}]", e.getMessage());
        }
        return res;
    }

    protected abstract TradeRes exec(TradeRequestTypeEnum requestTypeEnum, TradeReq tradeReq);

    protected abstract TradeRes check(TradeReq tradeReq) throws DistributedException;

    protected abstract TradeRes handleException(TradeReq tradeReq, Exception e);

    /**
     * 获取具体的支付服务类
     * @param requestTypeEnum
     * @param payTypeCode
     * @return
     */
    protected abstract ITranService buildTranService(TradeRequestTypeEnum requestTypeEnum, String payTypeCode);
}

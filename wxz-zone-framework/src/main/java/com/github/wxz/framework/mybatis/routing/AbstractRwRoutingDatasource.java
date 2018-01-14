package com.github.wxz.framework.mybatis.routing;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author: wangxianzhi
 * @date: 2018/1/14
 * @time: 17:11
 * @email: xianzhi@eastmoney.com
 */
public abstract  class AbstractRwRoutingDatasource extends AbstractRoutingDataSource {

    protected abstract int getReadDsSize();

    /**
     *
     * @return
     */
    protected abstract Object loadBalance();

}

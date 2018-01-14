package com.github.wxz.framework.mybatis.routing;

import com.github.wxz.framework.mybatis.DataSourceContextHolder;
import com.github.wxz.framework.mybatis.DataSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: wangxianzhi
 * @date: 2018/1/14
 * @time: 17:12
 * @email: xianzhi@eastmoney.com
 */
public class RoundRobinRoutingDataSource extends AbstractRwRoutingDatasource {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoundRobinRoutingDataSource.class);

    private AtomicInteger count = new AtomicInteger(0);

    private int readDsSize;

    public RoundRobinRoutingDataSource(int size) {
        this.readDsSize = size;
    }

    @Override
    protected int getReadDsSize() {
        return this.readDsSize;
    }

    @Override
    protected Object loadBalance() {
        //读库， 简单负载均衡
        int lookupKey = Math.abs(count.incrementAndGet()) % getReadDsSize();
        return lookupKey;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DataSourceContextHolder.getReadOrWrite();

        if (typeKey == null) {
            throw new NullPointerException("数据库路由时，决定使用哪个数据库源类型不能为空...");
        }

        if (typeKey.equals(DataSourceType.WRITE.getType())) {
            return DataSourceType.WRITE.getType();
        } else {
            return loadBalance();
        }
    }
}

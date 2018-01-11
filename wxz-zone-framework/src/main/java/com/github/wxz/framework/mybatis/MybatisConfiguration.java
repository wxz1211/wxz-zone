package com.github.wxz.framework.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.wxz.framework.spring.SpringContextUtil;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

import static com.github.wxz.framework.mybatis.MybatisConfiguration.PACKAGES_SCAN;

/**
 * @author xianzhi.wang
 * @date 2018/1/11 -11:00
 */
@Configuration
@AutoConfigureAfter(DataSourceConfiguration.class)
@MapperScan(basePackages = PACKAGES_SCAN)
public class MybatisConfiguration {
    protected static final String PACKAGES_SCAN = "com.github.wxz.dao";
    private static Logger LOGGER = LoggerFactory.getLogger(MybatisConfiguration.class);

    @Value("${mysql.datasource.readSize}")
    private String readDataSourceSize;

    //XxxMapper.xml文件所在路径
    @Value("${mysql.datasource.mapperLocations}")
    private String mapperLocations;

    //  加载全局的配置文件
    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;

    //  加载全局的配置文件
    @Value("${mysql.datasource.configLocation}")
    private String configLocation;

    @Autowired
    private DataSource writeDataSource;
    @Autowired
    private DataSource readDataSource01;
    @Autowired
    private DataSource readDataSource02;


    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        LOGGER.info("--------------------  sqlSessionFactory init ---------------------");
        try {
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(roundRobinDataSourceProxy());

            // 读取配置 
            sessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);

            //设置mapper.xml文件所在位置 
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources(mapperLocations);
            sessionFactoryBean.setMapperLocations(resources);
            //设置mybatis-config.xml配置文件位置
            sessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(configLocation));

            //添加分页插件、打印sql插件
            Interceptor[] plugins = new Interceptor[]{
                    pageHelper()
                    //, new SqlPrintInterceptor()
            };
            sessionFactoryBean.setPlugins(plugins);

            return sessionFactoryBean.getObject();
        } catch (IOException e) {
            LOGGER.error("mybatis resolver mapper*xml is error", e);
            return null;
        } catch (Exception e) {
            LOGGER.error("mybatis sqlSessionFactoryBean create error", e);
            return null;
        }
    }

    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("returnPageInfo", "check");
        p.setProperty("params", "count=countSql");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    /**
     * 把所有数据库都放在路由中
     *
     * @return
     */
    @Bean(name = "roundRobinDataSourceProxy")
    public AbstractRoutingDataSource roundRobinDataSourceProxy() {

        Map<Object, Object> targetDataSources = new HashMap<>(3);
        //把所有数据库都放在targetDataSources中,注意key值要和determineCurrentLookupKey()中代码写的一至，
        //否则切换数据源时找不到正确的数据源
        targetDataSources.put(DataSourceType.WRITE.getType(), writeDataSource);
        targetDataSources.put(DataSourceType.READ.getType() + "1", readDataSource01);
        targetDataSources.put(DataSourceType.READ.getType() + "2", readDataSource02);

        final int readSize = Integer.parseInt(readDataSourceSize);

        //路由类，寻找对应的数据源
        AbstractRoutingDataSource proxy = new AbstractRoutingDataSource() {
            private AtomicInteger count = new AtomicInteger(0);

            /**
             * 这是AbstractRoutingDataSource类中的一个抽象方法，
             * 而它的返回值是你所要用的数据源dataSource的key值，有了这个key值，
             * targetDataSources就从中取出对应的DataSource，如果找不到，就用配置默认的数据源。
             */
            @Override
            protected Object determineCurrentLookupKey() {
                String typeKey = DataSourceContextHolder.getReadOrWrite();

                if (typeKey == null) {
                    throw new NullPointerException("数据库路由时，决定使用哪个数据库源类型不能为空...");
                }

                if (typeKey.equals(DataSourceType.WRITE.getType())) {
                    return DataSourceType.WRITE.getType();
                }

                //读库， 简单负载均衡
                int number = count.getAndAdd(1);
                int lookupKey = number % readSize;
                return DataSourceType.READ.getType() + (lookupKey + 1);
            }
        };
        //默认库
        proxy.setDefaultTargetDataSource(readDataSource01);
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    //事务管理
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager((DataSource) SpringContextUtil.getBean("roundRobinDataSourceProxy"));
    }

}

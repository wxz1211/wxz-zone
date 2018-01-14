package com.github.wxz.framework.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author xianzhi.wang
 * @date 2018/1/11 -11:00
 */
@Configuration
public class DataSourceConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfiguration.class);
	
	@Value("${mysql.datasource.type}")
	private Class<? extends DataSource> dataSourceType;

    @Autowired
    private DatasourceProperties readDataSourceProperties;
	/**
	 * 写库 数据源配置
	 * @return
	 */
	@Bean(name = "writeDataSource")
    @Primary
    public DruidDataSource writeDataSource() {
        LOGGER.info("-------------------- writeDataSource init ---------------------");
        DruidDataSource item = readDataSourceProperties.getWrite();
        return item;    }
	
	/**
     * 有多少个从库就要配置多少个
     * @return
     */
    @Bean(name = "readDataSources")
    public List<DruidDataSource> readDataSourceOne() {
        LOGGER.info("-------------------- read01 DataSourceOne init ---------------------");
        List<DruidDataSource> readDataSources = readDataSourceProperties.getRead();
        return readDataSources;
    }


    
    
}

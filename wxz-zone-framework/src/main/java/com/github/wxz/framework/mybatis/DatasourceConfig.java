package com.github.wxz.framework.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author xianzhi.wang
 * @date 2018/1/10 -17:23
 */
@Configuration
public class DatasourceConfig {
    @Value("${master.datasource.url}")
    private String url;

    @Value("${master.datasource.username}")
    private String username;

    @Value("${master.datasource.password}")
    private String password;

    @Value("${master.datasource.driverClassName}")
    private String driverClassName;

    private int initialSize = 3;

    @Value("${spring.datasource.max-active}")
    private String maxActive;
    @Value("${spring.datasource.max-wait}")
    private String maxWait;
    @Value("${spring.datasource.min-idle}")
    private String minIdle;

    @Bean(name = "masterDataSource", destroyMethod = "close", initMethod = "init")
    @Primary
    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(Integer.parseInt(maxActive));
        dataSource.setMaxWait(Long.valueOf(maxWait));
        dataSource.setMinIdle(Integer.parseInt(minIdle));
        dataSource.setValidationQuery("select 1 from DUAL");
        return dataSource;
    }
}

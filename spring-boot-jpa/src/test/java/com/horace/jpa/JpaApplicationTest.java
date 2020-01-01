package com.horace.jpa;

import com.alibaba.druid.pool.DruidDataSource;
import com.horace.jpa.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2020-01-01 18:51
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JpaApplicationTest {

    /**
     * Spring Boot 默认已经配置好了数据源，程序员可以直接 DI 注入然后使用即可
     */
    @Resource
    DataSource dataSource;

    @Test
    public void contextLoads() throws SQLException {

        System.out.println("数据源>>>>>>" + dataSource.getClass());
        Connection connection = dataSource.getConnection();

        System.out.println("连接>>>>>>>>>" + connection);
        System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());
        assertThat(druidDataSource.getMaxActive()).isEqualTo(20);
        assertThat(druidDataSource.getInitialSize()).isEqualTo(5);

        connection.close();
    }
}

package com.wowokuaiyun.shipperapiservermicrosrv.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * order库数据源配置
 *
 * @author DingJie on 2018/11/17
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryOrder",
        transactionManagerRef = "transactionManagerOrder",
        basePackages = {"com.wowokuaiyun.shipperapiservermicrosrv.dao.order"})
public class OrderConfig {
    @Resource
    @Qualifier("orderDataSource")
    private DataSource orderDataSource;

    @Bean(name = "entityManagerOrder")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryOrder(builder).getObject().createEntityManager();
    }

    @Resource
    private JpaProperties jpaProperties;

    /**
     * 设置实体类所在位置
     */
    @Bean(name = "entityManagerFactoryOrder")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryOrder(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(orderDataSource)
                .packages("com.wowokuaiyun.shipperapiservermicrosrv.entity.order")
                .persistenceUnit("orderPersistenceUnit")
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Bean(name = "transactionManagerOrder")
    public PlatformTransactionManager transactionManagerOrder(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryOrder(builder).getObject());
    }

}

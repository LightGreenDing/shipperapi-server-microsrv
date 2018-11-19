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
 * member库数据源配置
 * @author DingJie on 2018/11/17
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryMember",
        transactionManagerRef = "transactionManagerMember",
        basePackages = {"com.wowokuaiyun.shipperapiservermicrosrv.dao.member"})
public class MemberConfig {
    @Resource
    @Qualifier("memberDataSource")
    private DataSource memberDataSource;

    @Primary
    @Bean(name = "entityManagerMember")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryMember(builder).getObject().createEntityManager();
    }

    @Resource
    private JpaProperties jpaProperties;

    /**
     * 设置实体类所在位置
     */
    @Primary
    @Bean(name = "entityManagerFactoryMember")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMember(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(memberDataSource)
                .packages("com.wowokuaiyun.shipperapiservermicrosrv.entity.member")
                .persistenceUnit("memberPersistenceUnit")
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerMember")
    public PlatformTransactionManager transactionManagerMember(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryMember(builder).getObject());
    }

}

package ru.megazlo.springtest.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.megazlo.springtest.utils.GlobalUtil;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author paradoxfm - 02.09.2015
 */
@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
@EnableJpaRepositories("ru.megazlo.springtest.repositories")
public class SpringDataJpa {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /*@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
        dataSource.setUrl("jdbc:jtds:sqlserver://localhost:1433/mvcdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("qwepoi123098");
        return dataSource;
    }*/

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                        //.addScript("classpath:schema.sql").addScript("classpath:test-data.sql")
                .build();
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan("ru.megazlo.springtest.dto.db");
        entityManagerFactoryBean.setJpaProperties(getProperties());
        return entityManagerFactoryBean;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        //properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hbm2ddl.auto", "create-drop");
        //properties.put("hibernate.cache.use_second_level_cache", "true");
        //properties.put("hibernate.cache.use_query_cache", "true");
        //properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");//для распределенных EhCacheProvider
        if (GlobalUtil.isDebug()) {
            log.debug("in debug mode enetered");
            properties.put("hibernate.show_sql", "true");
            //properties.put("hibernate.generate_statistics", "true");
        }
        //properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}

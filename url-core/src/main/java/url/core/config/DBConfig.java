package url.core.config;

import com.jolbox.bonecp.BoneCPDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by N0stress on 20/02/2017.
 */
@Configuration
@EnableJpaRepositories(basePackages = "url.core.dao")
public class DBConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Bean(destroyMethod = "close")
    public DataSource dataSource(Properties dbProperties) {
        LOGGER.info("DBConfig dataSource(dbProperties) : Bean");

        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(dbProperties.getProperty("driverClass"));
        dataSource.setJdbcUrl(dbProperties.getProperty("jdbcUrl"));
        dataSource.setUsername(dbProperties.getProperty("username"));
        dataSource.setPassword(dbProperties.getProperty("password"));
        dataSource.setIdleConnectionTestPeriodInMinutes(60);
        dataSource.setIdleMaxAgeInMinutes(240);
        dataSource.setMaxConnectionsPerPartition(10);
        dataSource.setMinConnectionsPerPartition(1);
        dataSource.setPartitionCount(2);
        dataSource.setAcquireIncrement(5);
        dataSource.setStatementsCacheSize(500);

        return dataSource;
    }


    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        LOGGER.info("DBConfig entityManager(entityManagerFactory) : Bean");

        return entityManagerFactory.createEntityManager();
    }


    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory, DataSource dataSource) {
        LOGGER.info("DBConfig transactionManager(entityManagerFactory, dataSource) : Bean");

        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        transactionManager.setDataSource(dataSource);

        return transactionManager;
    }


    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) throws SQLException {
        LOGGER.info("DBConfig entityManagerFactory(dataSource) : Bean");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        factory.setPackagesToScan("url.core.entity");
        factory.setDataSource(dataSource);
        factory.afterPropertiesSet();

        return factory.getObject();
    }
}

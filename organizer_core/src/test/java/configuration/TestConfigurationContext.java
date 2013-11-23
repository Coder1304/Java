package configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.util.Log4jConfigurer;

@Configuration
@EnableJpaRepositories("hibernate.repositories")
public class TestConfigurationContext {

	@Bean
	DriverManagerDataSource datasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource(
				"jdbc:mysql://localhost:3306/organizer", 
				"organizer",
				"organizer");
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		return datasource;
	}
	
	@SuppressWarnings("serial")
	@Bean
	public Properties additionalProperties() {
		return new Properties() {
			{
				setProperty("hibernate.hbm2ddl.auto", "create");
				setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");
				setProperty("hibernate.show_sql", "true");
			}
		};
	}
	
	@Bean
	HibernateExceptionTranslator hibernateExceptionTranslator(){
		return new HibernateExceptionTranslator();
	}

	@Bean
	EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(datasource());
		
		entityManagerFactory.setPackagesToScan(new String[] { "hibernate.entities" });
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactory.setPersistenceProvider(new HibernatePersistence());
	      
		entityManagerFactory.setJpaProperties(additionalProperties());
		entityManagerFactory.afterPropertiesSet();
		
        return entityManagerFactory.getObject();
	}

	@Bean
	JpaTransactionManager transactionManager(){
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory());
		jpaTransactionManager.setDataSource(datasource());
		return jpaTransactionManager;
	}
	
	@Bean
	MethodInvokingFactoryBean log4jInitialization(){
		MethodInvokingFactoryBean log4jInitialization = new MethodInvokingFactoryBean();
		log4jInitialization.setTargetClass(Log4jConfigurer.class);
		log4jInitialization.setTargetMethod("initLogging");
		log4jInitialization.setArguments(new String[]{"classpath:META-INF/log4j.xml"});
		
		return log4jInitialization;
	}
}

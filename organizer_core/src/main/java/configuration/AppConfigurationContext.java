package configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.util.Log4jConfigurer;

@Configuration
@EnableJpaRepositories("hibernate.repositories")
public class AppConfigurationContext {

	@Bean
	DriverManagerDataSource datasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource(
				"jdbc:mysql://localhost:3306/organizer", 
				"organizer",
				"organizer");
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		return datasource;
	}
	
	
	/*@Bean
	EntityManagerFactory entityManagerFactory() {
		HibernatePersistence hibernatePersistence = new HibernatePersistence();
		
		
		return hibernatePersistence.createEntityManagerFactory("tothought-tutorial", hashMap);
	}*/
	
	@Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "create");
        return properties;
    }
	
	@Bean
	HibernateExceptionTranslator hibernateExceptionTranslator(){
		return new HibernateExceptionTranslator();
	}

	@Bean
	EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(datasource());
		//entityManagerFactory.setPersistenceXmlLocation("");
		entityManagerFactory.setPersistenceUnitName("tothought-tutorial");
		
		/*entityManagerFactory.setJpaVendorAdapter(vendorAdapter()); 
		entityManagerFactory.setJpaDialect(jpaDialect());

		entityManagerFactory.setPersistenceUnitManager(persistenceUnitManager());
		entityManagerFactory.setJpaProperties(hibernateProperties());
		
		entityManagerFactory.setPackagesToScan(new String[] { "hibernate.repositories" });*/
		
//		entityManagerFactory.setPersistenceProvider(new HibernatePersistence());
		entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
	}

	@Bean
	HibernateJpaVendorAdapter vendorAdapter() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setGenerateDdl(true);
		return vendorAdapter;
	}
	
	@Bean
	public JpaDialect jpaDialect() {
		return new HibernateJpaDialect();
	}
	
	@Bean
	public PersistenceUnitManager persistenceUnitManager() {
		DefaultPersistenceUnitManager dpum = new DefaultPersistenceUnitManager();
		dpum.setDefaultDataSource(datasource());
		return dpum;
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

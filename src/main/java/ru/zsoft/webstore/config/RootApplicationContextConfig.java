package ru.zsoft.webstore.config;

import java.net.URI;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("ru.zsoft.webstore.domain")
//@EnableTransactionManagement
public class RootApplicationContextConfig {
	
	@Autowired
	Environment environment;
	
	//@Bean(name = "dataSourceHSQL")	
	public DataSource dataSourceHSQL() {
		EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase embeddedDatabase = embeddedDatabaseBuilder.
				setType(EmbeddedDatabaseType.HSQL).
				addScript("db/sql/create-table.sql").
				addScript("db/sql/insert-data.sql").
				build();
		return embeddedDatabase;
	}
	
	//@Bean(name = "dataSourcePG")
	public DataSource dataSourcePG() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
		dataSource.setUrl(environment.getRequiredProperty("db.url"));
		dataSource.setUsername(environment.getRequiredProperty("db.username"));
		dataSource.setPassword(environment.getRequiredProperty("db.password"));
		dataSource.setInitialSize(Integer.parseInt(environment.getRequiredProperty("db.pool.initSize")));
		dataSource.setMaxTotal(Integer.parseInt(environment.getRequiredProperty("db.pool.maxSize")));
		return dataSource;
	}
	
	@Bean(name = "dataSourceHeroku")
	public DataSource dataSourceHeroku() {
		try {
		    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

	        BasicDataSource basicDataSource = new BasicDataSource();
	        basicDataSource.setUrl(dbUrl);
	        basicDataSource.setUsername(username);
	        basicDataSource.setPassword(password);

	        return basicDataSource;
		} catch (Exception e) {
			throw new BeanCreationException("dataSourceHeroku", "Failed to create a dataSourceHeroku", e);
		}
	}
	
	@Bean
	public NamedParameterJdbcTemplate geJdbcTemplate(@Qualifier("dataSourceHeroku") DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(@Qualifier("dataSourceHeroku") DataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}

}

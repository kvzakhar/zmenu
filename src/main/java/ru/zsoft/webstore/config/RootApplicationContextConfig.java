package ru.zsoft.webstore.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("ru.zsoft.webstore.domain")
//@EnableTransactionManagement
public class RootApplicationContextConfig {
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase embeddedDatabase = embeddedDatabaseBuilder.
				setType(EmbeddedDatabaseType.HSQL).
				addScript("db/sql/create-table.sql").
				addScript("db/sql/insert-data.sql").
				build();
		return embeddedDatabase;
	}
	
	@Bean
	public NamedParameterJdbcTemplate geJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

}

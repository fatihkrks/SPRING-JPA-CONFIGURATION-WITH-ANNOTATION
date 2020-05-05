package Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;

@Configuration
@PropertySource("classpath:jdbc/jdbc.properties")
@ComponentScan("Configuration,model,repository")
public class BeanConfiguration {
	
			@Value("${jdbc.driverClassName}")
			private String driverClassName;
			@Value("${jdbc.url}")
			private String jdbcUrl;
			@Value("${jdbc.username}")
			private String username;
			@Value("${jdbc.password}")
			private String password;
			
			
			@Bean
			public DataSource dataSource() {
				DriverManagerDataSource dataSource=new DriverManagerDataSource();
				dataSource.setDriverClassName(driverClassName);
				dataSource.setUrl(jdbcUrl);
				dataSource.setUsername(username);
			dataSource.setPassword(password);
				return dataSource;
			}
			@Bean
			public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
				LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
				factory.setDataSource(dataSource());
				factory.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
				factory.setPackagesToScan("model");
				Properties jpaProperties=new Properties();
				jpaProperties.put("jpaProperties", "drop-and-create-tables");
				jpaProperties.put("eclipselink.logging.level", "FINE");
				
				factory.setJpaProperties(jpaProperties);
				
				Map jpaPropertMap=new HashMap();
				jpaPropertMap.put("eclipselink.weaving", "false");
				factory.setJpaPropertyMap(jpaPropertMap);
				return factory;
			}
			
			
			
}

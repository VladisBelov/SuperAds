package superads.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class AppConfiguration {

    @Bean
    public javax.sql.DataSource getDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class);
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/SuperAds");
        return dataSource;
    }
}

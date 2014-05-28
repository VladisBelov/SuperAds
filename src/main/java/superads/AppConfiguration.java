package superads;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class AppConfiguration {

    @Bean
    public javax.sql.DataSource getDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.postgresql.Driver.class);
        dataSource.setUsername("xfbcxugllvlhye");
        dataSource.setPassword("rLiOxqycuomyZ2UqpAgUNnA9ah");
        dataSource.setUrl("jdbc:postgresql://ec2-54-246-101-204.eu-west-1.compute.amazonaws.com:5432/dauef83l2ki985");
        return dataSource;
    }
}

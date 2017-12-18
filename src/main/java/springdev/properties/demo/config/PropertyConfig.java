package springdev.properties.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import springdev.properties.demo.examplebean.FakeDataSource;

/**
 * Created by oleht on 18.12.2017
 */
@Configuration
@PropertySource("classpath:dataSource.properties")
public class PropertyConfig {
    @Value("${username}")
    String username;
    @Value("${password}")
    String password;
    @Value("${db.url}")
    String url;

    @Bean
    public FakeDataSource getFakeDataSource() {
        FakeDataSource dataSource = new FakeDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);

        return dataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        return configurer;
    }

}
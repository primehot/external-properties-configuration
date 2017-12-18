package springdev.properties.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import springdev.properties.demo.examplebean.FakeDataSource;
import springdev.properties.demo.examplebean.FakeJMSBroker;

/**
 * Created by oleht on 18.12.2017
 */
@Configuration
//@PropertySource({"classpath:dataSource.properties", "classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:dataSource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    @Autowired
    private Environment environment;

    @Value("${username}")
    String username;
    @Value("${password}")
    String password;
    @Value("${db.url}")
    String url;

    @Value("${jms.username}")
    String jmsUsername;
    @Value("${jms.password}")
    String jmsPassword;
    @Value("${jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource getFakeDataSource() {
        FakeDataSource dataSource = new FakeDataSource();
        dataSource.setUsername(environment.getProperty("username_override"));
        dataSource.setPassword(password);
        dataSource.setUrl(url);

        return dataSource;
    }

    @Bean
    public FakeJMSBroker getFakeJMSBroker() {
        FakeJMSBroker broker = new FakeJMSBroker();
        broker.setUsername(jmsUsername);
        broker.setPassword(jmsPassword);
        broker.setUrl(jmsUrl);

        return broker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        return configurer;
    }

}

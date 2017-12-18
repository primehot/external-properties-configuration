package springdev.properties.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import springdev.properties.demo.examplebean.FakeDataSource;
import springdev.properties.demo.examplebean.FakeJMSBroker;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		FakeDataSource dataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(dataSource.toString());

		FakeJMSBroker broker = ctx.getBean(FakeJMSBroker.class);
		System.out.println(broker.toString());
	}
}

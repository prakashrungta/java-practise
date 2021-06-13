package com.avaya.kafka.springbootkafkaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @Configuration, @EnableAutoConfiguration, and
                       // @ComponentScan
public class SpringBootKafkaExampleApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootKafkaExampleApplication.class, args);
	}
}

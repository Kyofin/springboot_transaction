package com.wugui.learn_transaction;

import com.wugui.learn_transaction.domain.User;
import com.wugui.learn_transaction.service.ServiceA;
import com.wugui.learn_transaction.service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearnTransactionApplication {
	@Autowired
	ServiceA serviceA;

	@Autowired
	ServiceB serviceB;


	public static void main(String[] args) {
		SpringApplication.run(LearnTransactionApplication.class, args);

	}


}

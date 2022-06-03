package com.maikel.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.maikel.os.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {


	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	
	@Bean
	public boolean instaniaDB() {
		
		if(ddl.equals("create")) {
			this.dbService.instaciaDB();
		}
		return false;
		

	}

}

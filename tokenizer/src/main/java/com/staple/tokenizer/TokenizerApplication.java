package com.staple.tokenizer;

import com.staple.tokenizer.dbservices.CardService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TokenizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenizerApplication.class, args);
	}

}

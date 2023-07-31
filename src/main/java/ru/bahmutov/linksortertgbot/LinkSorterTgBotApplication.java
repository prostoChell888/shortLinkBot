package ru.bahmutov.linksortertgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class LinkSorterTgBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkSorterTgBotApplication.class, args);
	}
}

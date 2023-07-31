package ru.bahmutov.linksortertgbot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@Data
@ConfigurationProperties("application.yml")
public class BotConfig {
    @Value("${bot.name}")
    String botName;

    @Value("${bot.key}")
    String token;
}

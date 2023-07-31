package ru.bahmutov.linksortertgbot;


import dto.UrlMappingDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.bahmutov.linksortertgbot.client.LinkShorterClient;
import ru.bahmutov.linksortertgbot.config.BotConfig;

@Component
@RequiredArgsConstructor
public class TgBot extends TelegramLongPollingBot {

    private final BotConfig config;

    private final LinkShorterClient client;


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String msgText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            switch (msgText) {
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;
                case "/e":
                    SendMessage sendMessage = new SendMessage().setChatId(chatId).;
                    var res = client.redirectToPageToOriginalUrl(new UrlMappingDTO("https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-feign/1.3.5.RELEASE"));
                    sendMsg(chatId, res);
                    break;
                default:
                    sendMsg(chatId, "команда \"" + msgText + "\" не найдена");
            }
        }
    }

    private void startCommandReceived(Long chatId, String name) {
        String answer = "Hi " + name + ", nice to meet you!";
        sendMsg(chatId, answer);
    }

    private void sendMsg(Long chatId, String answer) {
        var msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText(answer);
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            System.out.println(e);
            throw new RuntimeException("Ошибка при отправке сообещиня");
        }
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }
}

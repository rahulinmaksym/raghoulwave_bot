package org.raghoul.raghoulwavebot.telegrambotapi;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.raghoul.raghoulwavebot.service.telegrambot.TelegramBotService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Slf4j
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class RaghoulwaveTelegramBot extends SpringWebhookBot {

    private String botPath;
    private String botUsername;
    private String botToken;
    private final TelegramBotService telegramBotService;

    public RaghoulwaveTelegramBot(
            DefaultBotOptions options,
            SetWebhook setWebhook,
            String botToken,
            TelegramBotService telegramBotService
    ) {
        super(options, setWebhook, botToken);
        this.telegramBotService = telegramBotService;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {

        return telegramBotService.handleUpdate(update);
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }
}

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class Bot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "@TestBolodia_bot";
    }

    @Override
    public String getBotToken() {
        return "1814170119:AAGbMZ8cd0qkCRsNbwCeaSUQEifUF94f_6I";
    }


    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {

            Message message = update.getMessage();

            if (message.hasText()) {
                try {
                    execute(SendMessage.builder()
                            .chatId(message.getChatId()
                                    .toString())
                            .text("sdfsfd")
                            .build());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
        }

    }


    public static void main(String[] args) {
        Bot bot = new Bot();

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

}

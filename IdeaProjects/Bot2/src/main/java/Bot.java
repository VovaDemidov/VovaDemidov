import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Bot {


    public static void main(String[] args) {


        TelegramBot telegramBot = new TelegramBot("1814170119:AAGbMZ8cd0qkCRsNbwCeaSUQEifUF94f_6I");

       /* UpdatesListener updatesListener = new UpdatesListener() {

            @Override
            public int process(List<Update> updates) {
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        };
        telegramBot.setUpdatesListener(updatesListener);
*/

        telegramBot.setUpdatesListener(updates -> {

            System.out.println(updates);
            System.out.println("New updates");
            for (int i = 0; i < updates.size(); i++) {

                List<SaleCard> saleCards = new ArrayList<>();

                if (updates.get(i)
                        .message() != null) {
                    long chatId = updates.get(i)
                            .message()
                            .chat()
                            .id();
                    SendResponse response = telegramBot.execute(new SendMessage(chatId, "Hello! Your message: " + updates.get(i)
                            .message()
                            .text()));
                    SendResponse response1 = telegramBot.execute(new SendMessage(chatId, "keyboard").replyMarkup(MyKeyboard.sendKeyboard()));


                    SendResponse response2 = telegramBot.execute(new SendMessage(chatId, "Where is my fucking keyboard!!!!?"));
                }

                if (updates.get(i)
                        .callbackQuery() != null) {

                    CallbackQuery callbackQuery = new CallbackQuery();
                    callbackQuery = updates.get(i)
                            .callbackQuery();
                    long chatId = callbackQuery.message()
                            .chat()
                            .id();

                    System.out.println(callbackQuery.data());


                    String key = callbackQuery.data();


                    System.setProperty("webdriver.chrome.driver", "D:/CromeDriver/chromedriver.exe");

                    ChromeDriver chromeDriver = new ChromeDriver();


                    try {


                        chromeDriver.get("https://5ka.ru/special_offers/");

                        String siteTitle = chromeDriver.getTitle();

                        System.out.println(siteTitle);


                        WebElement maximizeButton = chromeDriver.findElement(By.cssSelector(".search_maximize_btn"));
                        maximizeButton.click();
                        WebElement input = chromeDriver.findElement(By.cssSelector(".search_input"));
                        input.click();
                        input.sendKeys(key);
                        WebElement pressButton = chromeDriver.findElement(By.cssSelector(".search_btn"));
                        pressButton.click();

                        List<WebElement> saleCardTitles = new ArrayList<>();
                        List<WebElement> saleCardPrice = new ArrayList<>();

                        if (key.equals(Drinks.COCA_COLA.name)) {

                            chromeDriver = SearchItems.searchKey(chromeDriver, Drinks.COCA_COLA.findKey);

                            saleCardTitles = SearchItems.searchSelector(chromeDriver, "span.sale-card__title");
                            saleCardPrice = SearchItems.searchSelector(chromeDriver, "span.sale-card__price.sale-card__price--new");

                            System.out.println("COCA_COLA");
                        }
                        if (key.equals(Drinks.PEPSI.name)) {

                            chromeDriver = SearchItems.searchKey(chromeDriver, Drinks.PEPSI.findKey);

                            saleCardTitles = SearchItems.searchSelector(chromeDriver, "span.sale-card__title");
                            saleCardPrice = SearchItems.searchSelector(chromeDriver, "span.sale-card__price.sale-card__price--new");

                            System.out.println("PEPSI");
                        }


                        System.out.println(saleCardTitles.size());
                        System.out.println(saleCardPrice.size());


                        System.out.println(saleCardTitles.get(0)
                                .toString());


                        for (i = 0; i < saleCardTitles
                                .size(); i++) {


                            saleCards.add(new SaleCard());
                            saleCards.get(i)
                                    .setTitle(saleCardTitles.get(i)
                                            .getAttribute("textContent"));
                        }


                        System.out.println(saleCardPrice.size());

                        for (i = 0; i < saleCardPrice.size(); i = i + 2) {


                            saleCards.get(i / 2)
                                    .setPrice(saleCardPrice.get(i)
                                            .getAttribute("textContent"));


                        }


                    } catch (Exception e) {


                        SendResponse response7 = telegramBot.execute(new SendMessage(chatId, "Alarm!!!!"));
                        SendResponse response8 = telegramBot.execute(new SendMessage(chatId, "Nothing found"));
                        System.out.println(e.fillInStackTrace());


                    } finally {

                        chromeDriver.quit();
                    }


                    for (i = 0; i < saleCards.size(); i++) {

                        SendResponse response6 = telegramBot.execute(new SendMessage(chatId, saleCards.get(i).title + "  " + saleCards.get(i).price));
                    }

                }


                for (i = 0; i < saleCards.size(); i++) {

                    System.out.print(saleCards.get(i).title + "  " + saleCards.get(i).price);

                }


            }

            return UpdatesListener.CONFIRMED_UPDATES_ALL;


        });

    }


}

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;

public abstract class MyKeyboard {

    public static InlineKeyboardMarkup sendKeyboard() {

        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton("Coca Cola");
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton("Pepsi");
        inlineKeyboardButton1.callbackData("Coca Cola");
        inlineKeyboardButton2.callbackData("Pepsi");
        inlineKeyboard.addRow(inlineKeyboardButton1, inlineKeyboardButton2);

        return inlineKeyboard; }



}

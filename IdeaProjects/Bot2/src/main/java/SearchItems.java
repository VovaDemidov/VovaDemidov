import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public interface SearchItems {


    static ChromeDriver searchKey(ChromeDriver chromeDriver, String key) {

       System.out.println("One");

        List<WebElement> elements = chromeDriver.findElements(By.cssSelector(key));

        System.out.println(chromeDriver.getTitle());

        System.out.println(elements.toString());

        System.out.println("two");

        return chromeDriver;
    }


    static List<WebElement> searchSelector(ChromeDriver chromeDriver, String selector) {


        List<WebElement> Cards = chromeDriver.findElements(By.cssSelector(selector));

        return Cards;

    }


}

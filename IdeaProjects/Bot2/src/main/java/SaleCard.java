
public class SaleCard {

    String title;
    String price;

    public SaleCard() {


    }

    public SaleCard(String title, String price) {

        this.title = title;
        this.price = price;

    }


    public void setTitle(String title) {


        this.title = title;

        System.out.println(title);
        System.out.println(this.title);


    }

    public void setPrice(String price) {

        price = price.trim();

        String[] strings = price.split("\\D+");

        price = strings[0].trim();

        System.out.println(price.length());

        String subPrice1 = price.substring(0, price.length() - 2);
        String sunPrice2 = price.substring(price.length() - 2);
        this.price = subPrice1 + "," + sunPrice2;

        System.out.println(price);
        System.out.println(this.price);

    }

    public String getPrice() {

        return this.price;

    }

    public String getTitle() {

        return this.title;

    }






}

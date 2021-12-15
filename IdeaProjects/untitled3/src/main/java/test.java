import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class test {


    public static void main(String[] args) throws ClassNotFoundException {

        String userName = "root";
        String password = "123456";
        String connectionUrl = "jdbc:mysql://localhost:3306/mysql";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            System.out.println("connection done!");
            Statement statement = connection.createStatement();
            statement.execute("set global time_zone = '-3:00'");
            statement.execute("use test_schema");


            BufferedImage image = ImageIO.read(new File("D:/map1.jpg"));
            Blob blob = connection.createBlob();
            try (OutputStream outputStream = blob.setBinaryStream(1)) {
                ImageIO.write(image, "jpg", outputStream);
            }

            int i = 0;


            while (i < 1) {

                PreparedStatement preparedStatement = connection.prepareStatement("insert into users (user_name , img , profession, dt) values (?,?,?,?)");
                preparedStatement.setString(1, "blaBla12");
                preparedStatement.setBlob(2, blob);
                preparedStatement.setString(3, "exit");
                preparedStatement.setDate(4, new Date(1));
                preparedStatement.execute();
                ++i;


            }


            Statement statement1=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet1=statement1.executeQuery("select * from users");

            while (resultSet1.next()) {

                System.out.println(resultSet1.getString("user_name"));
                System.out.println(resultSet1.getString("profession"));
                System.out.println(resultSet1.getString("dt"));
                System.out.println("_________________");
            }


            resultSet1.last();
            resultSet1.updateString("user_name", "Bolodia");
            resultSet1.updateRow();

            
            resultSet1.beforeFirst();

            String userId = "3";


            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id =?");
            preparedStatement.setString(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println(resultSet.getString("user_name"));
                System.out.println(resultSet.getString("profession"));
                System.out.println("_________________");
            }


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


    }
}

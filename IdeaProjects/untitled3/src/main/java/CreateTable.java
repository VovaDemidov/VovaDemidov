import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public void create(Statement statement) {
        try {
            statement.execute("create table users (id int not null auto_increment, user_name varchar(30) not null, img blob, profession varchar(50) not null, dt date, primary key (id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}

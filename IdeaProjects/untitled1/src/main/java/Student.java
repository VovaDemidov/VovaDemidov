import java.util.Date;

public class Student {

   private String name;
   private int age;
   private Date date;

    public Student(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getDate() {
        return (Date) date.clone();
    }
}

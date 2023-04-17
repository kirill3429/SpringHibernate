package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      Car car1 = new Car(1, "S");
      Car car2 = new Car(2, "A");
      Car car3 = new Car(3, "B");
      Car car4 = new Car(4, "C");

      User user1 = new User("Ivan", "Ivanov", "qeqw@mfd.ru");
      User user2 = new User("Alexander", "Ivanov", "qeqw@mfd.ru");
      User user3 = new User("Leonid", "Ivanov", "qeqw@mfd.ru");
      User user4 = new User("Arslan", "Ivanov", "qeqw@mfd.ru");

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      carService.add(car1);
      carService.add(car2);
      carService.add(car3);
      carService.add(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Сar = "+user.getCar());
         System.out.println();
      }

      System.out.println(userService.getUserByCar(4, "C").getFirstName());

      context.close();
   }
}

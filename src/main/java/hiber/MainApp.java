package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1= new User("User1", "Lastname1", "user1@mail.ru");
      User user2= new User("User2", "Lastname2", "user2@mail.ru");
      User user3= new User("User3", "Lastname3", "user3@mail.ru");
      User user4= new User("User4", "Lastname4", "user4@mail.ru");

      user1.setCar(new Car("toyota", 111));
      user2.setCar(new Car("mercedes", 222));
      user3.setCar(new Car("lada", 333));
      user4.setCar(new Car("bmw", 444));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      System.out.println(userService.getUserByCar("toyota", 111));
      System.out.println(userService.getUserByCar("mercedes", 222));
      System.out.println(userService.getUserByCar("lada", 333));
      System.out.println(userService.getUserByCar("bmw", 444));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.print("Id = "+user.getId() + "\t");
         System.out.print("First Name = "+user.getFirstName() + "\t");
         System.out.print("Last Name = "+user.getLastName() + "\t");
         System.out.print("Email = "+user.getEmail() + "\t");
         System.out.print("Car = "+user.getCar() + "\t");
         System.out.println();
      }

      context.close();
   }
}

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


      Car ladaSix = new Car("Lada", 2106);
      Car ladaSeven = new Car("Lada", 2107);
      User user1 = new User("Олег", "Петров", "OlegPetrov233@yandex.ru");
      User user2 = new User("Семен", "Васильев", "SemaTheBigBoss322@rambler.ru");
      user1.setCar(ladaSix);
      user2.setCar(ladaSeven);
      userService.add(user1);
      userService.add(user2);
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car Model = " +user.getCar());
         System.out.println();
      }
      System.out.println(userService.getUser(ladaSix));
      context.close();
   }
}

package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarDao {
   void add(Car user);
   List<Car> listCars();
}

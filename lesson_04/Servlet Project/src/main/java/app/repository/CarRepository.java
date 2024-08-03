package app.repository;

import app.domain.Car;
import java.util.List;

//CRUD

public interface CarRepository {

  Car save(Car car); //creat

  Car getById(Long id); //read

  List<Car> getAll(); //read

  Car updateCar(); //update

  void delete(Long id); //delete

}



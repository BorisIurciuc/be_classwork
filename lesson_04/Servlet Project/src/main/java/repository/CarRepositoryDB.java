package repository;

import static constants.Constants.DB_ADDRESS;
import static constants.Constants.DB_DRIVER_PATH;
import static constants.Constants.DB_NAME;
import static constants.Constants.DB_PASSWORD;
import static constants.Constants.DB_USERNAME;

import domain.Car;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryDB implements CarRepository {

  // connectivity
private Connection getConnection() {

  try {
    Class.forName(DB_DRIVER_PATH);

    //// http://10.1.2.3:8080/carss?id=3
    //// это URI для http-запроса, URI для подключения к БД выглядит аналогично:
    //// jdbc:postgresql://localhost:5432/cars_db?user=postgres&password=qwerty007

    String dbURL = String.format("%s%s?user=%s&password=%s", DB_ADDRESS, DB_NAME, DB_USERNAME, DB_PASSWORD);
    return DriverManager.getConnection(dbURL);

  } catch (Exception e) {
    throw new RuntimeException(e);
  }
}

  @Override
  public Car save(Car car) {
    try (Connection connection = getConnection()) {
      String query = String.format(
          "INSERT INTO cars(brand, price, year) VALUES ('%s', '%s', %d);"
          ,car.getBrand(), car.getPrice(), car.getYear()
      );

      Statement statement = connection.createStatement();
      statement.execute(query, Statement.RETURN_GENERATED_KEYS);
      ResultSet resultSet = statement.getGeneratedKeys();
      resultSet.next();
      //get ID from resultSet
      Long id = resultSet.getLong(1);
      car.setId(id);
      return car;

    } catch (Exception e){
      throw new RuntimeException(e);
    }
  }

  @Override
  public Car getById(Long id) {
    try (Connection connection = getConnection()) {

      String query = String.format("SELECT * FROM car WHERE id = %d;", id);

      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);

      if (resultSet.next()) {
        String brand = resultSet.getString("brand");
        BigDecimal price = resultSet.getBigDecimal("price");
        int year = resultSet.getInt("year");

        return new Car(id, brand, price, year);
      }

      return null;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Car> getAll() {
    List<Car> cars = new ArrayList<>();
    try (Connection connection = getConnection()) {
      String query = "SELECT * FROM cars;";
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        Long id = resultSet.getLong("id");
        String brand = resultSet.getString("brand");
        BigDecimal price = resultSet.getBigDecimal("price");
        int year = resultSet.getInt("year");
        cars.add(new Car(id, brand, price, year));
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return cars;
  }

  @Override
  public Car update(Car car) {
    try (Connection connection = getConnection()) {
      // TODO домашнее задание (изменению подлежит только цена)
      String query = String.format("UPDATE car SET price = %s WHERE id = %d;", car.getPrice(), car.getId());
      connection.createStatement().execute(query);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return car;
  }

  @Override
  public void delete(Long id) {
    String query = "DELETE FROM cars WHERE id = ?";
    try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setLong(1, id);
      statement.executeUpdate();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

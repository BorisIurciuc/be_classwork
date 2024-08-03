package app.controller;

import app.domain.Car;
import app.repository.CarRepositoryDB;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import app.repository.CarRepository;
import app.repository.CarRepositoryMap;

public class CarServlet extends HttpServlet {

  public CarRepository repository = new CarRepositoryDB();

  //public CarRepository repository= new CarRepositoryMap();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    //super.doGet(req, resp);

    String idParam = req.getParameter("id");
    try {
      if (idParam != null) {
        Long id = Long.parseLong(idParam);
        Car car = repository.getById(id);
        if (car != null) {
          resp.getWriter().write(car.toString() + "\n");
        } else {
          resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
          resp.getWriter().write("Car not found");
        }
      } else {
        //Fetch all cars
        List<Car> cars = repository.getAll();
        cars.forEach(x -> {
          try {
            resp.getWriter().write(x.toString() + "\n");
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        });

      }
    } catch (NumberFormatException e) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      resp.getWriter().write("Invalid parameter: id must be a number");
    } catch (Exception e) {
      resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      resp.getWriter().write("An error occurred while fetching the car(s)");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Car car = mapper.readValue(req.getReader(), Car.class);
    repository.save(car);
    resp.getWriter().write(car.toString());
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doPut(req, resp);
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String idParam = req.getParameter("id");

    try {
      Long id = Long.parseLong(idParam);
      repository.delete(id);
      resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
    } catch (NumberFormatException e) {
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      resp.getWriter().write("Invalid parameter: id must be a number");
    } catch (Exception e) {
      resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      resp.getWriter().write("An error occurred while deleting the car");
    }
  }
}
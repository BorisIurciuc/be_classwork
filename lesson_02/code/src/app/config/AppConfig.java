package app.config;

import app.staff.specialists.Secretary;
import app.staff.specialists.production.MachineOperator;
import app.staff.specialists.production.Storekeeper;
import app.staff.specialists.sales.Merchandiser;
import app.staff.specialists.sales.SalesManager;
import java.beans.BeanProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import app.staff.administration.Director;
import app.staff.administration.ProductionChief;
import app.staff.administration.SalesChief;


@Configuration
public class AppConfig {

  @Bean
  public Director director() {
    return new Director();
  }

  @Bean
  public ProductionChief productionChief() {
    return new ProductionChief();
  }

  @Bean
  public SalesChief salesChief() {
    return new SalesChief();
  }

  @Bean
  public Secretary secretary() {
    return new Secretary();
  }

  @Bean
  public MachineOperator machineOperator() {
    return new MachineOperator();
  }

  @Bean
  public Storekeeper storekeeper() {
    return new Storekeeper();
  }

  @Bean
  public Merchandiser merchandiser() {
    return new Merchandiser();
  }

  @Bean
  public SalesManager salesManager() {
    return new SalesManager();
  }
}

package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import app.staff.administration.Director;
/**
import app.staff.administration.ProductionChief;
import app.staff.administration.SalesChief;
import app.staff.specialists.Secretary;
import app.staff.specialists.production.MachineOperator;
import app.staff.specialists.production.Storekeeper;
import app.staff.specialists.sales.Merchandiser;
import app.staff.specialists.sales.SalesManager;
*/
/**
 * 24/07/2024 be_classwork * @author Boris Iurciuc (cohort36)
 */
public class Application {

  public static void main(String[] args) {
        //Код без Spring
   /**
    Secretary secretary = new Secretary(); //Constructor by default

    SalesManager salesManager = new SalesManager();
    Merchandiser merchandiser = new Merchandiser();

    MachineOperator machineOperator = new MachineOperator();
    Storekeeper storekeeper = new Storekeeper();

    ProductionChief productionChief = new ProductionChief();
    productionChief.setMachineOperator(machineOperator);
    productionChief.setStorekeeper(storekeeper);

    SalesChief salesChief = new SalesChief();
    salesChief.setSalesManager(salesManager);
    salesChief.setMerchandiser(merchandiser);

    Director director = new Director();
    director.setSecretary(secretary);
    director.setProductionChief(productionChief);
    director.setSalesChief(salesChief);

    director.manageCompany();
    */

    AbstractApplicationContext context = new AnnotationConfigApplicationContext("app.config");
    Director director = context.getBean(Director.class);
    director.manageCompany();


  }

}

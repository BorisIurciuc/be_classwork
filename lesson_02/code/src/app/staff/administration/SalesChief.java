package app.staff.administration;

import app.staff.specialists.sales.Merchandiser;
import app.staff.specialists.sales.SalesManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 24/07/2024 be_classwork
 *
 * @author Boris Iurciuc (cohort36)
 */
public class SalesChief {
@Autowired
  private Merchandiser merchandiser;
@Autowired
  private SalesManager salesManager;

  public void Merchandiser(Merchandiser merchandiser) {
    this.merchandiser = merchandiser;
  }

  public void SalesManager(SalesManager salesManager) {
    this.salesManager = salesManager;
  }

  public void giveOrders() {
    merchandiser.work();
    salesManager.work();
  }
}



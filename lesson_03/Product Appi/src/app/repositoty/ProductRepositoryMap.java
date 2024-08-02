package app.repositoty;

import app.domain.Product;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryMap implements ProductRepository{

  private final Map<Long, Product> database = new HashMap<>();

  public ProductRepositoryMap() {
    database.put(1L, new Product(1L, new BigDecimal(90), "Apple"));
    database.put(2L, new Product(2L, new BigDecimal(170), "Banana"));
    database.put(3L, new Product(3L, new BigDecimal(210), "Orange"));
  }

  @Override
  public Product getById(Long id) {
    return database.get(id);
  }
}

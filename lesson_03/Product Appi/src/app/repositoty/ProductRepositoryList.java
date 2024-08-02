package app.repositoty;

import app.domain.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryList implements ProductRepository{

  private final List<Product> database = new ArrayList<>();

  public  ProductRepositoryList() {
    database.add(new Product(1L, new BigDecimal(170), "Banana"));
    database.add(new Product(2L, new BigDecimal(170), "Apple"));
    database.add(new Product(3L, new BigDecimal(170), "Orange"));
  }

  @Override
  public Product getById(Long id) {
    return database
        .stream()
        .filter(product -> product.getId().equals(id))
        .findFirst()
        .orElse(null);
  }
}

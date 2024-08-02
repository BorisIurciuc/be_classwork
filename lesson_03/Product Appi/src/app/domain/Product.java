package app.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 26/07/2024 Product Appi * @author Boris Iurciuc (cohort36)
 */
//- id;
//- title;
//- price;
//- article.

public class Product {

  private String article;
  private String title;
  private BigDecimal price;
  private Long id;


  public Product(Long id, BigDecimal price, String title) {
    this.id = id;
    this.price = price;
    this.title = title;
  }

  public String getArticle() {
    return article;
  }

  public Long getId() {
    return id;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getTitle() {
    return title;
  }

  public void setArticle(String article) {
    this.article = article;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Product product)) {
      return false;
    }
    return Objects.equals(getId(), product.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getId());
  }

  @Override
  public String toString() {
    return String.format("Product: id - %d, title - %s, price - %s, article - %s",
        id, title, price, article);
  }


}



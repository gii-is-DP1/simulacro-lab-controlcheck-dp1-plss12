package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository  extends CrudRepository<Product, Integer>{
	
    List<Product> findAll();
    
	@Query(nativeQuery = true, value = "SELECT * FROM product_type")
    List<ProductType> findAllProductTypes();
	
	@Query(nativeQuery = true, value = "SELECT * FROM product_type pt WHERE pt.name = ?1")
    Optional<ProductType> findProductTypeByName(String name);
	
    Optional<Product> findById(int id);
    
	@Query(nativeQuery = true, value = "SELECT * FROM product p WHERE p.price < ?1")
    List<Product> findByPriceLessThan(double price);
	
    Product findByName(String name);
    
	Product save(Product p);
}

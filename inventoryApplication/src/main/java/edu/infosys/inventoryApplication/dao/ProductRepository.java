
package edu.infosys.inventoryApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.infosys.inventoryApplication.bean.Product;

public interface  ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT MAX(p.productId) FROM Product p")
    String findMaxProductId();

    @Query("SELECT p.reorderLevel FROM Product p WHERE p.productId = :productId")
    Double findReorderLevelByProductId(@Param("productId") String productId);
}


//package edu.infosys.inventoryApplication.dao;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import edu.infosys.inventoryApplication.bean.Product;
//
//@Repository
//public interface ProductRepository extends JpaRepository<Product, String>{
//	
//	@Query("select max(productId) from Product")
//	public String findMaxProductId() ;
//	
//	@Query("select reorderLevel from Product where productId = ?1")
//	public Double findReorderLevelByProductId(String id);
//
//}

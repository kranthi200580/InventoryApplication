package edu.infosys.inventoryApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.infosys.inventoryApplication.bean.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private ProductRepository repository;

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Product findProductById(String productId) {
        return repository.findById(productId).get();
    }

    @Override
    public String generateId() {
        String id = repository.findMaxProductId();
        if (id == null) {
            return "P001";
        } else {
            int num = Integer.parseInt(id.substring(1));
            num++;
            return String.format("P%03d", num);
        }
    }

    @Override
    public void removeProduct(String productId) {
        repository.deleteById(productId);
    }

    @Override
    public List<Product> showAllProducts() {
        return repository.findAll();
    }

    @Override
    public Double findReorderLevelByProductId(String productId) {
        return repository.findReorderLevelByProductId(productId);
    }

    @Override
    public void update(Product product) {
        repository.save(product);
    }
}

//package edu.infosys.inventoryApplication.dao;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import edu.infosys.inventoryApplication.bean.Product;
//
//
//@Repository
//@Service
//public class ProductDaoImpl implements ProductDao{
//	
//	@Autowired
//	private ProductRepository repository ;
//	
//	public void save (Product product) {
//		repository.save(product) ;
//	}
//	
//	@Override
//	public Product findProductById (String id) {
//		return  repository.findById(id).get() ;
//	}
//	
//	@Override
//	public String generateId () {
//		String id = repository.findMaxProductId();
//		
//		if (id==null)
//			id="P10001";
//		else {
//			int x = Integer.parseInt(id.substring(1)) ;
//			x++;
//			id="P"+x;
//		}
//		return id ;
//	}
//	
//	@Override
//	public void removeProduct(String id) {
//		repository.deleteById(id) ;
//	}
//	
//	@Override
//	public List<Product> showAllProducts() {
//		return repository.findAll() ;
//	}
//	
//	public Double findReorderLevelByProductId(String id) {
//		return repository.findReorderLevelByProductId(id);
//	}
//	
//	@Override
//	public void update(Product product) {
//		repository.save(product) ;
//	}
//}

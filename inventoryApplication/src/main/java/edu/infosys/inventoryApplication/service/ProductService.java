package edu.infosys.inventoryApplication.service;

import org.springframework.stereotype.Service;

import edu.infosys.inventoryApplication.bean.Product;

@Service
public class ProductService {
    public Product stockEdit(Product product, Double quantity, int flag) {
    	
//        Double currentStock = product.getStock();
//        if (flag == 2) {
//            currentStock -= quantity;
//        } else if (flag == 1) {
//            currentStock += quantity;
//        }
//        product.setStock(currentStock);
//        return product;
    	double stock=product.getStock();
		boolean status=product.getStatus();
		double rol=product.getReorderLevel();
		if(flag==2) {
			stock=stock-quantity;
			if(stock<=rol)
				status=false;
		  }
		else if(flag==1) {
		  stock=stock+quantity;
		  if(stock>rol)
			  status=true;
		}
		product.setStock(stock);
		product.setStatus(status);
		return product;
    }

    public Product setSalesPrice (Product product){
        double purchasePrice = product.getPurchasePrice();
        double salesPrice = purchasePrice + (0.25 * purchasePrice);
        product.setSalesPrice(salesPrice);
        return product;
    }

    public String stockChecking(Product product){
        double stock = product.getStock();
        double rol = product.getReorderLevel();
        Boolean answer;
        if (stock <= rol){
            answer = true;
        }
        else{
            answer = false;
        }
        return answer.toString();
    }
}



//package edu.infosys.inventoryApplication.service;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import edu.infosys.inventoryApplication.bean.Product;
//
//@Service
//public class ProductService {
//
//	public Product stockEdit (Product product, Double qty, int flag) {
//		double stock = product.getStock();
//		if(flag==2) 
//			stock = stock-qty;
//		else if(flag==1)
//			stock=stock+qty;
//		product.setStock(stock);
//		return product;
//	}
//	
//	public Product setSalesPrice (Product product) {
//		double purchasePrice = product.getPurchasePrice();
//		double  salesPrice = purchasePrice + purchasePrice*0.20;
//		
//		product.setSalesPrice(salesPrice);
//		return product ;
//	}
//	
//	public String stockChecking(Product product) {
//		double stock = product.getStock();
//		double rol = product.getReorderLevel();
//		Boolean answer = false ;
//		if(stock>rol) 
//			answer = true;
//		else
//			answer = false;
//		return answer.toString();
//	}
//}
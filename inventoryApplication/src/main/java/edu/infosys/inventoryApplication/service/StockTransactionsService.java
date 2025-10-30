package edu.infosys.inventoryApplication.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infosys.inventoryApplication.bean.Product;
import edu.infosys.inventoryApplication.bean.StockTransactions;
import edu.infosys.inventoryApplication.dao.ProductDaoImpl;
import edu.infosys.inventoryApplication.dao.StockTransactionsDao;
import edu.infosys.inventoryApplication.dao.StockTransactionsRepository;

@Service
public class StockTransactionsService {
    @Autowired
    private StockTransactionsRepository repository;

    @Autowired
    private StockTransactionsDao stockTransactionsDao;

    @Autowired
    private ProductDaoImpl dao;

    @Autowired
    private InventoryUserService service;

    public void processTransaction(String productId, int flag, Double quantity) {
        Product product = dao.findProductById(productId);
        String userId = service.getUser().getUsername();
        String transactionType = null;
        Double transactionValue = null;
        if (flag == 1) {
            transactionType = "IN";
            transactionValue = product.getPurchasePrice() * quantity;
        }
        if(flag == 2) {
            transactionType = "OUT";
            transactionValue = product.getSalesPrice() * quantity;
        }

        StockTransactions transaction = new StockTransactions();
        transaction.setTransactionId(stockTransactionsDao.generateId());
        transaction.setTransactionType(transactionType);
        transaction.setProductId(productId);
        transaction.setQuantity(quantity);
        transaction.setTransactionValue(transactionValue);
        transaction.setUserId(userId);
        transaction.setTransactionDate(new Date().toString());

        repository.save(transaction);
    }
}
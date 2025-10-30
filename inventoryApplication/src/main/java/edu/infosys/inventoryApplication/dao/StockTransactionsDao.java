package edu.infosys.inventoryApplication.dao;

import java.util.List;

import edu.infosys.inventoryApplication.bean.ProductSales;
import edu.infosys.inventoryApplication.bean.StockTransactions;

public interface StockTransactionsDao {
    public void save(StockTransactions stockTransaction);
    public Long generateId();
    // public StockTransactions findByTransactionId(Long transactionId);
    public List<StockTransactions> showAllStockTransactions();
    public List<StockTransactions> findByTransactionType(String transactionType);
    
    public List<ProductSales> getProductWiseTotalSale();
    public List<Double> getDemandByProduct(String productId);
}
package model;

import java.util.List;

import dao.StockDAO;

public class StockCheckLogic {
	//複数のデータ捜索、一つ一つの商品のデータをJSPページに乗せるためのメソッド
	public List<Stock> executeFindAll() {
		StockDAO stockDao = new StockDAO();
		List<Stock> stocks = stockDao.findAll();
		return stocks;
	}

	//一つのデータ捜索
	public Stock executeFind(String productId){
		StockDAO stockDAO = new StockDAO();
		Stock stock = new Stock(productId);
		Stock product = stockDAO.find(stock);
		return product;
	}

	//在庫数量のデータを更新(在庫を減らす)
	public void executeMinusStock(Stock stock, int minusAmount) {
		int changedStockAmount = stock.getProductStock() - minusAmount;
		StockDAO stockDAO = new StockDAO();
		stockDAO.update(stock.getProductId(), changedStockAmount);
	}

	//在庫数量のデータを更新(在庫を増やす)
	public void executePlusStock(Stock stock, int plusAmount) {
		int changedStockAmount = stock.getProductStock() + plusAmount;
		StockDAO stockDAO = new StockDAO();
		stockDAO.update(stock.getProductId(), changedStockAmount);
	}

}

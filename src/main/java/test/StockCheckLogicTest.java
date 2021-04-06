package test;

import model.Stock;
import model.StockCheckLogic;

public class StockCheckLogicTest {
	public static void main(String[] args) {
		//StockDAO stockDao = new StockDAO();
		StockCheckLogic scl = new StockCheckLogic();
		String id = "A101";
		Stock st = scl.executeFind(id);
		System.out.println(st.getProductId());
		System.out.println(st.getProductName());
		System.out.println(st.getProductStock());
		System.out.println(st.getProductCost());
		System.out.println(st.getProductPrice());

		/*
		List<Stock> stocks = stockDao.findAll();
		System.out.println(stocks.get(0).getProductId());
		System.out.println(stocks.get(0).getProductName());
		System.out.println(stocks.get(0).getProductStock());
		System.out.println(stocks.get(0).getProductCost());
		System.out.println(stocks.get(0).getProductPrice());
		*/




	}
}

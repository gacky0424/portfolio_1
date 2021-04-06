package test;

import dao.StockDAO;
import model.Stock;
import model.StockCheckLogic;

public class StockDAOTest {
	public static void main(String[] args) {
		StockDAO stockdao = new StockDAO();

		/*List<Stock> stocks = stockdao.findAll();

		System.out.println(stocks.get(0).getProductId());
		System.out.println(stocks.get(0).getProductName());
		System.out.println(stocks.get(0).getProductStock());
		System.out.println(stocks.get(0).getProductCost());
		System.out.println(stocks.get(0).getProductPrice());
		*/

		//更新できるかどうか確認
		stockdao.update("A101", 10);

		//更新されたものをプリントして確認
		StockCheckLogic scl = new StockCheckLogic();
		Stock st = scl.executeFind("A101");
		System.out.println(st.getProductId());
		System.out.println(st.getProductName());
		System.out.println(st.getProductStock());
		System.out.println(st.getProductCost());
		System.out.println(st.getProductPrice());

	}
}

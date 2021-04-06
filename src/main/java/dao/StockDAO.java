package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Stock;

public class StockDAO {

	//在庫データを検索
	public List<Stock> findAll() {
		//格納のためのコレクション
		List<Stock> stockList = new ArrayList<>();

		//ドライバーの有効化
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//データベースの位置、ユーザーID、パスワード
		String url = "jdbc:mysql://localhost:3306/?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
		String user = "root";
		String password = "J3qn46zk";

		//SELECT文を準備
		String sql = "SELECT PRODUCT_ID,PRODUCT_NAME,PRODUCT_STOCK,PRODUCT_COST,PRODUCT_PRICE FROM WEBDB.STOCK";
		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//データベースから商品のデータを検索し、それをもとにインスタンスを生成
			while (rs.next()) {
				String productId = rs.getString("PRODUCT_ID");
				String productName = rs.getString("PRODUCT_NAME");
				int productStock = rs.getInt("PRODUCT_STOCK");
				int productCost = rs.getInt("PRODUCT_COST");
				int productPrice = rs.getInt("PRODUCT_PRICE");
				Stock stock = new Stock(productId, productName, productStock, productCost, productPrice);
				//再生したインスタンスをstackに格納
				stockList.add(stock);
			}
			pStmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return stockList;
	}

	//ひとつのデータを得る場合
	public Stock find(Stock product) {
		//格納のためのコレクション
		Stock products = null;

		//ドライバーの有効化
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//データベースの位置、ユーザーID、パスワード
		String url = "jdbc:mysql://localhost:3306/?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
		String user = "root";
		String password = "J3qn46zk";

		//SELECT文を準備
		String sql = "SELECT * FROM WEBDB.STOCK WHERE PRODUCT_ID = ?";
		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, product.getProductId());
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//データベースから商品のデータを検索し、それをもとにインスタンスを生成
			while (rs.next()) {
				String productId = rs.getString("PRODUCT_ID");
				String productName = rs.getString("PRODUCT_NAME");
				int productStock = rs.getInt("PRODUCT_STOCK");
				int productCost = rs.getInt("PRODUCT_COST");
				int productPrice = rs.getInt("PRODUCT_PRICE");
				products = new Stock(productId, productName, productStock, productCost, productPrice);
			}
			pStmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return products;
	}

	//在庫数量の調整
	public void update(String productId, int changedStockAmount) {
		//ドライバーの有効化
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//データベースの位置、ユーザーID、パスワード
		String url = "jdbc:mysql://localhost:3306/?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
		String user = "root";
		String password = "J3qn46zk";

		//SELECT文を準備
		/*String sql = "SELECT * FROM WEBDB.STOCK WHERE PRODUCT_ID =" +  "  '  "+ productId + "  '  ";*/
		String sql = "UPDATE WEBDB.STOCK SET PRODUCT_STOCK = ? WHERE PRODUCT_ID = ?";
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//在庫数量のデータを修正
			pStmt.setInt(1, changedStockAmount);
			pStmt.setString(2, productId);

			pStmt.executeUpdate();
			pStmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

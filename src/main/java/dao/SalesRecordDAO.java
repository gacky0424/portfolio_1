package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.SalesNumberMaker;
import model.SalesRecord;

public class SalesRecordDAO {
	//すべての販売記録データを検索
	public List<SalesRecord> findAll() {
		//格納のためのコレクション
		List<SalesRecord> salesRecordList = new ArrayList<>();

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
		String sql = "SELECT SALE_NUMBER,SALE_TIME,CUSTOMER,PRODUCT_ID,PRODUCT_NAME,PRODUCT_AMOUNT,PRICE FROM WEBDB.SALESRECORD";
		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//データベースから商品のデータを検索し、それをもとにインスタンスを生成
			while (rs.next()) {
				int number = rs.getInt("SALE_NUMBER");
				Date date = rs.getDate("SALE_TIME");
				String customer = rs.getString("CUSTOMER");
				String productId = rs.getString("PRODUCT_ID");
				String productName = rs.getString("PRODUCT_NAME");
				int productAmount = rs.getInt("PRODUCT_AMOUNT");
				int productPrice = rs.getInt("PRICE");
				SalesRecord salesRecord = new SalesRecord(number, date, customer, productId, productName, productAmount,
						productPrice);
				//再生したインスタンスをstackに格納
				salesRecordList.add(salesRecord);
			}
			pStmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return salesRecordList;
	}

	//一つの販売記録データを得る場合
	public SalesRecord find(int salesRecordNumber) {
		//格納のためのコレクション
		SalesRecord sr = null;

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
		String sql = "SELECT * FROM WEBDB.SALESRECORD WHERE SALE_NUMBER = ?";
		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, salesRecordNumber);
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//データベースから商品のデータを検索し、それをもとにインスタンスを生成
			while (rs.next()) {
				int number = rs.getInt("SALE_NUMBER");
				Date date = rs.getDate("SALE_TIME");
				String customer = rs.getString("CUSTOMER");
				String productId = rs.getString("PRODUCT_ID");
				String productName = rs.getString("PRODUCT_NAME");
				int productAmount = rs.getInt("PRODUCT_AMOUNT");
				int productPrice = rs.getInt("PRICE");
				sr = new SalesRecord(number, date, customer, productId, productName, productAmount,productPrice);
			}
			pStmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return sr;
	}

	public boolean create(SalesRecord sr) {
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

		//INSERT文を準備
		String sql = "INSERT INTO WEBDB.SALESRECORD"
				+ "(SALE_NUMBER,SALE_TIME,CUSTOMER,PRODUCT_ID,PRODUCT_NAME,PRODUCT_AMOUNT,PRICE) VALUES(?,?,?,?,?,?,?)";
		//データベースに接続し、データを追加する
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//データを追加
			pStmt.setInt(1, new SalesNumberMaker().makeNumber());
			pStmt.setTimestamp(2, new Timestamp(new java.util.Date().getTime()));
			pStmt.setString(3, sr.getCustomer());
			pStmt.setString(4, sr.getProductId());
			pStmt.setString(5, sr.getProductName());
			pStmt.setInt(6, sr.getProductAmount());
			pStmt.setInt(7, sr.getPrice());
			int rs = pStmt.executeUpdate();

			//実行されたか確認
			if (rs != 1) {
				return false;//されなかった場合はfalseを返す
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;//スローされた場合もfalseを返す
		}
		return true;//try-catchブロックに問題がなかった場合はtrueを返す
	}

	public boolean delete(SalesRecord sr) {
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

		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			String sql = "DELETE FROM WEBDB.SALESRECORD WHERE SALE_NUMBER = " + sr.getNumber();
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//データを削除
			int rs = pStmt.executeUpdate();
			//実行されたか確認
			if (rs != 1) {
				return false;//されなかった場合はfalseを返す
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;//スローされた場合もfalseを返す
		}
		return true;//try-catchブロックに問題がなかった場合はtrueを返す
	}

}

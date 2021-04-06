package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = null;

		String url = "jdbc:mysql://localhost:3306/?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
		String user = "root";
		String password = "J3qn46zk";

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("接続成功");
		}catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバーが見つかりません!");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("接続失敗");
		}

	}
}

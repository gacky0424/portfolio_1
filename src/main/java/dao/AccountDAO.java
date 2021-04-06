package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {

	public Account findByLogin(Login login) {
		Account account = null;

		//ドライバーの準備
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		}catch(Exception e) {
			e.printStackTrace();

		}
		//データベースの位置、ユーザーID、パスワード
		String url = "jdbc:mysql://localhost:3306/?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
		String user = "root";
		String password = "J3qn46zk";

		//SELECT文を準備
		String sql = "SELECT ID,NAME,PASS FROM WEBDB.ACCOUNT WHERE ID = ? AND PASS = ?";
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getId());
			pStmt.setString(2, login.getPass());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致のユーザーが存在した場合、Accountインスタンスを生成
			if(rs.next()) {
				//データベースからデータを取得し、それをもとにインスタンスを生成
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				account = new Account(id, name, pass);
			}
			pStmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return account;
	}
}

package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import dao.AccountDAO;
import model.Account;
import model.Login;

class AccountDAOTest {

//	@Test
//	void testDriverEnabe() {
//		AccountDAO dao = new AccountDAO();
//		if(!dao.driverEnable()) {
//			Assert.fail("有効化失敗");
//		}
//	}

	@Test
	void testFindByLogin_exist() {
		Login login = new Login("jack1234","12345");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if (result != null && !result.getId().equals(login.getId()) && !result.getPass().equals(login.getPass())) {
			Assert.fail("失敗しました");
		}
	}

	@Test
	void testFindByLogin_notExist() {
		Login login = new Login("jack1234","56789");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if (result != null ) {
			Assert.fail("失敗しました");
		}
	}

}

package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.Login;
import model.LoginLogic;

class LoginLogicTest {

	@Test
	public void testExcuteSuccess() {
		Login login = new Login("jack1234","12345");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if(!result) {
			Assert.fail("ログインの成功を確認できませんでした");
		}
	}

	@Test
	public void testExcuteNonSuccess() {
		Login login = new Login("jack1234","1234");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if(result) {
			Assert.fail("ログインに成功してしまいました");
		}
	}

}

package listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	@Test
	void loginByEmail() {
		System.out.println("Login By Email");
		Assert.assertEquals("monika", "monika");
	}
	@Test
	void loginByFacebook() {
	System.out.println("Login By Facebook");
	Assert.assertEquals("Monika", "monika");
	}
}

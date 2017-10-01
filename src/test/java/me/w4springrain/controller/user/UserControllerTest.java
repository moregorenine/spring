package me.w4springrain.controller.user;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.w4springrain.domain.user.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class UserControllerTest {

	@Autowired
	private UserController userController;
	
	@Test
	public void testForm() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate() {
		User user = new User("userId", "password", "name", "email");
		userController.create(user);	
	}

}

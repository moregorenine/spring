package me.w4springrain.dao.user;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
	
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.w4springrain.domain.user.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void findById() {
		User user = userDao.findById("admin");
		assertThat("user °´Ã¼ ºñ±³", user.getUserId(), is("admin"));	
	}

}

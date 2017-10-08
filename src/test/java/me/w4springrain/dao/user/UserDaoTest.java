package me.w4springrain.dao.user;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import me.w4springrain.domain.user.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
@Transactional
@Rollback
public class UserDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void findById() {
		User user = new User(); 
		user.setUserId("userId");
		user.setPassword("password");
		user.setName("name");
		user.setEmail("email");
		userDao.create(user);
		assertNotNull(user);
		user = userDao.findById("userId");
		assertThat(user.getUserId(), is("userId"));
		assertNotNull(user.getUserId());
		assertNotNull(user.getPassword());
		assertNotNull(user.getName());
		assertNotNull(user.getEmail());
	}
	
	@Test
	public void createUser() {
		User user = new User("userId", "password", "test user name", "test@testmail");
		int cntCreate = userDao.create(user);
		assertThat(cntCreate, is(1));
		User dbUser = userDao.findById(user.getUserId());
		assertThat(dbUser.getUserId(), is(user.getUserId()));
	}

}

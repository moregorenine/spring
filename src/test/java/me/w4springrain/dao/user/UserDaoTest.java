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
		user.setPassword("password");
		user.setEmail("email");
		userDao.create(user);
		assertNotNull(user);
		User insertedUser = userDao.findId();
		user.setUserId(insertedUser.getUserId());
		User dbUser = userDao.findById(user.getUserId());
		assertThat(user.getUserId(), is(dbUser.getUserId()));
		assertThat(user.getPassword(), is(dbUser.getPassword()));
		assertThat(user.getEmail(), is(dbUser.getEmail()));
	}
	
	@Test
	public void createUser() {
		User user = new User(null, "password", "test@testmail");
		int cntCreate = userDao.create(user);
		assertThat(cntCreate, is(1));
		user = userDao.findId();
		User dbUser = userDao.findById(user.getUserId());
		assertThat(dbUser.getUserId(), is(user.getUserId()));
	}

}

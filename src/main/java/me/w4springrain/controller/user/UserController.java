package me.w4springrain.controller.user;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.w4springrain.dao.user.UserDao;
import me.w4springrain.domain.user.User;

@RestController
@RequestMapping("/user")
@Transactional
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public User create(@Valid User user) {
		log.debug("User : {}", user);
		int cntCreate = userDao.create(user);
		log.debug("User {} created success", cntCreate);
		return user;
	}
}

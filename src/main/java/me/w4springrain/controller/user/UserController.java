package me.w4springrain.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.w4springrain.dao.user.UserDao;
import me.w4springrain.domain.user.User;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public String create(User user) {
		log.debug("User : {}", user);
		int cntCreate = userDao.create(user);
		log.debug("User {} created success", cntCreate);
		return "user/form";
	}
}

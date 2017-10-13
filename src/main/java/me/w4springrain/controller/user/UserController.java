package me.w4springrain.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import me.w4springrain.dao.user.UserDao;
import me.w4springrain.domain.user.User;

@RestController
@RequestMapping("api/user")
@Transactional
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDao userDao;
	
//	@Autowired
//	private User user;
	
	@RequestMapping(method = RequestMethod.POST, path = "", produces = "application/json")
	@ApiOperation(value = "user 등록", notes = "user 등록")
//	@ApiImplicitParams({
//        @ApiImplicitParam(name = "password", value = "암호", required = true, dataType = "string", paramType = "query", defaultValue = ""),
//        @ApiImplicitParam(name = "email", value = "이메일", required = true, dataType = "string", paramType = "query", defaultValue = "")})
	public User create(@Validated User user) {
//	public User create(@RequestParam(value = "암호", required = true) String password,
//			@RequestParam(value = "이메일", required = true) String email) {
//		user.setPassword(password);
//		user.setEmail(email);
		log.debug("User : {}", user);
		int cntCreate = userDao.create(user);
		log.debug("User {} created success", cntCreate);
		return user;
	}
}

package me.w4springrain.controller.user;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import me.w4springrain.dao.user.UserDao;
import me.w4springrain.domain.user.User;

@RestController
@RequestMapping("api/user")
@Transactional
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(method = RequestMethod.POST, path = "", produces = "application/json")
	@ApiOperation(value = "getGreeting", nickname = "getGreeting")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue = "Niklas") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure") }) 
	public User create(@Valid User user) {
		log.debug("User : {}", user);
		int cntCreate = userDao.create(user);
		log.debug("User {} created success", cntCreate);
		return user;
	}
}

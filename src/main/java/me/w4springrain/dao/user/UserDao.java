package me.w4springrain.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import me.w4springrain.domain.user.User;

public class UserDao extends JdbcDaoSupport {
	@PostConstruct
	private void initialize() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("w4springrain.sql"));
		DatabasePopulatorUtils.execute(populator, getDataSource());
	}
	
	/**
	 * W4_USER 조회
	 * @param userId
	 * @return
	 */
	public User findById(String userId) {
		String sql = "select * from W4_USER where userId = ?";
		RowMapper<User> rowMapper = new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet arg0, int arg1) throws SQLException {
				return new User(arg0.getString("userId"), arg0.getString("password"), arg0.getString("name"), arg0.getString("email"));
			}
		};
		return getJdbcTemplate().queryForObject(sql, rowMapper, userId);
	}

	/**
	 * W4_USER 생성
	 * @param user
	 * @return
	 */
	public int create(User user) {
		String sql = "insert into W4_USER values(?, ?, ?, ?)";
		return getJdbcTemplate().update(sql, user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
	}
}
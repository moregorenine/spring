package me.w4springrain.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import me.w4springrain.domain.user.User;

public class UserDao extends JdbcDaoSupport {
	
//	@PostConstruct
//	private void initialize() {
//		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//		populator.addScript(new ClassPathResource("w4springrain.sql"));
//		DatabasePopulatorUtils.execute(populator, getDataSource());
//		log.info("database initialize success!!!");
//	}
	
	/**
	 * W4_USER 조회
	 * @param userId
	 * @return
	 */
	public User findId() {
		String sql = "select last_insert_id() as user_id";
		RowMapper<User> rowMapper = new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet arg0, int arg1) throws SQLException {
				return new User(arg0.getInt("user_id"));
			}
		};
		return getJdbcTemplate().queryForObject(sql, rowMapper);
	}
	
	/**
	 * W4_USER 조회
	 * @param userId
	 * @return
	 */
	public User findById(Integer userId) {
		String sql = "select * from W4_USER where user_id = ?";
		RowMapper<User> rowMapper = new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet arg0, int arg1) throws SQLException {
				return new User(arg0.getInt("user_id"), arg0.getString("password"), arg0.getString("email"));
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
		String sql = "insert into W4_USER (password, email) values(?, ?)";
		return getJdbcTemplate().update(sql, user.getPassword(), user.getEmail());
	}
}
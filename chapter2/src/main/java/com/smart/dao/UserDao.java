package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository // 1.通过Spring注解定义一个Dao
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    private final static String MATCH_COUNT_SQL = "SELECT COUNT(*) FROM t_user WHERE user_name=? AND password=?";
    private final static String FIND_USER_BY_NAME_SQL = "SELECT user_id,user_name,credits FROM t_user WHERE user_name=?";
    private final static String UPDATE_LOGIN_INFO_SQL = "UPDATE t_user SET last_visit=?,last_ip=?,credits=? WHERE user_id=?";

    @Autowired // 2.自动注入JdbcTemplate 的Bean
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getMatchCount(String userName, String password) {
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }

    public User findUserByUserName(String userName) {
        User user = new User();
        jdbcTemplate.query(FIND_USER_BY_NAME_SQL, new Object[]{userName},
                //匿名内部方式实现的回调函数
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setUserId(rs.getInt("user_id"));
                        user.setUserName(userName);
                        user.setCredits(rs.getInt("credits"));
                    }
                });
        return user;
    }

    public void updateLoginInfo(User user) {
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId());
    }


}

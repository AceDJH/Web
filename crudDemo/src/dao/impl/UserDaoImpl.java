package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/3/6 12:55
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        return user;
    //    相对于教程，少了try catch，即少了一个return null
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null, ?, ?, ?, ?, ?, ?, null, null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql, id);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?, gender = ?, age = ?, " +
                "address = ?, qq = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from user";
        return template.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String sql = "select * from user limit ? , ?";
        return template.query(sql, new BeanPropertyRowMapper<>(User.class), start, rows);
    }


}

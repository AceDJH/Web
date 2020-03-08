package dao;

import domain.User;

import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/3/6 12:55
 * 用户操作的DAO
 */
public interface UserDao {
    public List<User> findAll();
    public User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int id);


    User findById(int id);

    void update(User user);

    int findTotalCount();

    List<User> findByPage(int start, int rows);
}

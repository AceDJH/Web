package service;

import domain.User;

import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/3/6 12:53
 * 用户管理的业务接口
 */
public interface UserService {
    /*查询所有用户信息*/
    public List<User> findAll();

    public User login(User user);
}

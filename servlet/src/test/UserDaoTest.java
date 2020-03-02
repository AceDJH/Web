package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

/**
 * @Author AceDJH
 * @Date 2020/3/2 20:00
 */
public class UserDaoTest {
    @Test
    public void testLogin(){
        User user = new User();
        user.setUsername("superbaby");
        user.setPassword("123123");
        UserDao userDao = new UserDao();

        User login = userDao.login(user);
        System.out.println(login);
    }
}

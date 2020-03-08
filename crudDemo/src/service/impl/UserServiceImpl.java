package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/3/6 12:54
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User login(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return userDao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void delSelectdUser(String[] uids) {
        for (String uid : uids) {
            userDao.delete(Integer.parseInt(uid));
        }
    }

    @Override
    public PageBean<User> findUserByPage(String currentPage1, String rows1) {
        int currentPage = Integer.parseInt(currentPage1);
        int rows = Integer.parseInt(rows1);

        PageBean<User> pageBean = new PageBean<>();
        int totalCount = userDao.findTotalCount();
        pageBean.setTotalCount(totalCount);

        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pageBean.setTotalPage(totalPage);
        if (currentPage <= 0){
            currentPage = 1;
        }
        if (currentPage >= totalPage){
            currentPage = totalPage;
        }
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        // 计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = userDao.findByPage(start, rows);
        pageBean.setList(list);
        return pageBean;
    }
}

package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Intellij IDEA
 * Author: yi cheng
 * Date: 2022/9/12
 * Time: 17:05
 **/
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 增，改
     *
     * @param user
     */
    public void save(User user) {
        String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setCreateTime(now);
        userDao.save(user);

    }

    /**
     * 删除
     *
     * @param id
     */
    public void del(Long id) {

        userDao.deleteById(id);

    }

    /**
     * 查询用户
     *
     * @param id
     * @return
     */
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    public Page<User> findPage(Integer pageNum, Integer pageSize, String name) {
        Sort time = Sort.by(Sort.Direction.DESC, "create_time");
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize, time);
        return userDao.findNameLike(name, pageRequest);

    }


}

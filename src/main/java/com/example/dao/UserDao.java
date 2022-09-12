package com.example.dao;

import com.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Intellij IDEA
 * Author: yi cheng
 * Date: 2022/9/12
 * Time: 17:04
 **/
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query(value = "select * from user where name like %?1%",nativeQuery = true)
    Page<User> findNameLike(String name, PageRequest pageRequest);
}

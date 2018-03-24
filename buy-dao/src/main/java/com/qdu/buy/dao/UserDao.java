package com.qdu.buy.dao;



import com.qdu.buy.domain.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Descripition: 用户DAO
 * @Author: xiepf
 * @Date: 2017/10/13 15:27
 */
public interface UserDao {


    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    List<User> queryUserByUserName(String userName);

    /**
     * 根据用户名和密码查询用户
     * @param userName
     * @param password
     * @return
     */
    List<User> queryUserByUserNameAndPwd(@Param("userName") String userName, @Param("password") String password);


}

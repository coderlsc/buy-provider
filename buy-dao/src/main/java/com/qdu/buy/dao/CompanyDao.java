package com.qdu.buy.dao;



import com.qdu.buy.domain.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Descripition: 用户DAO
 * @Author: xiepf
 * @Date: 2017/10/13 15:27
 */
public interface CompanyDao {


    /**
     * 根据用户名查询用户基本信息
     * @param userName
     * @return
     */
    List<User> queryUserByUserName(String userName);

    /**
     * 根据用户名和密码查询用户
     * @param companyName
     * @param password
     * @return
     */
    List<User> queryUserByCompanyNameAndPwd(@Param("companyName") String companyName, @Param("password") String password);


}

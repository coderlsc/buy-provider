package com.qdu.buy.dao.admin;

import com.qdu.buy.domain.po.admin.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin queryAdminByUsernameandPwd(@Param("username") String username, @Param("password") String password);
}
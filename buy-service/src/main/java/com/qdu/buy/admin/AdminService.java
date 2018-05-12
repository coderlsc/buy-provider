package com.qdu.buy.admin;

import com.qdu.buy.domain.po.admin.Admin;


public interface AdminService {

    Admin queryAdminByUsernameandPwd(String username, String password);

//    //根据手机号获取采购商信息
//    List<Admin> selectByPhone(String phone);

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);


    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);


}
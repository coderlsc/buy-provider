package com.qdu.buy.impl;

import com.qdu.buy.admin.AdminService;
import com.qdu.buy.dao.admin.AdminDao;
import com.qdu.buy.domain.po.admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin queryAdminByUsernameandPwd(String username, String password) {
       return adminDao.queryAdminByUsernameandPwd(username,password);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
            return adminDao.deleteByPrimaryKey(null);
    }

    @Override
    public int insert(Admin record) {
            return adminDao.insert(record);
    }

    @Override
    public Admin selectByPrimaryKey(Long id) {
            return adminDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record){
        return adminDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminDao.updateByPrimaryKey(record);
    }
}
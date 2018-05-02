package com.qdu.buy.impl;

import com.qdu.buy.company.PurchaserService;
import com.qdu.buy.company.PurchaserService;
import com.qdu.buy.dao.company.PurchaserMapper;
import com.qdu.buy.dao.company.PurchaserMapper;
import com.qdu.buy.domain.po.company.Purchaser;
import com.qdu.buy.lang.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PurchaserServieImpl implements PurchaserService {


    @Autowired
    private PurchaserMapper purchaserMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return  purchaserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Long insert(Purchaser record) {
        record.setStatus(Constants.Purchaser.StatusEnum.dead.getValue());
        record.setCreateTime(new Date());
        record.setCreateUser("admin");
        record.setUpdateTime(new Date());
        record.setUpdateUser("admin");
        purchaserMapper.insert(record);
        return record.getId();
    }

    @Override
    public Long insertSelective(Purchaser record) {
        record.setStatus(Constants.Purchaser.StatusEnum.dead.getValue());
        record.setCreateTime(new Date());
        record.setCreateUser("admin");
        record.setUpdateUser("admin");
        record.setUpdateTime(new Date());
        purchaserMapper.insertSelective(record);
        return record.getId();
    }

    @Override
    public Purchaser selectByPrimaryKey(Long id) {
            return purchaserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Purchaser record) {
        return purchaserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Purchaser record) {
        return purchaserMapper.updateByPrimaryKey(record);
    }

    @Override
    public Purchaser selectByPhoneAndPassword(String phone,String password) {
        return purchaserMapper.selectByPhoneAndPassword(phone,password);
    }

    //根据手机号获取采购商信息
    @Override
    public List<Purchaser> selectByPhone(String phone){
        return purchaserMapper.selectByPhone(phone);
    }
}
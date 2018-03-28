package com.qdu.buy.impl;

import com.qdu.buy.company.PurchaserService;
import com.qdu.buy.company.PurchaserService;
import com.qdu.buy.dao.company.PurchaserMapper;
import com.qdu.buy.dao.company.PurchaserMapper;
import com.qdu.buy.domain.po.company.Purchaser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class PurchaserServieImpl implements PurchaserService {


    @Autowired
    private PurchaserMapper purchaserMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return  purchaserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Purchaser record) {
        record.setCreateTime(new Date());
        record.setCreateUser("admin");
        record.setUpdateTime(new Date());
        record.setUpdateUser("admin");
        return purchaserMapper.insert(record);
    }

    @Override
    public int insertSelective(Purchaser record) {
        record.setUpdateUser("admin");
        record.setUpdateTime(new Date());
        return purchaserMapper.insertSelective(record);
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
}
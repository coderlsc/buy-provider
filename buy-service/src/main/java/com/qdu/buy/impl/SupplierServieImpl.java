package com.qdu.buy.impl;

import com.qdu.buy.company.PurchaserService;
import com.qdu.buy.company.SupplierService;
import com.qdu.buy.dao.company.PurchaserMapper;
import com.qdu.buy.dao.company.SupplierMapper;
import com.qdu.buy.domain.po.company.Purchaser;
import com.qdu.buy.domain.po.company.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class SupplierServieImpl implements SupplierService {


    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return  supplierMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Supplier record) {
        record.setCreateTime(new Date());
        record.setCreateUser("admin");
        record.setUpdateTime(new Date());
        record.setUpdateUser("admin");
        return supplierMapper.insert(record);
    }

    @Override
    public int insertSelective(Supplier record) {
        record.setUpdateUser("admin");
        record.setUpdateTime(new Date());
        return supplierMapper.insertSelective(record);
    }

    @Override
    public Supplier selectByPrimaryKey(Long id) {
            return supplierMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Supplier record) {
        return supplierMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Supplier record) {
        return supplierMapper.updateByPrimaryKey(record);
    }
}
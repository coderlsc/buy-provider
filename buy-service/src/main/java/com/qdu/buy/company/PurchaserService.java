package com.qdu.buy.company;

import com.qdu.buy.domain.po.company.Purchaser;

public interface PurchaserService {


    int deleteByPrimaryKey(Long id);

    Long insert(Purchaser record);

    Long insertSelective(Purchaser record);

    Purchaser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Purchaser record);

    int updateByPrimaryKey(Purchaser record);

    Purchaser selectByPhoneAndPassword(String phone,String password);

}
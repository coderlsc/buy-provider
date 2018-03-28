package com.qdu.buy.dao.company;

import com.qdu.buy.domain.po.company.Purchaser;

public interface PurchaserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Purchaser record);

    int insertSelective(Purchaser record);

    Purchaser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Purchaser record);

    int updateByPrimaryKey(Purchaser record);
}
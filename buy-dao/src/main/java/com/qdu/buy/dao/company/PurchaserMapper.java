package com.qdu.buy.dao.company;

import com.qdu.buy.domain.po.company.Purchaser;
import org.apache.ibatis.annotations.Param;

public interface PurchaserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Purchaser record);

    int insertSelective(Purchaser record);

    Purchaser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Purchaser record);

    int updateByPrimaryKey(Purchaser record);

    Purchaser selectByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

}
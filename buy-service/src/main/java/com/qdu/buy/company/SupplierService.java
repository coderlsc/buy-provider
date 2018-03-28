package com.qdu.buy.company;

import com.qdu.buy.domain.po.company.Purchaser;
import com.qdu.buy.domain.po.company.Supplier;

public interface SupplierService {


    int deleteByPrimaryKey(Long id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);


}
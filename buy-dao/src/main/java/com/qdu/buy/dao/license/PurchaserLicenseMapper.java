package com.qdu.buy.dao.license;

import com.qdu.buy.domain.po.license.PurchaserLicense;

public interface PurchaserLicenseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PurchaserLicense record);

    int insertSelective(PurchaserLicense record);

    PurchaserLicense selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PurchaserLicense record);

    int updateByPrimaryKey(PurchaserLicense record);
}
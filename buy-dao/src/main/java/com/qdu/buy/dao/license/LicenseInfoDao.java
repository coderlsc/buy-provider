package com.qdu.buy.dao.license;

import com.qdu.buy.domain.po.license.LicenseInfo;

public interface LicenseInfoDao {
    int deleteByPrimaryKey(Long id);

    int insert(LicenseInfo record);

    int insertSelective(LicenseInfo record);

    LicenseInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LicenseInfo record);

    int updateByPrimaryKey(LicenseInfo record);
}
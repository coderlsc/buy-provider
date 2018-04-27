package com.qdu.buy.dao.resource;

import com.qdu.buy.domain.po.resource.LicenseResource;

public interface LicenseResourceDao {

    int deleteByPrimaryKey(Long id);

    int insert(LicenseResource record);

    int insertSelective(LicenseResource record);

    LicenseResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LicenseResource record);

    int updateByPrimaryKey(LicenseResource record);
}
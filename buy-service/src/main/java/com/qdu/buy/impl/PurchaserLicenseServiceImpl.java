package com.qdu.buy.impl;

import com.qdu.buy.dao.license.PurchaserLicenseMapper;
import com.qdu.buy.domain.po.license.PurchaserLicense;
import com.qdu.buy.license.PurchaserLicenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class PurchaserLicenseServiceImpl  implements PurchaserLicenseService {
    @Autowired
    private PurchaserLicenseMapper purchaserLicenseMapper;

    @Override
    @Transactional
    public int insert(Long purchaserId,Long licenseresourceId,String licenseType) {
        PurchaserLicense purchaserLicense=new PurchaserLicense();
        purchaserLicense.setCreateTime(new Date());
        purchaserLicense.setCreateUser("admin");
        purchaserLicense.setUpdateTime(new Date());
        purchaserLicense.setUpdateUser("admin");
        purchaserLicense.setCompanyId(purchaserId);
        purchaserLicense.setLicenseResourceId(licenseresourceId);
        purchaserLicense.setResourceType(licenseType);
        return purchaserLicenseMapper.insert(purchaserLicense);
    }
}
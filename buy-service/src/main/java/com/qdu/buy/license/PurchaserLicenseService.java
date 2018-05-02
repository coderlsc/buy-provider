package com.qdu.buy.license;

import com.qdu.buy.dao.license.PurchaserLicenseMapper;
import com.qdu.buy.domain.po.license.PurchaserLicense;
import org.springframework.beans.factory.annotation.Autowired;

public interface PurchaserLicenseService {


    int insert(Long purchaserId,Long resourceId,String licenseType);



}
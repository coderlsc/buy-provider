package com.qdu.buy.domain.po.license;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class LicenseInfo {
    private Long id;

    private Long licenseResourceId;

    private Long companyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLicenseResourceId() {
        return licenseResourceId;
    }

    public void setLicenseResourceId(Long licenseResourceId) {
        this.licenseResourceId = licenseResourceId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
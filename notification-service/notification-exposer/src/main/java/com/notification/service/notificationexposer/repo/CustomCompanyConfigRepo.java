package com.notification.service.notificationexposer.repo;

import com.notification.service.notificationexposer.models.CompanyConfiguration;


public interface CustomCompanyConfigRepo  {
  CompanyConfiguration findByCompanyId(int companyId);


}

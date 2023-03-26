package com.notification.service.notificationexposer.repo;

import com.notification.service.notificationexposer.models.CompanyConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyConfigRepo extends MongoRepository<CompanyConfiguration,String>,CustomCompanyConfigRepo {
    // CompanyConfiguration findByCompanyId(int companyId);
}

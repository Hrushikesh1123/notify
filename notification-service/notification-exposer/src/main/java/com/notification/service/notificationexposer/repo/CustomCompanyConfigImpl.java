package com.notification.service.notificationexposer.repo;

import com.notification.service.notificationexposer.models.CompanyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public  class CustomCompanyConfigImpl implements CustomCompanyConfigRepo {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public CompanyConfiguration findByCompanyId(int companyId){
        Query query=new Query();
        query.addCriteria(Criteria.where("companyId").is(companyId));
        System.out.println("hey arrived");
        List<CompanyConfiguration> companyConfig=mongoTemplate.find(query,CompanyConfiguration.class);
        if(companyConfig.isEmpty()){
            return new CompanyConfiguration();
        }
        return companyConfig.get(0);

    }
}

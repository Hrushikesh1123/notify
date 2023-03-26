package com.notification.service.notificationexposer.service;

import com.notification.service.notificationexposer.models.CompanyConfiguration;
import com.notification.service.notificationexposer.repo.CompanyConfigRepo;
import com.notification.service.notificationexposer.repo.CustomCompanyConfigRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CompanyConfigService {

    public static final int MIN_VAL=10000;
    public static final int MAX_VAL=99999;

    public  static final int MAX_RETRY=3;

    @Autowired
    CompanyConfigRepo companyConfigRepo;

    public CompanyConfiguration companyConfigCreate() throws Exception {

        CompanyConfiguration companyConfig=new CompanyConfiguration();
        companyConfig.setCompanyId(generateRandomCompanyId());
        String key = UUID.randomUUID().toString();
        String apiKey=key;
        companyConfig.setApiKey(apiKey);
        Date date = new Date();
        companyConfig.setCreatedDate(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 12);
        Date expirationDate = cal.getTime();
        companyConfig.setExpiredDate(expirationDate);
        companyConfigRepo.save(companyConfig);
        return companyConfig;
    }

    public int generateRandomCompanyId() throws Exception{
        Integer retry=0;
        while(retry<MAX_RETRY){
            try{
                int generatedCompanyId= (int)(Math.random() * (MAX_VAL - MIN_VAL + 1) )+ MIN_VAL;
               CompanyConfiguration companyConfiguration= companyConfigRepo.findByCompanyId(generatedCompanyId);
               if(companyConfiguration==null) {
                   return generatedCompanyId;
               }
               ++retry;
            }catch(Exception e){
                  throw new Exception("all retry failed");
              }
            }


        throw new Exception("all retry failed");
    }

    public CompanyConfiguration getCompanyDetails(int companyId){
        return companyConfigRepo.findByCompanyId(companyId);
    }


}

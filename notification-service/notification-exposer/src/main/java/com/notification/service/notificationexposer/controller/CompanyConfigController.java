package com.notification.service.notificationexposer.controller;


import com.notification.service.notificationexposer.models.CompanyConfiguration;
import com.notification.service.notificationexposer.service.CompanyConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/v1/company",path="/v1/company")
public class CompanyConfigController {


    @Autowired
    CompanyConfigService companyConfigService;
    @PostMapping("/create")
    public ResponseEntity<CompanyConfiguration> companyCreate() throws Exception {
        //superadmin implemantation has to be done authorize while creating company.ß
       CompanyConfiguration companyConfiguration=companyConfigService.companyConfigCreate();
        return new ResponseEntity(companyConfiguration, HttpStatus.OK);
    }
    @GetMapping("/get")

    public ResponseEntity<CompanyConfiguration>  getCompany(@RequestHeader int companyId){
        CompanyConfiguration companyConfiguration= (CompanyConfiguration) companyConfigService.getCompanyDetails(companyId);
        return new ResponseEntity(companyConfiguration,HttpStatus.OK);

    }




}

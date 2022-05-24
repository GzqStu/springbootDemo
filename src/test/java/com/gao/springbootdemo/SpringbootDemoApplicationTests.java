package com.gao.springbootdemo;

import com.gao.springbootdemo.config.JpaConfiguration;
import com.gao.springbootdemo.web.entity.Country;
import com.gao.springbootdemo.web.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/*@Runwith(SpringRunner.class)*/
@Slf4j
@SpringBootTest
@ContextConfiguration(classes = {JpaConfiguration.class, SpringbootDemoApplication.class})
public class SpringbootDemoApplicationTests {

    @Resource
    private CountryRepository countryRepository;

    @Before(value = "getData()")
    public void createCountry() {
        Country country = new Country();
        country.setCountryCode("86");
        country.setCountryName("中国");
        country.setCreator("sys");
        country.setGmtCreated(new Date());
        country.setModifier("sys");
        country.setGmtModified(new Date());
        country.setIsDeleted("N");
        countryRepository.save(country);
        assert country.getId()>0:"create error";

    }

    @Test
    public void getData() {
        List<Country> countryList = countryRepository.findAll();
        if(!CollectionUtils.isEmpty(countryList)){
            for(Country country: countryList){
                log.info("====国家名称:{}",country.getCountryName());
            }
        }
    }

}

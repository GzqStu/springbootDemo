package com.gao.springbootdemo.web.controller;

import com.gao.springbootdemo.web.entity.Country;
import com.gao.springbootdemo.web.repository.CountryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ：gaozhiqi
 * @date ：2022/5/24 18:07
 * @description：国家控制类
 * @version: v1.0
 */
@Controller
@RequestMapping("/country")
public class CountryController {

    @Resource
    private CountryRepository countryRepository;

    /**
     * 保存
     */
    @RequestMapping(value = "save", method = RequestMethod.GET)
    public void saveCountry() {
        Country country = new Country();
        country.setCountryCode("86");
        country.setCountryName("中国");
        country.setCreator("sys");
        country.setGmtCreated(new Date());
        country.setModifier("sys");
        country.setGmtModified(new Date());
        country.setIsDeleted("N");
        countryRepository.save(country);
    }

    /**
     * 查询
     */
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public List<Country> queryCountry() {
        return countryRepository.findAll();
    }

    /**
     * 测试页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public String testPage(Model model) {
        List<Country> list = countryRepository.findAll();
        model.addAttribute("countrys", list);
        return "index";
    }
}

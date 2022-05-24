package com.gao.springbootdemo.web.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "country")
@Data
@EqualsAndHashCode(callSuper = true)
public class Country extends BaseEntity {
    /**
     * 国家名称
     */
    private String countryName;
    /**
     * 国家编码
     */
    private String countryCode;
}

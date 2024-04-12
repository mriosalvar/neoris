package com.pruebatecnica.neorisapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "BRAND")
public class BrandModel {

    @Id
    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Column(name = "NAME")
    private String name;

}

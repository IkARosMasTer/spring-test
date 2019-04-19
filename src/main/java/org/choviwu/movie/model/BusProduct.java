package org.choviwu.movie.model;

import java.math.BigDecimal;

public class BusProduct {
    private Integer id;

    private String productName;

    private String productType;

    private Integer productNum;

    private BigDecimal productPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BusProduct() {

    }

    public BusProduct(String productName, String productType, Integer productNum, BigDecimal productPrice) {
        this.productName = productName;
        this.productType = productType;
        this.productNum = productNum;
        this.productPrice = productPrice;
    }
}
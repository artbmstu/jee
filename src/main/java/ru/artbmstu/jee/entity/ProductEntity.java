package ru.artbmstu.jee.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "shop", catalog = "")
@EqualsAndHashCode
public class ProductEntity {
    private String idproduct;
    private String productName;
    private String productDescription;

    @Id
    @Column(name = "idproduct")
    public String getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(String idproduct) {
        this.idproduct = idproduct;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_description")
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}

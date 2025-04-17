package com.abdulazeez.renew_hub.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Transaction {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long  id;
    private Long salePrice;
    private LocalDate transactionDate;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Users buyer;

    @ManyToOne
    @JoinColumn(name= "seller_id")
    private Users seller;

    @ManyToOne
    @JoinColumn(name= "property_id")
    private Property property;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Users getBuyer() {
        return buyer;
    }

    public void setBuyer(Users buyer) {
        this.buyer = buyer;
    }

    public Users getSeller() {
        return seller;
    }

    public void setSeller(Users seller) {
        this.seller = seller;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}

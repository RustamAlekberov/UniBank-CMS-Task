package com.accounts.AccountsAPI.Rustam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ALLDEFAULT")
public class Alldefault implements Serializable {
    private static final long serialVersionUID = -1389299651775004071L;
    private Long id;

    private String sazlama;

    private Long val;

    @Id
    @Column(name = "IDS", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "SAZLAMA", length = 60)
    public String getSazlama() {
        return sazlama;
    }

    public void setSazlama(String sazlama) {
        this.sazlama = sazlama;
    }

    @Column(name = "VAL")
    public Long getVal() {
        return val;
    }

    public void setVal(Long val) {
        this.val = val;
    }

}
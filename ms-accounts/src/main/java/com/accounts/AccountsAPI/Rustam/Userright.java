package com.accounts.AccountsAPI.Rustam;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERRIGHT")
public class Userright implements Serializable {
    private static final long serialVersionUID = 5270064160661714609L;
    private Usermaster suserid;

    private Right r;

    private Building bld;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUSERID")
    public Usermaster getSuserid() {
        return suserid;
    }

    public void setSuserid(Usermaster suserid) {
        this.suserid = suserid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "R_ID")
    public Right getR() {
        return r;
    }

    public void setR(Right r) {
        this.r = r;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BLD_ID")
    public Building getBld() {
        return bld;
    }

    public void setBld(Building bld) {
        this.bld = bld;
    }

}
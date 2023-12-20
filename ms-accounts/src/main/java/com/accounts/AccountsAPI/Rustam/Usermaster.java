package com.accounts.AccountsAPI.Rustam;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "USERMASTER")
public class Usermaster implements Serializable {
    private static final long serialVersionUID = 1661015397288740917L;
    private String id;

    private String sfirstname;

    private String lastname;

    private String spassword;

    private String sstatus;

    private String sadress;

    private String stelefon;

    private String smobile;

    private Set<Userright> userrights = new LinkedHashSet<>();

    @Id
    @Column(name = "SUSERID", nullable = false, length = 45)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "SFIRSTNAME", nullable = false, length = 45)
    public String getSfirstname() {
        return sfirstname;
    }

    public void setSfirstname(String sfirstname) {
        this.sfirstname = sfirstname;
    }

    @Column(name = "LASTNAME", nullable = false, length = 45)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "SPASSWORD", nullable = false, length = 45)
    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    @Column(name = "SSTATUS", nullable = false, length = 45)
    public String getSstatus() {
        return sstatus;
    }

    public void setSstatus(String sstatus) {
        this.sstatus = sstatus;
    }

    @Column(name = "SADRESS", length = 60)
    public String getSadress() {
        return sadress;
    }

    public void setSadress(String sadress) {
        this.sadress = sadress;
    }

    @Column(name = "STELEFON", length = 20)
    public String getStelefon() {
        return stelefon;
    }

    public void setStelefon(String stelefon) {
        this.stelefon = stelefon;
    }

    @Column(name = "SMOBILE", length = 20)
    public String getSmobile() {
        return smobile;
    }

    public void setSmobile(String smobile) {
        this.smobile = smobile;
    }

    @OneToMany(mappedBy = "suserid")
    public Set<Userright> getUserrights() {
        return userrights;
    }

    public void setUserrights(Set<Userright> userrights) {
        this.userrights = userrights;
    }

}
package com.accounts.AccountsAPI.Rustam;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "RIGHTS")
public class Right implements Serializable {
    private static final long serialVersionUID = -9191621249891940731L;
    private Long id;

    private String rName;

    private Set<Userright> userrights = new LinkedHashSet<>();

    @Id
    @Column(name = "R_ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
    }

    @OneToMany(mappedBy = "r")
    public Set<Userright> getUserrights() {
        return userrights;
    }

    public void setUserrights(Set<Userright> userrights) {
        this.userrights = userrights;
    }

}
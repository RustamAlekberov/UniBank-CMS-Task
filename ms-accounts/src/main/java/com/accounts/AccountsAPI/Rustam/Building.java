package com.accounts.AccountsAPI.Rustam;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "BUILDINGS")
public class Building implements Serializable {
    private static final long serialVersionUID = 9102426015479657031L;
    private Long id;

    private String binanum;

    private Long projectid;

    private Set<Userright> userrights = new LinkedHashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDBLD", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "BINANUM", length = 40)
    public String getBinanum() {
        return binanum;
    }

    public void setBinanum(String binanum) {
        this.binanum = binanum;
    }

    @Column(name = "PROJECTID")
    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    @OneToMany(mappedBy = "bld")
    public Set<Userright> getUserrights() {
        return userrights;
    }

    public void setUserrights(Set<Userright> userrights) {
        this.userrights = userrights;
    }

}
package com.accounts.AccountsAPI.Rustam;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Building} entity
 */
public class BuildingDto implements Serializable {
    private final Long id;
    private final String binanum;
    private final Long projectid;

    public BuildingDto(Long id, String binanum, Long projectid) {
        this.id = id;
        this.binanum = binanum;
        this.projectid = projectid;
    }

    public Long getId() {
        return id;
    }

    public String getBinanum() {
        return binanum;
    }

    public Long getProjectid() {
        return projectid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildingDto entity = (BuildingDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.binanum, entity.binanum) &&
                Objects.equals(this.projectid, entity.projectid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, binanum, projectid);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "binanum = " + binanum + ", " +
                "projectid = " + projectid + ")";
    }
}
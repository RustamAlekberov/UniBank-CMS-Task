package com.accounts.AccountsAPI.Rustam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {
    private static final long serialVersionUID = 3708147279963702242L;
    private Integer id;

    private Integer kliId;

    private Integer opId;

    private String accNo;

    private Short valAcc;

    private String name;

    private LocalDate openDat;

    private LocalDate closeDat;

    private Integer balCn1;

    private Integer balCn2;

    private Integer balCn3;

    private Integer balCn4;

    private Short filial;

    private Integer simOtcet;

    private String tipacc;

    private Long limit;

    private String oldAccNo;

    private Integer pairAcc;

    private String insider;

    private Long sid;

    private Long tempid;

    private Long ownid;

    private Integer pCustid;

    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "KLI_ID")
    public Integer getKliId() {
        return kliId;
    }

    public void setKliId(Integer kliId) {
        this.kliId = kliId;
    }

    @Column(name = "OP_ID")
    public Integer getOpId() {
        return opId;
    }

    public void setOpId(Integer opId) {
        this.opId = opId;
    }

    @Column(name = "ACC_NO", length = 20)
    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    @Column(name = "VAL_ACC")
    public Short getValAcc() {
        return valAcc;
    }

    public void setValAcc(Short valAcc) {
        this.valAcc = valAcc;
    }

    @Column(name = "NAME", length = 90)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "OPEN_DAT")
    public LocalDate getOpenDat() {
        return openDat;
    }

    public void setOpenDat(LocalDate openDat) {
        this.openDat = openDat;
    }

    @Column(name = "CLOSE_DAT")
    public LocalDate getCloseDat() {
        return closeDat;
    }

    public void setCloseDat(LocalDate closeDat) {
        this.closeDat = closeDat;
    }

    @Column(name = "BAL_CN1")
    public Integer getBalCn1() {
        return balCn1;
    }

    public void setBalCn1(Integer balCn1) {
        this.balCn1 = balCn1;
    }

    @Column(name = "BAL_CN2")
    public Integer getBalCn2() {
        return balCn2;
    }

    public void setBalCn2(Integer balCn2) {
        this.balCn2 = balCn2;
    }

    @Column(name = "BAL_CN3")
    public Integer getBalCn3() {
        return balCn3;
    }

    public void setBalCn3(Integer balCn3) {
        this.balCn3 = balCn3;
    }

    @Column(name = "BAL_CN4")
    public Integer getBalCn4() {
        return balCn4;
    }

    public void setBalCn4(Integer balCn4) {
        this.balCn4 = balCn4;
    }

    @Column(name = "FILIAL")
    public Short getFilial() {
        return filial;
    }

    public void setFilial(Short filial) {
        this.filial = filial;
    }

    @Column(name = "SIM_OTCET")
    public Integer getSimOtcet() {
        return simOtcet;
    }

    public void setSimOtcet(Integer simOtcet) {
        this.simOtcet = simOtcet;
    }

    @Column(name = "TIPACC", length = 20)
    public String getTipacc() {
        return tipacc;
    }

    public void setTipacc(String tipacc) {
        this.tipacc = tipacc;
    }

    @Column(name = "LIMIT")
    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    @Column(name = "OLD_ACC_NO", length = 20)
    public String getOldAccNo() {
        return oldAccNo;
    }

    public void setOldAccNo(String oldAccNo) {
        this.oldAccNo = oldAccNo;
    }

    @Column(name = "PAIR_ACC")
    public Integer getPairAcc() {
        return pairAcc;
    }

    public void setPairAcc(Integer pairAcc) {
        this.pairAcc = pairAcc;
    }

    @Column(name = "INSIDER", length = 1)
    public String getInsider() {
        return insider;
    }

    public void setInsider(String insider) {
        this.insider = insider;
    }

    @Column(name = "\"SID#\"")
    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    @Column(name = "TEMPID")
    public Long getTempid() {
        return tempid;
    }

    public void setTempid(Long tempid) {
        this.tempid = tempid;
    }

    @Column(name = "OWNID")
    public Long getOwnid() {
        return ownid;
    }

    public void setOwnid(Long ownid) {
        this.ownid = ownid;
    }

    public Integer getPCustid() {
        return pCustid;
    }

    public void setPCustid(Integer pCustid) {
        this.pCustid = pCustid;
    }

}
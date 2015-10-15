/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.cody.cbt.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author satochuu
 */
@Entity
@Table(name = "ACCOUNT_KANRI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountKanri.findAll", query = "SELECT a FROM AccountKanri a"),
    @NamedQuery(name = "AccountKanri.findById", query = "SELECT a FROM AccountKanri a WHERE a.id = :id"),
    @NamedQuery(name = "AccountKanri.findByUserCd", query = "SELECT a FROM AccountKanri a WHERE a.userCd = :userCd"),
    @NamedQuery(name = "AccountKanri.findLikeUserCd", query = "SELECT a FROM AccountKanri a WHERE a.userCd like :userCd"),
    @NamedQuery(name = "AccountKanri.findByPassword", query = "SELECT a FROM AccountKanri a WHERE a.password = :password")})
public class AccountKanri implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "USER_CD")
    private String userCd;
    @Size(max = 256)
    @Column(name = "PASSWORD")
    private String password;
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "account_group",
            joinColumns = {
                @JoinColumn(name = "account_id", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "group_id", referencedColumnName = "ID")}
    )
    private List<GroupKanri> groupList;

    public AccountKanri() {
    }

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "account_group",
            joinColumns = {
                @JoinColumn(name = "account_id", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "group_id", referencedColumnName = "ID")}
    )

    public List<GroupKanri> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupKanri> groupList) {
        this.groupList = groupList;
    }

    public AccountKanri(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getUserCd() {
        return userCd;
    }

    public void setUserCd(String userCd) {
        this.userCd = userCd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountKanri)) {
            return false;
        }
        AccountKanri other = (AccountKanri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AccountKanri[ id=" + id + " ]";
    }

}

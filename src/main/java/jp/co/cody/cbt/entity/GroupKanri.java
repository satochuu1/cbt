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
import javax.persistence.FetchType;
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
@Table(name = "GROUP_KANRI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupKanri.findAll", query = "SELECT g FROM GroupKanri g"),
    @NamedQuery(name = "GroupKanri.findById", query = "SELECT g FROM GroupKanri g WHERE g.id = :id"),
    @NamedQuery(name = "GroupKanri.findByGroupCd", query = "SELECT g FROM GroupKanri g WHERE g.groupCd = :groupCd"),
    @NamedQuery(name = "GroupKanri.findByGroupNm", query = "SELECT g FROM GroupKanri g WHERE g.groupNm = :groupNm")})
public class GroupKanri implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "GROUP_CD")
    private String groupCd;
    @Size(max = 50)
    @Column(name = "GROUP_NM")
    private String groupNm;
    
    @ManyToMany(mappedBy="groupList")
    private List<AccountKanri> accountList;

    public List<AccountKanri> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<AccountKanri> accountList) {
        this.accountList = accountList;
    }
    
    public GroupKanri() {
    }

    public GroupKanri(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getGroupCd() {
        return groupCd;
    }

    public void setGroupCd(String groupCd) {
        this.groupCd = groupCd;
    }

    public String getGroupNm() {
        return groupNm;
    }

    public void setGroupNm(String groupNm) {
        this.groupNm = groupNm;
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
        if (!(object instanceof GroupKanri)) {
            return false;
        }
        GroupKanri other = (GroupKanri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GroupKanri[ id=" + id + " ]";
    }
    
}

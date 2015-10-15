/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.cody.cbt.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "SEVEN_COLAM_KIBUN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SevenColamKibun.findAll", query = "SELECT s FROM SevenColamKibun s"),
    @NamedQuery(name = "SevenColamKibun.findByKibunId", query = "SELECT s FROM SevenColamKibun s WHERE s.kibunId = :kibunId"),
    @NamedQuery(name = "SevenColamKibun.findByNo", query = "SELECT s FROM SevenColamKibun s WHERE s.no = :no"),
    @NamedQuery(name = "SevenColamKibun.findByKanjoNm", query = "SELECT s FROM SevenColamKibun s WHERE s.kanjoNm = :kanjoNm"),
    @NamedQuery(name = "SevenColamKibun.findByPersent", query = "SELECT s FROM SevenColamKibun s WHERE s.persent = :persent")})
public class SevenColamKibun implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "KIBUN_ID")
    private Integer kibunId;
    @Column(name = "NO")
    private Integer no;
    @Size(max = 50)
    @Column(name = "KANJO_NM")
    private String kanjoNm;
    @Column(name = "PERSENT")
    private Short persent;

    public SevenColamKibun() {
    }

    public SevenColamKibun(Integer kibunId) {
        this.kibunId = kibunId;
    }

    public Integer getKibunId() {
        return kibunId;
    }

    public void setKibunId(Integer kibunId) {
        this.kibunId = kibunId;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getKanjoNm() {
        return kanjoNm;
    }

    public void setKanjoNm(String kanjoNm) {
        this.kanjoNm = kanjoNm;
    }

    public Short getPersent() {
        return persent;
    }

    public void setPersent(Short persent) {
        this.persent = persent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kibunId != null ? kibunId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SevenColamKibun)) {
            return false;
        }
        SevenColamKibun other = (SevenColamKibun) object;
        if ((this.kibunId == null && other.kibunId != null) || (this.kibunId != null && !this.kibunId.equals(other.kibunId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.cody.cbt.entity.SevenColamKibun[ kibunId=" + kibunId + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.cody.cbt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author satochuu
 */
@Entity
@Table(name = "SEVEN_COLAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SevenColam.findAll", query = "SELECT s FROM SevenColam s"),
    @NamedQuery(name = "SevenColam.findById", query = "SELECT s FROM SevenColam s WHERE s.id = :id"),
    @NamedQuery(name = "SevenColam.findByLikeId", query = "SELECT s FROM SevenColam s WHERE s.id like :id"),
    @NamedQuery(name = "SevenColam.findByTitle", query = "SELECT s FROM SevenColam s WHERE s.title = :title"),
    @NamedQuery(name = "SevenColam.findByLikeTitle", query = "SELECT s FROM SevenColam s WHERE s.title like :title"),
    @NamedQuery(name = "SevenColam.findByJokyo", query = "SELECT s FROM SevenColam s WHERE s.jokyo = :jokyo"),
    @NamedQuery(name = "SevenColam.findByJidoShiko", query = "SELECT s FROM SevenColam s WHERE s.jidoShiko = :jidoShiko"),
    @NamedQuery(name = "SevenColam.findByBeforeKibunId", query = "SELECT s FROM SevenColam s WHERE s.beforeKibunId = :beforeKibunId"),
    @NamedQuery(name = "SevenColam.findByTekioShiko", query = "SELECT s FROM SevenColam s WHERE s.tekioShiko = :tekioShiko"),
    @NamedQuery(name = "SevenColam.findByHansho", query = "SELECT s FROM SevenColam s WHERE s.hansho = :hansho"),
    @NamedQuery(name = "SevenColam.findByAfterKibunId", query = "SELECT s FROM SevenColam s WHERE s.afterKibunId = :afterKibunId"),
    @NamedQuery(name = "SevenColam.findByBiko", query = "SELECT s FROM SevenColam s WHERE s.biko = :biko"),
    @NamedQuery(name = "SevenColam.findByUpdateYmd", query = "SELECT s FROM SevenColam s WHERE s.updateYmd = :updateYmd")})
public class SevenColam implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(max = 100)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 1000)
    @Column(name = "JOKYO")
    private String jokyo;
    @Size(max = 1000)
    @Column(name = "JIDO_SHIKO")
    private String jidoShiko;
    @Column(name = "BEFORE_KIBUN_ID")
    private Integer beforeKibunId;
    @Size(max = 1000)
    @Column(name = "TEKIO_SHIKO")
    private String tekioShiko;
    @Size(max = 1000)
    @Column(name = "HANSHO")
    private String hansho;
    @Column(name = "AFTER_KIBUN_ID")
    private Integer afterKibunId;
    @Size(max = 1000)
    @Column(name = "BIKO")
    private String biko;
    @Column(name = "UPDATE_YMD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateYmd;
    /*
    @OneToMany
    @JoinTable
    (
      name="before_kibun",
      joinColumns = {@JoinColumn(name="before_kibun_id", referencedColumnName="before_kibun_id")},
      inverseJoinColumns = {@JoinColumn(name="kibun_id", referencedColumnName="kibun_id")}
    )
    private List<SevenColamKibun> beforeKibnList;
    
    @OneToMany
    @JoinTable
    (
      name="after_kibun",
      joinColumns = {@JoinColumn(name="after_kibun_id", referencedColumnName="after_kibun_id")},
      inverseJoinColumns = {@JoinColumn(name="kibun_id", referencedColumnName="kibun_id")}
    )
    private List<SevenColamKibun> afterKibnList;
*/
    public SevenColam() {
    }

    public SevenColam(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJokyo() {
        return jokyo;
    }

    public void setJokyo(String jokyo) {
        this.jokyo = jokyo;
    }

    public String getJidoShiko() {
        return jidoShiko;
    }

    public void setJidoShiko(String jidoShiko) {
        this.jidoShiko = jidoShiko;
    }

    public Integer getBeforeKibunId() {
        return beforeKibunId;
    }

    public void setBeforeKibunId(Integer beforeKibunId) {
        this.beforeKibunId = beforeKibunId;
    }

    public String getTekioShiko() {
        return tekioShiko;
    }

    public void setTekioShiko(String tekioShiko) {
        this.tekioShiko = tekioShiko;
    }

    public String getHansho() {
        return hansho;
    }

    public void setHansho(String hansho) {
        this.hansho = hansho;
    }

    public Integer getAfterKibunId() {
        return afterKibunId;
    }

    public void setAfterKibunId(Integer afterKibunId) {
        this.afterKibunId = afterKibunId;
    }

    public String getBiko() {
        return biko;
    }

    public void setBiko(String biko) {
        this.biko = biko;
    }

    public Date getUpdateYmd() {
        return updateYmd;
    }

    public void setUpdateYmd(Date updateYmd) {
        this.updateYmd = updateYmd;
    }
/*
    public List<SevenColamKibun> getBeforeKibnList() {
        return beforeKibnList;
    }

    public void setBeforeKibnList(List<SevenColamKibun> beforeKibnList) {
        this.beforeKibnList = beforeKibnList;
    }

    public List<SevenColamKibun> getAfterKibnList() {
        return afterKibnList;
    }

    public void setAfterKibnList(List<SevenColamKibun> afterKibnList) {
        this.afterKibnList = afterKibnList;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SevenColam)) {
            return false;
        }
        SevenColam other = (SevenColam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.cody.cbt.entity.SevenColam[ id=" + id + " ]";
    }
    
}

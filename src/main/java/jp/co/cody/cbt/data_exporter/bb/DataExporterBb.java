/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.cody.cbt.data_exporter.bb;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import jp.co.cody.cbt.entity.SevenColam;
import jp.co.cody.cbt.seven_colam.ejb.SevenColamFacade;
import jp.co.cody.cbt.util.qualifier.LogQualifier;

/**
 *
 * @author satochuu
 */
@Named
//@RequestScoped
@ViewScoped
public class DataExporterBb implements Serializable{
    
    //@Inject @LogQualifier(value=0)
   // Logger log;
    @Inject 
    SevenColamFacade scf;
    private List<SevenColam> sevenColamList;
    private String id;
    String test="aaaa";

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    /**
     * Creates a new instance of TestLog
     */
    public DataExporterBb() {
    }
    @PostConstruct
    public void seachAll() {
        sevenColamList = scf.findAll();
    }
    
    public void seachId() {
        sevenColamList = scf.findLikeUserCd(id);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SevenColam> getSevenColamList() {
        return sevenColamList;
    }

    public void setSevenColamList(List<SevenColam> sevenColamList) {
        this.sevenColamList = sevenColamList;
    }
}

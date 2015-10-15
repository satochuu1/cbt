/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.cody.cbt.seven_colam.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jp.co.cody.cbt.entity.SevenColamKibun;

/**
 *
 * @author satochuu
 */
@Stateless
public class SevenColamKibunFacade extends AbstractFacade<SevenColamKibun> {
    @PersistenceContext(unitName = "CBT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SevenColamKibunFacade() {
        super(SevenColamKibun.class);
    }
    
}

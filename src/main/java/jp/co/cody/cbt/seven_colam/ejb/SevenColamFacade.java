/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.cody.cbt.seven_colam.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jp.co.cody.cbt.entity.SevenColam;

/**
 *
 * @author satochuu
 */
@Stateless
public class SevenColamFacade extends AbstractFacade<SevenColam> {
    @PersistenceContext(unitName = "CBT_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SevenColamFacade() {
        super(SevenColam.class);
    }
    
    public List<SevenColam> findLikeUserCd(String title) {
        Query q = em.createNamedQuery("SevenColam.findByLikeTitle") 
                .setParameter("title", "%"+title+"%");
        return q.getResultList();
    }
    
}

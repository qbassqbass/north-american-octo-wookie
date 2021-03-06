/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.FinalCommission;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jakub
 */
@Stateless
public class FinalCommissionFacade extends AbstractFacade<FinalCommission> {
    @PersistenceContext(unitName = "EnterpriseApplication1-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FinalCommissionFacade() {
        super(FinalCommission.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import ENTIDADES.DetalleBiblioFacu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MARCIAELIZABETH
 */
@Stateless
public class DetalleBiblioFacuFacade extends AbstractFacade<DetalleBiblioFacu> {

    @PersistenceContext(unitName = "BIBLIOTECA_APPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleBiblioFacuFacade() {
        super(DetalleBiblioFacu.class);
    }
    
}

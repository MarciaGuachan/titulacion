/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import ENTIDADES.Facultad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MARCIAELIZABETH
 */
@Stateless
public class FacultadFacade extends AbstractFacade<Facultad> {

    @PersistenceContext(unitName = "BIBLIOTECAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacultadFacade() {
        super(Facultad.class);
    }
    
}

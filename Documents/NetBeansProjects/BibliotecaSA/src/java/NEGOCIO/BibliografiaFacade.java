/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import ENTIDADES.Bibliografia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MARCIAELIZABETH
 */
@Stateless
public class BibliografiaFacade extends AbstractFacade<Bibliografia> {

    @PersistenceContext(unitName = "BibliotecaSAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BibliografiaFacade() {
        super(Bibliografia.class);
    }
    
}

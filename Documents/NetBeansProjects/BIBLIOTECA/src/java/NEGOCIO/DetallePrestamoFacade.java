/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import ENTIDADES.DetallePrestamo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MARCIAELIZABETH
 */
@Stateless
public class DetallePrestamoFacade extends AbstractFacade<DetallePrestamo> {

    @PersistenceContext(unitName = "BIBLIOTECAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallePrestamoFacade() {
        super(DetallePrestamo.class);
    }
    
}

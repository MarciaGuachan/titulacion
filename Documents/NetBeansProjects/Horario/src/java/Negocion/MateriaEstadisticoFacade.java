/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocion;

import Entidades.MateriaEstadistico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MARCIAELIZABETH
 */
@Stateless
public class MateriaEstadisticoFacade extends AbstractFacade<MateriaEstadistico> {

    @PersistenceContext(unitName = "HorarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaEstadisticoFacade() {
        super(MateriaEstadistico.class);
    }
    
}

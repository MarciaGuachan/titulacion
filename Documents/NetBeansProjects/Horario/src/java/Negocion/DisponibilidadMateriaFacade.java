/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocion;

import Entidades.DisponibilidadMateria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MARCIAELIZABETH
 */
@Stateless
public class DisponibilidadMateriaFacade extends AbstractFacade<DisponibilidadMateria> {

    @PersistenceContext(unitName = "HorarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DisponibilidadMateriaFacade() {
        super(DisponibilidadMateria.class);
    }
    
}

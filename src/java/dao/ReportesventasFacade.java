/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Reportesventas;

/**
 *
 * @author victo
 */
@Stateless
public class ReportesventasFacade extends AbstractFacade<Reportesventas> {

    @PersistenceContext(unitName = "ProyectoG3_v4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReportesventasFacade() {
        super(Reportesventas.class);
    }
    
}

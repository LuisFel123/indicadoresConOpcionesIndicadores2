/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Medida;
import modelo.Persona;

/**
 *
 * @author felip
 */
@Stateless
public class MedidaFacade extends AbstractFacade<Medida> {

    @PersistenceContext(unitName = "indicadores02-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedidaFacade() {
        super(Medida.class);
    }

    public List<Medida> medidas(Persona p) {
        List<Medida> medidas = null;
        try {
            Query consultamp = em.createNamedQuery("Medida.findByIdpersona");
            consultamp.setParameter("idPersona", p.getIdPersona());
            medidas = (List<Medida>) consultamp.getResultList();
        } catch (Exception ex) {
            return null;
        }
        return medidas;
    }

}

/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */


package entitites;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class EmployeesFacade extends AbstractFacade<Employees> implements EmployeesFacadeLocal {
    @PersistenceContext(unitName = "FinalTestCSWPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeesFacade() {
        super(Employees.class);
    }

    @Override
    public Employees checkLogin(String id, String password) {
        javax.persistence.Query q = em.createNamedQuery("Employees.checkLogin");
        q.setParameter(1, id);
        q.setParameter(2, password);
        return (Employees) q.getSingleResult();
    }

    
}

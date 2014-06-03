package gerenciadordeprovas;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Cristiano
 */
public class GerenciadorDeProvas {

    public static void main(String[] args) {
        Questao q1 = new Questao();
        q1.setEnunciado("Qual a idade de Cristo quando crucificado?");
        q1.addAlternativaErrada(new Alternativa("32"));
        q1.addAlternativaErrada(new Alternativa("23"));
        q1.addAlternativaErrada(new Alternativa("22"));
        q1.addAlternativaErrada(new Alternativa("43"));
        q1.setAlternativaCorreta(new Alternativa("33"));
        try {
            EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("GerenciadorDeProvasPU");
            EntityManager em = managerFactory.createEntityManager();
            EntityTransaction eTrans = em.getTransaction();
            eTrans.begin();
            em.persist(q1);
            eTrans.commit();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Questao> cq = cb.createQuery(Questao.class);
            TypedQuery tq = em.createQuery(cq);
            List<Questao> result = tq.getResultList();
            for (Questao result1 : result) {
                System.out.println(result1.toString());
            }
//            CriteriaQuery<Alternativa> cqa = cb.createQuery(Alternativa.class);
//            tq = em.createQuery(cqa);
//            List<Alternativa> alts = tq.getResultList();
//            for(Alternativa al : alts){
//                System.out.println(al);
//            }
            em.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

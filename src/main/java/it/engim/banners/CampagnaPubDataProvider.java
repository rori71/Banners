

package it.engim.banners;

import it.engim.banners.db.CampagnaPub;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

/**
 *
 * @author xamp
 */
public class CampagnaPubDataProvider extends SortableDataProvider<CampagnaPub, String>
{

    @Override
    public Iterator<? extends CampagnaPub> iterator(long first, long count)
    {
        EntityManager em = WicketApplication.instance().getDB();
        try
        {
            Query q= em.createNamedQuery("CampagnaPub.findAll");
            q.setFirstResult((int)first).setMaxResults((int)count);
            List <CampagnaPub> result = q.getResultList();
            return result.iterator();
            
        }finally{
            em.close();
        }
    }

    @Override
    public long size()
    {
        EntityManager em = WicketApplication.instance().getDB();
        try
        {
            CriteriaBuilder cb= em.getCriteriaBuilder();
            CriteriaQuery<Long> cq= cb.createQuery(Long.class);
            Root<CampagnaPub> root = cq.from(CampagnaPub.class);
            cq.select(cb.count(root));
            return em.createQuery(cq).getSingleResult();
        }
        finally
        {
           em.close(); 
        }
        
    }

    @Override
    public IModel<CampagnaPub> model(CampagnaPub object)
    {
        return new CampagnaPubModel(object);
    }
    
}
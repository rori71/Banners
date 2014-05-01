

package it.engim.banners;

import it.engim.banners.db.Banner;
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
 * @author rori
 */
public class BannerDataProvider extends SortableDataProvider<Banner, String>
{

    @Override
    public Iterator<? extends Banner> iterator(long first, long count)
    {
        EntityManager em = WicketApplication.instance().getDB();
        try
        {
            Query q= em.createNamedQuery("Banner.findAll");
            q.setFirstResult((int)first).setMaxResults((int)count);
            List <Banner> result = q.getResultList();
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
            Root<Banner> root = cq.from(Banner.class);
            cq.select(cb.count(root));
            return em.createQuery(cq).getSingleResult();
        }
        finally
        {
           em.close(); 
        }
        
    }

    @Override
    public IModel<Banner> model(Banner object)
    {
        return new BannerModel(object);
    }
    
}

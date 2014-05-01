

package it.engim.banners;

import it.engim.banners.db.Banner;
import javax.persistence.EntityManager;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author rori
 */
public class BannerModel extends LoadableDetachableModel<Banner>
{
    private int id;
    public BannerModel (Banner b)
    {
        this.id = b.getId();
    }
    
    @Override
    protected Banner load()
    {
        EntityManager em = WicketApplication.instance().getDB();
        try
        {
          return em.find(Banner.class, id);
        }
        finally
        {
            em.close();
        }
    
    }
   
    
}


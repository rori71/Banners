

package it.engim.banners;

import it.engim.banners.db.Inserzione;
import javax.persistence.EntityManager;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author rori
 */
public class InserzioneModel extends LoadableDetachableModel<Inserzione>
{
    private int id;
    public InserzioneModel (Inserzione b)
    {
        this.id = b.getId();
    }
    
    @Override
    protected Inserzione load()
    {
        EntityManager em = WicketApplication.instance().getDB();
        try
        {
          return em.find(Inserzione.class, id);
        }
        finally
        {
            em.close();
        }
    
    }
   
    
}


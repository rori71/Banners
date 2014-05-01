package it.engim.banners;

import it.engim.banners.db.TariffaInserzione;
import javax.persistence.EntityManager;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author rori
 */
public class TariffaInserzioneModel extends LoadableDetachableModel<TariffaInserzione>
{
    private int id;
    public TariffaInserzioneModel (TariffaInserzione b)
    {
        this.id = b.getId();
    }
    
    @Override
    protected TariffaInserzione load()
    {
        EntityManager em = WicketApplication.instance().getDB();
        try
        {
          return em.find(TariffaInserzione.class, id);
        }
        finally
        {
            em.close();
        }
    
    }
   
    
}
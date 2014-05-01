/*
 * Copyright 2014 xamp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.engim.banners;

import it.engim.banners.db.TariffaInserzione;
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
public class TariffaInserzioneDataProvider extends SortableDataProvider<TariffaInserzione, String>
{

    @Override
    public Iterator<? extends TariffaInserzione> iterator(long first, long count)
    {
        EntityManager em = WicketApplication.instance().getDB();
        try
        {
            Query q= em.createNamedQuery("TariffaInserzione.findAll");
            q.setFirstResult((int)first).setMaxResults((int)count);
            List <TariffaInserzione> result = q.getResultList();
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
            Root<TariffaInserzione> root = cq.from(TariffaInserzione.class);
            cq.select(cb.count(root));
            return em.createQuery(cq).getSingleResult();
        }
        finally
        {
           em.close(); 
        }
        
    }

    @Override
    public IModel<TariffaInserzione> model(TariffaInserzione object)
    {
        return new TariffaInserzioneModel(object);
    }
    
}
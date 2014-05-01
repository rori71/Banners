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

import it.engim.banners.db.CampagnaPub;
import it.engim.banners.db.Inserzione;
import it.engim.banners.db.TariffaInserzione;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author xamp
 */
class TariffaInserzioneDao
{

    public static TariffaInserzione calcolaTariffaMigliore(CampagnaPub cp)
    {
        EntityManager em = WicketApplication.instance().getDB();
        try
        {
            Query q= em.createNamedQuery("TariffaInserzione.findBest");
            Float area = calcolaArea(cp, em);
            q.setParameter("area",area);
            q.setMaxResults(1);
            List<TariffaInserzione> result = q.getResultList();
            return result.get(0);
        } 
        finally
        {
            em.close();
        }
    }
    public static Float calcolaArea(CampagnaPub cp, EntityManager em)
    {
        cp = em.find(cp.getClass(), cp.getId());
        Collection<Inserzione> inslist = cp.getInserzioneCollection();
        float areaTotale=0;
        for(Inserzione i: inslist)
        {
            areaTotale += i.getNumeroPagine()*i.getIdBanner().getArea();
        }
        return areaTotale;
    }
}

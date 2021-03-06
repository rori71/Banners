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
import javax.persistence.EntityManager;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author xamp
 */
public class CampagnaPubModel extends LoadableDetachableModel<CampagnaPub>
{
    private int id;
    public CampagnaPubModel (CampagnaPub b)
    {
        this.id = b.getId();
    }
    
    @Override
    protected CampagnaPub load()
    {
        EntityManager em = WicketApplication.instance().getDB();
        try
        {
          return em.find(CampagnaPub.class, id);
        }
        finally
        {
            em.close();
        }
    
    }
   
    
}
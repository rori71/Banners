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

import it.engim.banners.db.Banner;
import java.util.ArrayList;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

/**
 *
 * @author xamp
 */
public class ElencoBanner extends WebPage
{

    public ElencoBanner()
    {
        ArrayList<IColumn<Banner, String>> colonne = new ArrayList <IColumn<Banner, String>>();
        colonne.add(new PropertyColumn<Banner, String>(Model.of("Codice"), "codice"));
        colonne.add(new PropertyColumn<Banner, String>(Model.of("Descrizione"), "descrizione"));
        colonne.add(new PropertyColumn<Banner, String>(Model.of("Area"), "area"));
        add(new DefaultDataTable<Banner, String>("banners", colonne, new BannerDataProvider(),11));
    
            Link homepage =new Link ("homepage")
                {

                    @Override
                    public void onClick()
                    {
                        throw new RestartResponseException(HomePage.class);
                    }
                   
                };
                add(homepage);
    }
}
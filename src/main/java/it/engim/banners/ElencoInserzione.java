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

import it.engim.banners.db.Inserzione;
import java.util.ArrayList;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author xamp
 */
public class ElencoInserzione extends WebPage
{

    public ElencoInserzione()
    {
        ArrayList<IColumn<Inserzione, String>> colonne = new ArrayList <IColumn<Inserzione, String>>();
        colonne.add(new AbstractColumn<Inserzione, String>(Model.of("Campagna"))  {

            @Override
            public void populateItem(Item<ICellPopulator<Inserzione>> cellItem, String componentId, IModel<Inserzione> rowModel)
            {
               String nome = rowModel.getObject().getIdCampagnaPub().getNome();//prendo il nome della campagna
               Label l = new Label(componentId,nome);//label è l'oggetto che contiene le stringhe
               cellItem.add(l);//incollo la stringa nella pagina
            }
        });
        colonne.add(new PropertyColumn<Inserzione, String>(Model.of("Banner"), "idBanner"));//visualizzato con il metodo toString
        //per esercizio richiamo il banner con abstractColumn
        colonne.add(new AbstractColumn<Inserzione, String>(Model.of("Banner")) {

            @Override
            public void populateItem(Item<ICellPopulator<Inserzione>> cellItem, String componentId, IModel<Inserzione> rowModel)
            {
               String codice = rowModel.getObject().getIdBanner().getCodice();
               Label l = new Label(componentId,codice);
               cellItem.add(l);
            }
        });
        colonne.add(new PropertyColumn<Inserzione, String>(Model.of("Pagine"), "numeroPagine"));
        add(new DefaultDataTable<Inserzione, String>("inserzione", colonne, new InserzioneDataProvider(),11));
    
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
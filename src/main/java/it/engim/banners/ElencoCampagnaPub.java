

package it.engim.banners;

import it.engim.banners.db.CampagnaPub;
import it.engim.banners.db.Inserzione;
import it.engim.banners.db.TariffaInserzione;
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
public class ElencoCampagnaPub extends WebPage
{

    public ElencoCampagnaPub()
    {
        ArrayList<IColumn<CampagnaPub, String>> colonne = new ArrayList <IColumn<CampagnaPub, String>>();
        colonne.add(new PropertyColumn<CampagnaPub, String>(Model.of("Nome"), "nome"));
        colonne.add(new AbstractColumn<CampagnaPub, String>(Model.of("Migliore")) {

            @Override
            public void populateItem(Item<ICellPopulator<CampagnaPub>> cellItem, String componentId, IModel<CampagnaPub> rowModel)
            {
                TariffaInserzione migliore = TariffaInserzioneDao.calcolaTariffaMigliore(rowModel.getObject());
                float prezzo=migliore.getCosto();
                String testata = migliore.getNomeTestata();
                String tariffa = migliore.getNomeTariffa();
                String testo = "€"+prezzo+"("+testata+" "+tariffa+")";
                Label l = new Label(componentId,testo);
                cellItem.add(l);
            }
        });
        add(new DefaultDataTable<CampagnaPub, String>("campagnapub", colonne, new CampagnaPubDataProvider(),11));
    
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
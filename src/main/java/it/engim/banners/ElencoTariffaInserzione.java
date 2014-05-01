package it.engim.banners;

import it.engim.banners.db.TariffaInserzione;
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
public class ElencoTariffaInserzione extends WebPage
{

    public ElencoTariffaInserzione()
    {
        ArrayList<IColumn<TariffaInserzione, String>> colonne = new ArrayList <IColumn<TariffaInserzione, String>>();
        colonne.add(new PropertyColumn<TariffaInserzione, String>(Model.of("Nome testata"), "nomeTestata"));
        colonne.add(new PropertyColumn<TariffaInserzione, String>(Model.of("Nome tariffa"), "nomeTariffa"));
        colonne.add(new PropertyColumn<TariffaInserzione, String>(Model.of("Area massima"), "areaMassima"));
        colonne.add(new PropertyColumn<TariffaInserzione, String>(Model.of("Costo"), "costo"));
        add(new DefaultDataTable<TariffaInserzione, String>("tariffainserzione", colonne, new TariffaInserzioneDataProvider(),11));
    
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

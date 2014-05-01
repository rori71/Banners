package it.engim.banners;


import org.apache.wicket.RestartResponseException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		

		Link banners =new Link ("banners")
                {

                    @Override
                    public void onClick()
                    {
                        throw new RestartResponseException(ElencoBanner.class);
                    }
                   
                };
                add(banners);
                Link campagnapub =new Link ("campagnapub")
                {

                    @Override
                    public void onClick()
                    {
                        throw new RestartResponseException(ElencoCampagnaPub.class);
                    }
                   
                };
                add(campagnapub);
                
                Link elencotariffa =new Link ("tariffainserzione")
                {

                    @Override
                    public void onClick()
                    {
                        throw new RestartResponseException(ElencoTariffaInserzione.class);
                    }
                   
                };
                add(elencotariffa);
                
                Link inserzione =new Link ("inserzione")
                {

                    @Override
                    public void onClick()
                    {
                        throw new RestartResponseException(ElencoInserzione.class);
                    }
                   
                };
                add(inserzione);
                
               
    }
}

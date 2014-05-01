package it.engim.banners;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see it.engim.banners.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	private EntityManagerFactory emf;
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here
	}
        public static WicketApplication instance()//solo un abbreviazione per evitare il cast
        {
            return (WicketApplication)WebApplication.get();
        }
        
        public EntityManager getDB()
        {
            
            if(emf == null)
                {
                    String unit = getInitParameter("MainPUnit");
                    emf = Persistence.createEntityManagerFactory(unit);
            
                }
            return emf.createEntityManager();
        }
}

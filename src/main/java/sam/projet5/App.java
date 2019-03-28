package sam.projet5;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import sam.projet5.config.Config;
import sam.projet5.domain.commande.CommandePopulator;
import sam.projet5.domain.commande.model.CBoutique;
import sam.projet5.domain.organisation.OrganisationPopulator;

@Component
public class App {

    private final static Logger LOGGER = LoggerFactory.getLogger(App.class.getName());

    private OrganisationPopulator organisationPopulator;
    private CommandePopulator commandePopulator;
    private SessionFactory sessionFactory;

    @Autowired
    public App(OrganisationPopulator organisationPopulator, CommandePopulator commandePopulator, SessionFactory sessionFactory){
        this.organisationPopulator = organisationPopulator;
        this.commandePopulator = commandePopulator;
        this.sessionFactory = sessionFactory;
    }

    public static void main(String[] args) {

        LOGGER.info("Start of execution...");

        App app;
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        app = context.getBean(App.class);
        app.service();

        LOGGER.info("End of execution...");

    }

    private void service(){

        organisationPopulator.createData();

        commandePopulator.createData();

        sessionFactory.close();

        System.out.println("Voilà!!!");


    }


    private void populateDomainCommande(){
        CBoutique boutique2 = new CBoutique();

    }


}

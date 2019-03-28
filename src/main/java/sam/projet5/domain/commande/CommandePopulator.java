package sam.projet5.domain.commande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sam.projet5.domain.commande.model.*;
import sam.projet5.domain.commande.repository.*;
import sam.projet5.domain.organisation.model.Boutique;
import sam.projet5.domain.organisation.model.Employe;
import sam.projet5.domain.organisation.repository.BoutiqueRepository;
import sam.projet5.domain.organisation.repository.EmployeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CommandePopulator {

    private BoutiqueRepository boutiqueRepository;
    private EmployeRepository employeRepository;
    private CBoutiqueRepository cboutiqueRepository;
    private ProduitRepository produitRepository;
    private CommandeRepository commandeRepository;
    private ClientRepository clientRepository;
    private FactureRepository factureRepository;
    private LivreurRepository livreurRepository;
    private CuisinierRepository cuisinierRepository;

    @Autowired
    public CommandePopulator(CBoutiqueRepository cboutiqueRepository, BoutiqueRepository boutiqueRepository, ProduitRepository produitRepository, CommandeRepository commandeRepository, ClientRepository clientRepository, FactureRepository factureRepository, EmployeRepository employeRepository, LivreurRepository livreurRepository, CuisinierRepository cuisinierRepository){
        this.cboutiqueRepository = cboutiqueRepository;
        this.boutiqueRepository = boutiqueRepository;
        this.produitRepository = produitRepository;
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
        this.factureRepository = factureRepository;
        this.employeRepository = employeRepository;
        this.livreurRepository = livreurRepository;
        this.cuisinierRepository = cuisinierRepository;
    }

    public void createData(){

        Optional<Boutique> boutique = boutiqueRepository.findByNom("Pizzeria des Halles de Nîmes");
        CBoutique savedCBoutique;
        if (boutique.isPresent()) {
            CBoutique cboutique = new CBoutique();
            cboutique.setBoutique(boutique.get());
            cboutique.setSIRET("12345678901234");
            savedCBoutique = cboutiqueRepository.save(cboutique);
        }
        else{
            throw new RuntimeException("Impossible de créer les données du domaine Commande car une donnée du domaine Organisation est introuvable: boutique 'Pizzeria des Halles de Nîmes");
        }

        Optional<Employe> e1 = employeRepository.findByPrenomAndNom("Marcel", "BELIVEAU");
        Livreur savedLivreur;
        if (e1.isPresent()){
            Livreur livreur = new Livreur();
            livreur.setPrenom("Marcel");
            livreur.setNom("BELIVEAU");
            savedLivreur = livreurRepository.save(livreur);
        }
        else{
            throw new RuntimeException("Impossible de créer les données du domaine Commande car une donnée du domaine Organisation est introuvable: employe Marcel BELIVEAU");
        }

        Optional<Employe> e2 = employeRepository.findByPrenomAndNom("Gérard", "DEPARDIEU");
        Cuisinier savedCuisinier;
        if (e2.isPresent()){
            Cuisinier cuisinier = new Cuisinier();
            cuisinier.setEstMeilleurOuvrierDeFrance(true);
            cuisinier.setNbEtoiles(5);
            cuisinier.setPrenom("Gérard");
            cuisinier.setNom("DEPARDIEU");
            cuisinier.setEmploye(e2.get());
            savedCuisinier = cuisinierRepository.save(cuisinier);
        }
        else{
            throw new RuntimeException("Impossible de créer les données du domaine Commande car une donnée du domaine Organisation est introuvable: employe Gérard DEPARDIEU");
        }

        List<Produit> produits = new ArrayList();
        Produit p1 = new Produit();
        p1.setLibelleCourt("Pizza Végétarienne");
        p1.setLibelleLong("Notre spécialité maison cuisinée à partir de produits frais!");
        p1.setQuantité(2);
        p1.setTypeProduit(ProduitType.ProduitPreparé);
        p1.setPrixUnitaireHT(14.50);
        final Produit savedP1 = produitRepository.save(p1);
        produits.add(savedP1);

        Produit p2 = new Produit();
        p2.setLibelleCourt("Bouteille Evian 50ml");
        p2.setTypeProduit(ProduitType.Boisson);
        p2.setQuantité(1);
        p2.setPrixUnitaireHT(2.80);
        final Produit savedP2 = produitRepository.save(p2);
        produits.add(savedP2);

        Facture facture = new Facture();
        facture.setModeReglement(ModeReglement.EnLigne);
        facture.setMontantHT(2.80+2*14.50);
        final Facture savedFacture = factureRepository.save(facture);

        Commande commande1 = new Commande();
        commande1.setEtat(CommandeStatus.Terminee);
        commande1.setProduits(produits);
        commande1.setFacture(savedFacture);
        commande1.setCboutique(savedCBoutique);
        commande1.setLivreur(savedLivreur);
        commande1.setCuisinier(savedCuisinier);
        final Commande savedCommande1 = commandeRepository.save(commande1);

        List<Commande> commandes = new ArrayList<>();
        commandes.add(savedCommande1);

        Produit produit3 = new Produit();
        produit3.setLibelleCourt("Pizza 4 fromages");
        produit3.setLibelleLong("Délicieuse pizza pour les amateurs de fromages: emmental, gorgonzola, roquefort, chèvre");
        produit3.setPrixUnitaireHT(12.30);
        produit3.setQuantité(1);
        produit3.setTypeProduit(ProduitType.ProduitPreparé);
        final Produit savedP3 = produitRepository.save(produit3);

        Commande commande2 = new Commande();
        commande2.setEtat(CommandeStatus.ALivrer);
        commande2.addProduit(savedP3);
        commande2.setCboutique(savedCBoutique);
        commande2.setCuisinier(savedCuisinier);
        Commande savedCommande2 = commandeRepository.save(commande2);
        commandes.add(savedCommande2);

        Client client = new Client();
        client.setPrenom("Marcel");
        client.setNom("PIGNON");
        client.setCommandes(commandes);
        clientRepository.save(client);

    }
}

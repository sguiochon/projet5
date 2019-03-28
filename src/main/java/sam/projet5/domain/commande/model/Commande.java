package sam.projet5.domain.commande.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List<Produit> produits;

    private Date dateCreation = new Date();
    @Enumerated(value = EnumType.STRING)
    private CommandeStatus etat = CommandeStatus.Enregistree;
    @OneToOne
    private Facture facture;
    @OneToOne
    private CBoutique cboutique;
    @ManyToOne
    private Livreur livreur;
    @ManyToOne
    private Cuisinier cuisinier;

    public Cuisinier getCuisinier() {
        return cuisinier;
    }

    public void setCuisinier(Cuisinier cuisinier) {
        this.cuisinier = cuisinier;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public CBoutique getCboutique() {
        return cboutique;
    }

    public void setCboutique(CBoutique cboutique) {
        this.cboutique = cboutique;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public CommandeStatus getEtat() {
        return etat;
    }

    public void setEtat(CommandeStatus etat) {
        this.etat = etat;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public void addProduit(Produit produit) {
        if (produits == null)
            produits = new ArrayList<Produit>();
        produits.add(produit);
    }
}

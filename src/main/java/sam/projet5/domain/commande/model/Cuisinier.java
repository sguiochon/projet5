package sam.projet5.domain.commande.model;

import sam.projet5.domain.organisation.model.Employe;

import javax.persistence.*;

@Entity
public class Cuisinier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String prenom;
    private String nom;
    private int nbEtoiles;
    private boolean estMeilleurOuvrierDeFrance;

    @OneToOne
    private Employe employe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbEtoiles() {
        return nbEtoiles;
    }

    public void setNbEtoiles(int nbEtoiles) {
        this.nbEtoiles = nbEtoiles;
    }

    public boolean isEstMeilleurOuvrierDeFrance() {
        return estMeilleurOuvrierDeFrance;
    }

    public void setEstMeilleurOuvrierDeFrance(boolean estMeilleurOuvrierDeFrance) {
        this.estMeilleurOuvrierDeFrance = estMeilleurOuvrierDeFrance;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}

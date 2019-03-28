package sam.projet5.domain.commande.model;

import sam.projet5.domain.organisation.model.Employe;

import javax.persistence.*;

@Entity
public class Livreur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String prenom;
    private String nom;
    private String identifiant2Roues;
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

    public String getIdentifiant2Roues() {
        return identifiant2Roues;
    }

    public void setIdentifiant2Roues(String identifiant2Roues) {
        this.identifiant2Roues = identifiant2Roues;
    }
}

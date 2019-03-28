package sam.projet5.domain.organisation.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Boutique {

    @OneToMany(cascade = CascadeType.ALL)
    List<Role> roles = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void addRole(Role role){
        roles.add(role);
    }

}

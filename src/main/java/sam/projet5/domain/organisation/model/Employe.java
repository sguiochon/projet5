package sam.projet5.domain.organisation.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String prenom;
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employe", fetch = FetchType.EAGER)
    //@JoinTable(name="employe_role",
    //        joinColumns = {@JoinColumn(name="employe_id",referencedColumnName = "id")},
    //        inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName = "id")})
    private List<Role> roles;

    public Employe(){}

    public Employe(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

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

    public void addRole(Role role){
        if (roles==null)
            roles = new ArrayList<Role>();
        roles.add(role);
    }

}

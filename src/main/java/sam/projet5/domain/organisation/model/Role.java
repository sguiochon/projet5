package sam.projet5.domain.organisation.model;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleType typeRole;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private VisibilityType typeVisibilite;

    @ManyToOne (cascade = CascadeType.ALL)
    //@JoinTable(name="employe_role",
    //            joinColumns = {@JoinColumn(name="role_id",referencedColumnName = "id")},
    //            inverseJoinColumns = {@JoinColumn(name="employe_id",referencedColumnName = "id")})
    private Employe employe;

    public Role(RoleType role, VisibilityType visibilite, Employe employe) {
        this.typeRole = role;
        this.typeVisibilite = visibilite;
        this.employe = employe;
    }

    public Role(){}

    public Long getId() {
        return id;
    }

    public RoleType getTypeRole() {
        return typeRole;
    }

    public void setTypeRole(RoleType typeRole) {
        this.typeRole = typeRole;
    }

    public VisibilityType getTypeVisibilite() {
        return typeVisibilite;
    }

    public void setTypeVisibilite(VisibilityType typeVisibilite) {
        this.typeVisibilite = typeVisibilite;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}

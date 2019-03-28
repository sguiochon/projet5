package sam.projet5.domain.commande.model;

import javax.persistence.*;

@Entity
public class CBoutique {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @OneToOne
    sam.projet5.domain.organisation.model.Boutique boutique;

    String SIRET;

    public String getSIRET() {
        return SIRET;
    }

    public void setSIRET(String SIRET) {
        this.SIRET = SIRET;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public sam.projet5.domain.organisation.model.Boutique getBoutique() {
        return boutique;
    }

    public void setBoutique(sam.projet5.domain.organisation.model.Boutique boutique) {
        this.boutique = boutique;
    }
}

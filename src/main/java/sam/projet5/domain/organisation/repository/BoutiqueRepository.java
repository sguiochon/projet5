package sam.projet5.domain.organisation.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import sam.projet5.domain.organisation.model.Boutique;

import java.util.Optional;


public interface BoutiqueRepository extends CommunRepository<Boutique, Long> {

    public Optional<Boutique> findByNom(String nom);
}

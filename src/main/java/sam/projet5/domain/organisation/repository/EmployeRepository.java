package sam.projet5.domain.organisation.repository;

import sam.projet5.domain.organisation.model.Employe;

import java.util.Optional;

public interface EmployeRepository extends CommunRepository<Employe, Long> {

    Optional<Employe> findByPrenomAndNom(String prenom, String nom);
}

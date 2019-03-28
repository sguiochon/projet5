package sam.projet5.domain.organisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sam.projet5.domain.organisation.model.*;
import sam.projet5.domain.organisation.repository.BoutiqueRepository;
import sam.projet5.domain.organisation.repository.EmployeRepository;
import sam.projet5.domain.organisation.repository.RoleRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrganisationPopulator {

    private BoutiqueRepository boutiqueRepository;

    private EmployeRepository employeRepository;

    private RoleRepository roleRepository;

    @Autowired
    public OrganisationPopulator(BoutiqueRepository boutiqueRepository, EmployeRepository employeRepository, RoleRepository roleRepository) {
        this.boutiqueRepository = boutiqueRepository;
        this.employeRepository = employeRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void createData() {
        Boutique b = new Boutique();
        b.setNom("Pizzeria des Halles de Nîmes");
        Adresse a1 = new Adresse();
        a1.setAdresse1("3 rue des Lombards");
        a1.setCodePostal("30000");
        a1.setVille("Nîmes");
        a1.setPays("France");
        b.setAdresse(a1);
        Boutique savedB1 = boutiqueRepository.save(b);
        System.out.println("----------- Boutique créée");

        Employe e1 = new Employe("Jean", "VALJEAN");
        Role r1 = new Role(RoleType.Cuisiner, VisibilityType.Boutique, e1);
        e1.addRole(r1);
        Employe savedE1 = employeRepository.save(e1);
        System.out.println("----------- Role1 créé, Employe1 créé");

        for (Role role : savedE1.getRoles()) {
            System.out.println("-----> Role : " + role.getTypeRole());
            savedB1.addRole(role);
        }

        Employe e2 = new Employe("Marcel", "BELIVEAU");
        Role r2 = new Role(RoleType.Livreur, VisibilityType.Boutique, e2);
        e2.addRole(r2);
        Employe savedE2 = employeRepository.save(e2);
        for (Role role : savedE2.getRoles())
            savedB1.addRole(role);

        Employe e3 = new Employe("Denise", "FABRE");
        Role r3 = new Role(RoleType.Comptable, VisibilityType.Enseigne, e3);
        e3.addRole(r3);
        Employe savedE3 = employeRepository.save(e3);
        for (Role role : savedE3.getRoles())
            savedB1.addRole(role);

        Employe e4 = new Employe("Gérard", "DEPARDIEU");
        Role r4 = new Role(RoleType.Logistique, VisibilityType.Boutique, e4);
        Role r5 = new Role(RoleType.Cuisiner, VisibilityType.Boutique, e4);
        e4.addRole(r4);
        e4.addRole(r5);
        Employe savedE4 = employeRepository.save(e4);
        for (Role role : savedE4.getRoles())
            savedB1.addRole(role);

        boutiqueRepository.save(savedB1);
    }
}

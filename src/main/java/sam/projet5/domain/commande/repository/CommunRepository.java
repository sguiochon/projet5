package sam.projet5.domain.commande.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface CommunRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    Optional<T> findById(ID id);

    <S extends T> S save(S entity);

}

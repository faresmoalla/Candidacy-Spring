package pi.app.estatemarket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pi.app.estatemarket.Entities.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {

}

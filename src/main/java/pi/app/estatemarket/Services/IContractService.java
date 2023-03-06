package pi.app.estatemarket.Services;

import pi.app.estatemarket.Entities.Contract;
import pi.app.estatemarket.dto.ContractDTO;

import java.util.List;
import java.util.Optional;

public interface IContractService {
    List<ContractDTO> getAllContracts();
    Contract updateContract(Contract contract);
    void DeleteContract(Integer idC);
   public Contract retrieveContract(Integer idC);
void addaffectContractToUser(Contract contract ,Long userID);
}

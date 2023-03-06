package pi.app.estatemarket.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pi.app.estatemarket.Entities.Contract;
import pi.app.estatemarket.Services.IContractService;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/contract")
@AllArgsConstructor

public class ContractController {

    //@Autowired
    private IContractService iContractService;
@PostMapping("/addaffectContractToUser/{userID}")
    public void addaffectContractToUser( @RequestBody Contract contract, @PathVariable Long userID){
    iContractService.addaffectContractToUser(contract,userID);


    }
@DeleteMapping("/deletecontract/{idC}")
public void DeleteContract( @PathVariable Integer idC){

    iContractService.DeleteContract(idC);
}
@PutMapping("/updatecontract")
public Contract updateContract( @RequestBody Contract contract){

    return iContractService.updateContract(contract);
}
@GetMapping("/affichageducontrat/{idC}")
    public Contract retrieveContract(Integer idC){
    return iContractService.retrieveContract(idC);
    }
}

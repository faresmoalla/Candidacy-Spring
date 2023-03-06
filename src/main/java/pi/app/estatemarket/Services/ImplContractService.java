package pi.app.estatemarket.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pi.app.estatemarket.Entities.Contract;
import pi.app.estatemarket.Entities.User;
import pi.app.estatemarket.Repository.ContractRepository;
import pi.app.estatemarket.Repository.UserRepository;
import pi.app.estatemarket.dto.ContractDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j

public class ImplContractService implements IContractService {
   // @Autowired
    private final ContractRepository contractRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    @Autowired
    JavaMailSender javaMailSender;

    public List<ContractDTO> getAllContracts() {
        List<Contract> contracts = contractRepository.findAll();
        return getAllContracts().stream()
                .map(contract -> modelMapper.map(contract, ContractDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Contract updateContract(Contract contract)
    {
        return contractRepository.save(contract);
    }

    @Override
    public void DeleteContract(Integer idC) {
        contractRepository.deleteById(idC);
    }
    @Override
    public Contract retrieveContract(Integer idC)
    {
        return contractRepository.findById(idC).orElse(null);
    }

    @Override
    public void addaffectContractToUser(Contract contract, Long userID) {
        User user=userRepository.findById(userID).orElse(null);
        contract.setUserContract(user);
        contractRepository.save(contract);
        
         
         		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom("schoolesprit1@gmail.com");
			
			//simpleMailMessage.setTo(user.getEmailAddress());

			simpleMailMessage.setTo("yossr.boushih@esprit.tn");
			simpleMailMessage.setSubject("Vous avez ajouté un nv contrat");
			simpleMailMessage.setText("This is an alert, you have sent a bad word, if you keep sending bad words, you might get banned");
			javaMailSender.send(simpleMailMessage);
         
        
        
        
    }
}
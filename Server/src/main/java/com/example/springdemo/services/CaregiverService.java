package com.example.springdemo.services;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.builders.CaregiverBuilder;
import com.example.springdemo.dto.builders.PatientBuilder;
import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.CaregiverRepository;
import com.example.springdemo.validators.CaregiverFieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CaregiverService implements UserServiceInterface {

    private final CaregiverRepository caregiverRepository;
    private PasswordEncrypter passwordEncrypter;

    @Autowired
    public CaregiverService(PasswordEncrypter passwordEncrypter, CaregiverRepository caregiverRepository) {
        this.passwordEncrypter = passwordEncrypter;
        this.caregiverRepository = caregiverRepository;
    }

    public CaregiverDTO findUserById(Integer id){
        Optional<Caregiver> caregiver  = caregiverRepository.findById(id);

        if (!caregiver.isPresent()) {
            throw new ResourceNotFoundException ("Caregiver", "user id", id);
        }
        return CaregiverBuilder.generateDTOFromEntity(caregiver.get ());
    }
    public CaregiverDTO findByEmail(String email){
        Caregiver caregiver  = caregiverRepository.findByEmail (email);

        if (caregiver == null) {
            throw new ResourceNotFoundException ("Caregiver", "user email", email);
        }
        return CaregiverBuilder.generateDTOFromEntity(caregiver);
    }

    public List<CaregiverDTO> findAll(){
        List<Caregiver> caregivers = caregiverRepository.findAll ();
        return caregivers.stream()
                .map(CaregiverBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Integer insert(CaregiverDTO caregiverDTO) {
        CaregiverFieldValidator.validateInsertOrUpdate(caregiverDTO);

        caregiverDTO.setPassword (passwordEncrypter.encrypt (caregiverDTO.getPassword ()));

        return caregiverRepository
                .save(CaregiverBuilder.generateEntityFromDTO(caregiverDTO))
                .getId();

    }

    public Integer update(CaregiverDTO caregiverDTO) {
        Optional<Caregiver> caregiver = caregiverRepository.findById(caregiverDTO.getId());

        if(!caregiver.isPresent()) {
            throw new ResourceNotFoundException ("Caregiver", "user id", caregiverDTO.getId ().toString ());
        }
        caregiverDTO = setNotNullProperties (caregiverDTO, caregiver.get ());
        CaregiverFieldValidator.validateInsertOrUpdate(caregiverDTO);

        return caregiverRepository.save(CaregiverBuilder.generateEntityFromDTO(caregiverDTO)).getId();

    }

    public void delete(CaregiverDTO caregiverDTO){
        Optional<Caregiver> caregiver = caregiverRepository.findById(caregiverDTO.getId());

        if(!caregiver.isPresent()){
            throw new ResourceNotFoundException("Caregiver", "user id", caregiverDTO.getId().toString());
        }

        this.caregiverRepository.deleteById(caregiverDTO.getId());
    }


    @Override
    public Object login(String email, String password) throws Exception {
        Caregiver caregiver =caregiverRepository.findByEmail(email);
        if(caregiver == null) {
            throw new ResourceNotFoundException("User", "email", email);
        }
        if(!passwordEncrypter.passEq (caregiver.getPassword (), password)){
            throw new Exception ("Incorrect password");
        }
        return CaregiverBuilder.generateDTOFromEntity (caregiver);
    }

    @Override
    public Object logout() {
        return null;
    }

    private CaregiverDTO setNotNullProperties(CaregiverDTO caregiverDTO, Caregiver caregiver) {
        if(caregiverDTO.getPassword () == null)
            caregiverDTO.setPassword (caregiver.getPassword ());
        else caregiverDTO.setPassword (passwordEncrypter.encrypt (caregiverDTO.getPassword ()));
        if(caregiverDTO.getName () == null)
            caregiverDTO.setName (caregiver.getName ());
        if(caregiverDTO.getAddress () == null)
            caregiverDTO.setAddress (caregiver.getAddress ());
        if(caregiverDTO.getGender () == null)
            caregiverDTO.setGender (caregiver.getGender ());
        if(caregiverDTO.getEmail () == null)
            caregiverDTO.setEmail (caregiver.getEmail ());
        if(caregiverDTO.getBirthDate () == null)
            caregiverDTO.setBirthDate (caregiver.getBirth_date ().toString());
        if(caregiverDTO.getPatients () == null && caregiver.getPatients () != null){
            List<PatientDTO> patientDTOS = caregiver.getPatients ()
                    .stream ().map (PatientBuilder::generateDTOFromEntity)
                    .collect(Collectors.toList());
            caregiverDTO.setPatients (patientDTOS);
        }
        return caregiverDTO;
    }

}

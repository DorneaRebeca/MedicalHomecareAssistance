package com.example.springdemo.services;

import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.dto.PatientViewDTO;
import com.example.springdemo.dto.builders.CaregiverBuilder;
import com.example.springdemo.dto.builders.MedicationPlanBuilder;
import com.example.springdemo.dto.builders.PatientBuilder;
import com.example.springdemo.dto.builders.PatientViewBuilder;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.PatientRepository;
import com.example.springdemo.validators.PatientFieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService implements UserServiceInterface{

    private final PatientRepository patientRepository;
    private PasswordEncrypter passwordEncrypter;

    @Autowired
    public PatientService(PasswordEncrypter passwordEncrypter, PatientRepository patientRepository) {
        this.passwordEncrypter = passwordEncrypter;
        this.patientRepository = patientRepository;
    }

    public PatientDTO findUserById(Integer id){
        Optional<Patient> patient  = patientRepository.findById(id);

        if (!patient.isPresent()) {
            throw new ResourceNotFoundException("Patient", "user id", id);
        }
        System.out.println (patient.toString ());
        return PatientBuilder.generateDTOFromEntity(patient.get());
    }

    public PatientViewDTO findUserByEmail(String email){
        Patient patient  = patientRepository.findByEmail (email);

        if (patient == null) {
            throw new ResourceNotFoundException("Patient", "email", email);
        }
        return PatientViewBuilder.generateDTOFromEntity(patient);
    }



    public List<PatientDTO> findAll(){
        List<Patient> patients = patientRepository.findAll ();

        return patients.stream()
                .map(PatientBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Integer insert(PatientDTO patientDTO) {

        PatientFieldValidator.validateInsertOrUpdate(patientDTO);

        patientDTO.setPassword (passwordEncrypter.encrypt (patientDTO.getPassword ()));
            return patientRepository
                    .save(PatientBuilder.generateEntityFromDTO(patientDTO))
                    .getId();

    }

    //TODO : UPDATE face insert la caregiver!!!
    //TODO : Data nu ii primita bine din frontend!!
    public Integer update(PatientDTO patientDTO) {
        Optional<Patient> patient = patientRepository.findById(patientDTO.getId());

        if(!patient.isPresent()){
            throw new ResourceNotFoundException("Patient", "user id", patientDTO.getId().toString());
        }
        patientDTO = setNotNullProperties (patientDTO, patient.get ());
        //PatientFieldValidator.validateInsertOrUpdate(patientDTO);

        return patientRepository.save(PatientBuilder.generateEntityFromDTO(patientDTO)).getId();

    }

    public void delete(PatientDTO patientDTO){
        Optional<Patient> patient = patientRepository.findById(patientDTO.getId());

        if(!patient.isPresent()){
            throw new ResourceNotFoundException("Patient", "user id", patientDTO.getId().toString());
        }
        this.patientRepository.deleteById(patientDTO.getId());
    }

    @Override
    public Object login(String email, String password) throws Exception {
        Patient patient = patientRepository.findByEmail(email);

        if(patient == null) {
            throw new ResourceNotFoundException("User", "email", email);
        }
        if(!passwordEncrypter.passEq (patient.getPassword (), password)){
            throw new Exception ("Incorrect password");
        }
        return PatientBuilder.generateDTOFromEntity (patient);
    }

    public List<MedicationPlanDTO> getMedicationPlans(Integer id) {
        Optional<Patient> patient = patientRepository.findById(id);

        if(!patient.isPresent()){
            throw new ResourceNotFoundException("Patient", "user id", id.toString());
        }

        return patient.get ().getMedicalRecord ().stream ()
                .map (MedicationPlanBuilder::generateDTOFromEntity)
                .collect (Collectors.toList ());
    }

    @Override
    public Object logout() {
        return null;
    }

    private PatientDTO setNotNullProperties(PatientDTO patientDTO, Patient patient) {
        if(patientDTO.getPassword () == null)
            patientDTO.setPassword (patient.getPassword ());
        else patientDTO.setPassword (passwordEncrypter.encrypt (patientDTO.getPassword ()));
        if(patientDTO.getName () == null)
            patientDTO.setName (patient.getName ());
        if(patientDTO.getAddress () == null)
            patientDTO.setAddress (patient.getAddress ());
        if(patientDTO.getGender () == null)
            patientDTO.setGender (patient.getGender ());
        if(patientDTO.getEmail () == null)
            patientDTO.setEmail (patient.getEmail ());
        if(patientDTO.getBirthDate () == null)
            patientDTO.setBirthDate (patient.getBirthDate ().toString());
        if(patientDTO.getCaregiver ().getId () == null){
            System.out.println ("Patient to be updated doesn't have a caregiver to be changed");
            patientDTO.setCaregiver (CaregiverBuilder.generateDTOFromEntity (patient.getCaregiver ()));
        }
        else{
            System.out.println (patientDTO.getCaregiver ().toString ());
        }
        if(patientDTO.getMedicalRecord () == null && patient.getMedicalRecord () != null){
            List<MedicationPlanDTO> medicationPlanDTOList = patient.getMedicalRecord ()
                    .stream ().map (MedicationPlanBuilder::generateDTOFromEntity)
                    .collect(Collectors.toList());
            patientDTO.setMedicalRecord (medicationPlanDTOList);
        }
        return patientDTO;
    }

}

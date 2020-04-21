package com.example.springdemo.services;

import com.example.springdemo.dto.MedicationDTO;
import com.example.springdemo.dto.builders.MedicationBuilder;
import com.example.springdemo.entities.Medication;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicationService {
    private final MedicationRepository medicationRepository;


    @Autowired
    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public MedicationDTO findMedicationById(Integer id) {
        Optional<Medication> medication = medicationRepository.findById (id);

        if (!medication.isPresent ()) {
            throw new ResourceNotFoundException ("Medication", "user id", id);
        }
        System.out.println (medication.toString ());
        return MedicationBuilder.generateDTOFromEntity (medication.get ());
    }

    public List<MedicationDTO> findAll() {
        List<Medication> medications = medicationRepository.findAll ();
        return medications.stream ()
                .map (MedicationBuilder::generateDTOFromEntity)
                .collect (Collectors.toList ());
    }

    public Integer insert(MedicationDTO medicationDTO) {
        //MedicationFieldValidator.validateInsertOrUpdate(medicationDTO);

        return medicationRepository
                .save (MedicationBuilder.generateEntityFromDTO (medicationDTO))
                .getId ();

    }

    public Integer update(MedicationDTO medicationDTO) {
        Optional<Medication> medication = medicationRepository.findById (medicationDTO.getId ());

        if (!medication.isPresent ()) {
            throw new ResourceNotFoundException ("Medication", "user id", medicationDTO.getId ().toString ());
        }

        medicationDTO = setNotNullProperties (medicationDTO, medication.get ());
        // MedicationFieldValidator.validateInsertOrUpdate(medicationDTO);

        return medicationRepository.save (MedicationBuilder.generateEntityFromDTO (medicationDTO)).getId ();

    }

    public void delete(MedicationDTO medicationDTO) {
        Optional<Medication> medication = medicationRepository.findById (medicationDTO.getId ());

        if (!medication.isPresent ()) {
            throw new ResourceNotFoundException ("Medication", "user id", medicationDTO.getId ().toString ());
        }

        this.medicationRepository.deleteById (medicationDTO.getId ());
    }

    private MedicationDTO setNotNullProperties(MedicationDTO medicationDTO, Medication medication) {
        if (medicationDTO.getSideEffects () == null)
            medicationDTO.setSideEffects (medication.getSideEffects ());
        if (medicationDTO.getName () == null)
            medicationDTO.setName (medication.getName ());
        if (medicationDTO.getDosage () == 0)
            medicationDTO.setDosage (medication.getDosage ());
        return medicationDTO;
    }
}

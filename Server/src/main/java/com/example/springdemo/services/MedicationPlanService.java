package com.example.springdemo.services;

import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.dto.PillDTO;
import com.example.springdemo.dto.builders.MedicationPlanBuilder;
import com.example.springdemo.dto.builders.PillBuilder;
import com.example.springdemo.entities.MedicationPlan;
import com.example.springdemo.entities.Pill;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.MedicationPlanRepository;
import com.example.springdemo.repositories.PillRepository;
import com.example.springdemo.validators.MedicationPlanFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicationPlanService {
    private final MedicationPlanRepository medicationPlanRepository;
    private final PillRepository pillRepository;

    @Autowired
    public MedicationPlanService(MedicationPlanRepository medicationPlanRepository, PillRepository pillRepository) {
        this.medicationPlanRepository = medicationPlanRepository;
        this.pillRepository = pillRepository;
    }

        public MedicationPlanDTO findPlanById(Integer id){
        Optional<MedicationPlan> medicationPlan  = medicationPlanRepository.findById(id);

        if (!medicationPlan.isPresent()) {
            throw new ResourceNotFoundException ("MedicationPlan", "plan id", id);
        }
        return MedicationPlanBuilder.generateDTOFromEntity(medicationPlan.get());
    }

    public List<MedicationPlanDTO> findAll(){
        List<MedicationPlan> medicationPlans = medicationPlanRepository.findAll ();

        return medicationPlans.stream()
                .map(MedicationPlanBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Integer insert(MedicationPlanDTO medicationPlanDTO) {
        MedicationPlanFormValidator.validateInsertOrUpdate(medicationPlanDTO);

         MedicationPlan m = medicationPlanRepository
                .save (MedicationPlanBuilder.generateEntityFromDTO (medicationPlanDTO));
        if(medicationPlanDTO.getPills () != null){
            for (PillDTO pill: medicationPlanDTO.getPills ()
                 ) {
                    Pill p = PillBuilder.generateEntityFromDTO (pill);
                System.out.println (p.toString ());
                    p.setMedicationPlan (m);
                    pillRepository.save (p);
            }
        }
        return m.getId ();
    }

    public Integer update(MedicationPlanDTO medicationPlanDTO) {
        Optional<MedicationPlan> medicationPlan = medicationPlanRepository.findById(medicationPlanDTO.getId());

        if(!medicationPlan.isPresent()){
            throw new ResourceNotFoundException("MedicationPlan", "plan id", medicationPlanDTO.getId().toString());
        }
        MedicationPlanFormValidator.validateInsertOrUpdate(medicationPlanDTO);
        return medicationPlanRepository.save(MedicationPlanBuilder.generateEntityFromDTO(medicationPlanDTO)).getId();

    }

    public void delete(MedicationPlanDTO medicationPlanDTO){
        Optional<MedicationPlan> medicationPlan = medicationPlanRepository.findById(medicationPlanDTO.getId());

        if(!medicationPlan.isPresent()){
            throw new ResourceNotFoundException("MedicationPlan", "plan id", medicationPlanDTO.getId().toString());
        }

        this.medicationPlanRepository.deleteById(medicationPlanDTO.getId());
    }

}

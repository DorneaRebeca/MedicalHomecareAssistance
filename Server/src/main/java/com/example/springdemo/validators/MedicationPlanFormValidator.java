package com.example.springdemo.validators;

import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.dto.PillDTO;
import com.example.springdemo.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MedicationPlanFormValidator {

    private static final Log LOGGER = LogFactory.getLog(PatientFieldValidator.class);

    public static void validateInsertOrUpdate(MedicationPlanDTO medicationPlanDTO) {

        List<String> errors = new ArrayList<> ();
        if (medicationPlanDTO == null) {
            errors.add("patientDTO is null");
            throw new IncorrectParameterException (MedicationPlanDTO.class.getSimpleName(), errors);
        }

        if(medicationPlanDTO.getEndDate ().compareTo (medicationPlanDTO.getStartDate ()) < 0) {
            errors.add("End date is before start date ");
        }

        for (PillDTO pill: medicationPlanDTO.getPills ()
             ) {
            ValidatePillForm.validateInsertOrUpdate (pill);
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(PatientFieldValidator.class.getSimpleName(), errors);
        }
    }
}

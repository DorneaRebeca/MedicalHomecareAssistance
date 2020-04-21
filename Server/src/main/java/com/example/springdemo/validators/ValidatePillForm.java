package com.example.springdemo.validators;

import com.example.springdemo.dto.PillDTO;
import com.example.springdemo.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidatePillForm {
    private static final Log LOGGER = LogFactory.getLog(PatientFieldValidator.class);

    public static void validateInsertOrUpdate(PillDTO pillDTO) {

        List<String> errors = new ArrayList<> ();
        if (pillDTO == null) {
            errors.add("pillDTO is null");
            throw new IncorrectParameterException (PillDTO.class.getSimpleName(), errors);
        }
         //TODO : intake interval validation
//        if(pillDTO.getIntakeInterval () <= 0 )
//            errors.add ("wrong pill intake number");

        if(pillDTO.getMedication ().getId () <= 0) {
            errors.add ("medication doesn't exist");
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(PatientFieldValidator.class.getSimpleName(), errors);
        }
    }

}

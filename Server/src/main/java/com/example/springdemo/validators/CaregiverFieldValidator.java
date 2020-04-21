package com.example.springdemo.validators;

import com.example.springdemo.dto.CaregiverDTO;
import com.example.springdemo.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CaregiverFieldValidator {
    private static final Log LOGGER = LogFactory.getLog(CaregiverFieldValidator.class);
    private static final EmailFieldValidator EMAIL_VALIDATOR = new EmailFieldValidator() ;

    public static void validateInsertOrUpdate(CaregiverDTO caregiverDTO) {

        List<String> errors = new ArrayList<> ();
        if (caregiverDTO == null) {
            errors.add("caregiverDTO is null");
            throw new IncorrectParameterException (CaregiverDTO.class.getSimpleName(), errors);
        }
        if (caregiverDTO.getEmail() == null || !EMAIL_VALIDATOR.validate(caregiverDTO.getEmail())) {
            errors.add("Caregiver email has invalid format");
        }

        if(LocalDateTime.parse(caregiverDTO.getBirthDate()).getYear() > LocalDateTime.now ().getYear ()) {
            errors.add ("Incorrect birth date");
        }
        if(!caregiverDTO.getGender ().equals ("Female") && !caregiverDTO.getGender ().equals ("Male")) {
            errors.add ("Incorrect gender");
        }


        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(CaregiverFieldValidator.class.getSimpleName(), errors);
        }
    }
    
}

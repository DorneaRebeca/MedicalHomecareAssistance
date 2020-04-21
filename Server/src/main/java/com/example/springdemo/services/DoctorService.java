package com.example.springdemo.services;

import com.example.springdemo.dto.*;
import com.example.springdemo.dto.builders.*;
import com.example.springdemo.entities.*;
import com.example.springdemo.errorhandler.ResourceNotFoundException;
import com.example.springdemo.repositories.DoctorRepository;
import com.example.springdemo.repositories.MonitoredDataRepository;
import com.example.springdemo.repositories.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService implements UserServiceInterface {

    private MedicationPlanService medicationPlanService;
    private PatientService patientService;
    private CaregiverService caregiverService;
    private MedicationService medicationService;
    private DoctorRepository doctorRepository;
    private PasswordEncrypter passwordEncrypter;
    private MonitoredDataRepository monitoredDataRepository;
    private RecommendationRepository recommendationRepository;

    @Autowired
    public DoctorService(PasswordEncrypter passwordEncrypter, MedicationPlanService medicationPlanService,
                         PatientService patientService, CaregiverService caregiverService,
                         DoctorRepository doctorRepository,
                         MedicationService medicationService,
                         MonitoredDataRepository monitoredDataRepository,
                         RecommendationRepository recommendationRepository) {
        this.passwordEncrypter = passwordEncrypter;
        this.caregiverService = caregiverService;
        this.medicationPlanService = medicationPlanService;
        this.patientService = patientService;
        this.doctorRepository = doctorRepository;
        this.medicationService = medicationService;
        this.monitoredDataRepository = monitoredDataRepository;
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public DoctorDTO login(String email, String password) throws Exception {
        Doctor doctor = doctorRepository.findByEmail(email);

        if(doctor == null) {
        throw new ResourceNotFoundException ("User", "email", email);
    }
        if(!passwordEncrypter.passEq (doctor.getPassword (), password)){
        throw new Exception ("Incorrect password");
    }
        return DoctorBuilder.generateDTOFromEntity (doctor);
    }

    @Override
    public Object logout() {
        return null;
    }

    public DoctorDTO findById(Integer id) {
        Optional<Doctor> doctor =doctorRepository.findById(id);

        if (!doctor.isPresent()) {
            throw new ResourceNotFoundException("Doctor", "user id", id);
        }
        return DoctorBuilder.generateDTOFromEntity(doctor.get());
    }

    public List<PatientDTO> findAllPatients() {
        return patientService.findAll ();
    }
    public PatientDTO findPatientById(Integer id) {
        return patientService.findUserById (id);
    }
    public void deletePatient(Integer id) {
        PatientDTO patientDTO = patientService.findUserById (id);
        patientService.delete (patientDTO);}
    public void updatePatient(PatientDTO patientDTO) {
       patientService.update (patientDTO);
    }
    public void insertPatient(PatientDTO patientDTO) {
        if(patientDTO.getCaregiver ().getId () == null)
            patientDTO.setCaregiver (null);
        else patientDTO.setCaregiver (caregiverService.findUserById (patientDTO.getCaregiver ().getId ()));
        patientService.insert (patientDTO);
    }

    public List<CaregiverDTO> findAllCaregivers(){
        return caregiverService.findAll ();
    }
    public CaregiverDTO findCaregiverById(Integer id) {
        return caregiverService.findUserById (id);
    }
    public void deleteCaregiver(Integer id) {
        CaregiverDTO caregiverDTO = caregiverService.findUserById (id);
        caregiverService.delete (caregiverDTO);
    }
    public void updateCaregiver(CaregiverDTO caregiverDTO) {
        System.out.println (caregiverDTO.toString ());

        caregiverService.update (caregiverDTO);
    }
    public void insertCaregiver(CaregiverDTO caregiverDTO) {
        caregiverService.insert (caregiverDTO);
    }

    public List<MedicationDTO> findAllMedications(){
        return medicationService.findAll ();
    }
    public MedicationDTO findMedicationById(Integer id) {
        return medicationService.findMedicationById (id);
    }
    public void deleteMedication(Integer id) {
        MedicationDTO medication = medicationService.findMedicationById (id);
        medicationService.delete (medication);
    }
    public void updateMedication(MedicationDTO medicationDTO) {
        medicationService.update (medicationDTO);
    }
    public void insertMedication(MedicationDTO medicationDTO) {
        medicationService.insert (medicationDTO);
    }

    public void insertMedicationPlan(MedicationPlanDTO medicationPlanDTO) {

        medicationPlanService.insert (medicationPlanDTO);
    }

    public List<MonitoredDataDTO> getPatientActivities(PatientDTO patient) {
        List<MonitoredData> data = monitoredDataRepository.findByPatient(
                 PatientBuilder.generateEntityFromDTO(patient)
         );
        data = data.stream().filter(MonitoredData::getAnomaly).collect(Collectors.toList());
                return data.stream ()
                .map (MonitoredDataBuilder::generateDTOFromEntity)
                .collect (Collectors.toList ());

    }

    public List<MonitoredDataDTO> getActivitiesOnDate(PatientDTO patient, String date) {
        List<MonitoredData> activities =  monitoredDataRepository.findByPatientAndStart(
                PatientBuilder.generateEntityFromDTO(patient),
                date + " %" );
        DateTimeFormatter format = DateTimeFormatter.ofPattern ("yyyy-MM-dd HH:mm:ss");

        activities.forEach( a -> {

            ZonedDateTime zdt1 = ZonedDateTime.of(
                    LocalDateTime.parse (a.getEnd (), format),
                    ZoneId.systemDefault());
            ZonedDateTime zdt2 = ZonedDateTime.of(
                    LocalDateTime.parse (a.getStart (), format),
                    ZoneId.systemDefault());
            long end = zdt1.toInstant().toEpochMilli();;
            long start = zdt2.toInstant().toEpochMilli();;
            a.setEnd(String.valueOf(end));
            a.setStart(String.valueOf(start));
        });
        System.out.println("Acitivites : " + activities.size() + date + "%" + patient.getId());
        activities.forEach(System.out::println);

        return activities.stream ()
                .map (MonitoredDataBuilder::generateDTOFromEntity)
                .collect (Collectors.toList ());

    }

    public void insertRecommendation(RecommendationDTO recommendationDTO) {
        recommendationRepository.save(RecommendationBuilder.generateEntityFromDTO(recommendationDTO));
        System.out.println("After salvation!");
    }

    public List<RecommendationDTO> getCaregiverRecommendations(int idCaregiver){
        Caregiver caregiver = CaregiverBuilder.generateEntityFromDTO(caregiverService.findUserById(idCaregiver));
        return recommendationRepository.findByCaregiver(caregiver)
                .stream().map(RecommendationBuilder::generateDTOFromEntity).collect(Collectors.toList());
    }
}

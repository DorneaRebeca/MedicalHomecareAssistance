
package com.example.springdemo.soapservice.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for recommendationDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="recommendationDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="caregiver" type="{http://services.soapService.springdemo.example.com/}caregiverDTO" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="patient" type="{http://services.soapService.springdemo.example.com/}patientDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recommendationDTO", propOrder = {
    "caregiver",
    "id",
    "message",
    "patient"
})
public class RecommendationDTO {

    protected CaregiverDTO caregiver;
    protected Integer id;
    protected String message;
    protected PatientDTO patient;

    /**
     * Gets the value of the caregiver property.
     * 
     * @return
     *     possible object is
     *     {@link CaregiverDTO }
     *     
     */
    public CaregiverDTO getCaregiver() {
        return caregiver;
    }

    /**
     * Sets the value of the caregiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaregiverDTO }
     *     
     */
    public void setCaregiver(CaregiverDTO value) {
        this.caregiver = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link PatientDTO }
     *     
     */
    public PatientDTO getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientDTO }
     *     
     */
    public void setPatient(PatientDTO value) {
        this.patient = value;
    }

}

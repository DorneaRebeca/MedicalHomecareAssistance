
package com.example.springdemo.soapservice.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pillDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pillDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="intakeInterval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medication" type="{http://services.soapService.springdemo.example.com/}medicationDTO" minOccurs="0"/>
 *         &lt;element name="medicationPlanDTO" type="{http://services.soapService.springdemo.example.com/}medicationPlanDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pillDTO", propOrder = {
    "id",
    "intakeInterval",
    "medication",
    "medicationPlanDTO"
})
public class PillDTO {

    protected Integer id;
    protected String intakeInterval;
    protected MedicationDTO medication;
    protected MedicationPlanDTO medicationPlanDTO;

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
     * Gets the value of the intakeInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntakeInterval() {
        return intakeInterval;
    }

    /**
     * Sets the value of the intakeInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntakeInterval(String value) {
        this.intakeInterval = value;
    }

    /**
     * Gets the value of the medication property.
     * 
     * @return
     *     possible object is
     *     {@link MedicationDTO }
     *     
     */
    public MedicationDTO getMedication() {
        return medication;
    }

    /**
     * Sets the value of the medication property.
     * 
     * @param value
     *     allowed object is
     *     {@link MedicationDTO }
     *     
     */
    public void setMedication(MedicationDTO value) {
        this.medication = value;
    }

    /**
     * Gets the value of the medicationPlanDTO property.
     * 
     * @return
     *     possible object is
     *     {@link MedicationPlanDTO }
     *     
     */
    public MedicationPlanDTO getMedicationPlanDTO() {
        return medicationPlanDTO;
    }

    /**
     * Sets the value of the medicationPlanDTO property.
     * 
     * @param value
     *     allowed object is
     *     {@link MedicationPlanDTO }
     *     
     */
    public void setMedicationPlanDTO(MedicationPlanDTO value) {
        this.medicationPlanDTO = value;
    }

}


package com.example.springdemo.soapservice.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for monitoredPillsList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="monitoredPillsList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="monitoredPillDTOList" type="{http://services.soapService.springdemo.example.com/}monitoredPillDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "monitoredPillsList", propOrder = {
    "monitoredPillDTOList"
})
public class MonitoredPillsList {

    @XmlElement(nillable = true)
    protected List<MonitoredPillDTO> monitoredPillDTOList;

    /**
     * Gets the value of the monitoredPillDTOList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the monitoredPillDTOList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMonitoredPillDTOList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MonitoredPillDTO }
     * 
     * 
     */
    public List<MonitoredPillDTO> getMonitoredPillDTOList() {
        if (monitoredPillDTOList == null) {
            monitoredPillDTOList = new ArrayList<MonitoredPillDTO>();
        }
        return this.monitoredPillDTOList;
    }

}

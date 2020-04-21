package com.utcn.soapApi.dtos;

import java.util.List;

public class MonitoredPillsList {

    List<MonitoredPillDTO> monitoredPillDTOList;

    public MonitoredPillsList() {
    }

    public MonitoredPillsList(List<MonitoredPillDTO> monitoredPillDTOList) {
        this.monitoredPillDTOList = monitoredPillDTOList;
    }

    public List<MonitoredPillDTO> getMonitoredPillDTOList() {
        return monitoredPillDTOList;
    }

    public void setMonitoredPillDTOList(List<MonitoredPillDTO> monitoredPillDTOList) {
        this.monitoredPillDTOList = monitoredPillDTOList;
    }
}

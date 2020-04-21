package com.utcn.soapApi.dtos;

import java.util.List;

public class RecommendationListDTO {

    private List<RecommendationDTO> recommendationDTOList;

    public RecommendationListDTO(List<RecommendationDTO> recommendationDTOList) {
        this.recommendationDTOList = recommendationDTOList;
    }

    public RecommendationListDTO() {
    }

    public List<RecommendationDTO> getRecommendationDTOList() {
        return recommendationDTOList;
    }

    public void setRecommendationDTOList(List<RecommendationDTO> recommendationDTOList) {
        this.recommendationDTOList = recommendationDTOList;
    }
}

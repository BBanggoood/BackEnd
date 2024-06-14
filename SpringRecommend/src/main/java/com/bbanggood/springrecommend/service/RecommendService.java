package com.bbanggood.springrecommend.service;

import com.bbanggood.springrecommend.entity.RecommendEntity;
import com.bbanggood.springrecommend.entity.VodEntity;
import com.bbanggood.springrecommend.repository.RecommendRepository;
import com.bbanggood.springrecommend.repository.VodRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendService {

    @Autowired
    private RecommendRepository recommendRepository;

    @Autowired
    private VodRepository vodRepository;

    public List<VodResponse> getVodListBySetbxId(String setbxId, int startIndex, int endIndex) {
        RecommendEntity recommendEntity = recommendRepository.findBySetbxId(setbxId);

        if (recommendEntity != null) {
            String[] vodNames = recommendEntity.getVodNameList().split(",");
            List<VodResponse> vodResponses = new ArrayList<>();

            for (int i = startIndex; i < Math.min(vodNames.length, endIndex); i++) {
                VodEntity vodEntity = vodRepository.findByVodName(vodNames[i].trim());
                if (vodEntity != null) {
                    VodResponse vodResponse = new VodResponse(vodEntity.getId(), vodEntity.getVodName(), vodEntity.getVodPoster());
                    vodResponses.add(vodResponse);
                }
            }
            return vodResponses;
        } else {
            return new ArrayList<>();
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class VodResponse {
        private ObjectId id;
        private String vodName;
        private String vodPoster;

        public VodResponse(ObjectId id, String vodName, String vodPoster) {
            this.id = id;
            this.vodName = vodName;
            this.vodPoster = vodPoster;
        }

        // Getters and setters
    }
}

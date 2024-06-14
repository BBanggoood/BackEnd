package com.bbanggood.springrecommend.controller;

import com.bbanggood.springrecommend.service.RecommendService;
import com.bbanggood.springrecommend.service.RecommendService.VodResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    @PostMapping("/main")
    public ResponseEntity<List<VodResponse>> getMainRecommendations(@RequestBody SetbxIdRequest request) {
        List<VodResponse> vodList = recommendService.getVodListBySetbxId(request.getSetbxId(), 0, 20);
        return ResponseEntity.ok(vodList);
    }

    @PostMapping("/kids")
    public ResponseEntity<List<VodResponse>> getKidsRecommendations(@RequestBody SetbxIdRequest request) {
        List<VodResponse> vodList = recommendService.getVodListBySetbxId(request.getSetbxId(), 20, 40);
        return ResponseEntity.ok(vodList);
    }

    @PostMapping("/drama")
    public ResponseEntity<List<VodResponse>> getDramaRecommendations(@RequestBody SetbxIdRequest request) {
        List<VodResponse> vodList = recommendService.getVodListBySetbxId(request.getSetbxId(), 40, 60);
        return ResponseEntity.ok(vodList);
    }

    @PostMapping("/movie")
    public ResponseEntity<List<VodResponse>> getMovieRecommendations(@RequestBody SetbxIdRequest request) {
        List<VodResponse> vodList = recommendService.getVodListBySetbxId(request.getSetbxId(), 60, 80);
        return ResponseEntity.ok(vodList);
    }

    @PostMapping("/tv")
    public ResponseEntity<List<VodResponse>> getTvRecommendations(@RequestBody SetbxIdRequest request) {
        List<VodResponse> vodList = recommendService.getVodListBySetbxId(request.getSetbxId(), 80, 100);
        return ResponseEntity.ok(vodList);
    }

    @PostMapping("/animation")
    public ResponseEntity<List<VodResponse>> getAnimationRecommendations(@RequestBody SetbxIdRequest request) {
        List<VodResponse> vodList = recommendService.getVodListBySetbxId(request.getSetbxId(), 100, 120);
        return ResponseEntity.ok(vodList);
    }

    @PostMapping("/adult")
    public ResponseEntity<List<VodResponse>> getAdultRecommendations(@RequestBody SetbxIdRequest request) {
        List<VodResponse> vodList = recommendService.getVodListBySetbxId(request.getSetbxId(), 120, 140);
        return ResponseEntity.ok(vodList);
    }

    public static class SetbxIdRequest {
        private String setbxId;

        public String getSetbxId() {
            return setbxId;
        }

        public void setSetbxId(String setbxId) {
            this.setbxId = setbxId;
        }
    }
}

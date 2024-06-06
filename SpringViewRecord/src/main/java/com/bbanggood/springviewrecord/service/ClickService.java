package com.bbanggood.springviewrecord.service;

import com.bbanggood.springviewrecord.entity.Click;
import com.bbanggood.springviewrecord.respository.ClickRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class ClickService {
    private final ClickRepository clickRepository;

    public void ClickPost(Integer setbxId, Integer vodId, String viewType, Instant clickTime) {
        Click click = new Click();

        click.setSetbxId(setbxId);
        click.setVodId(vodId);
        click.setViewType(viewType);
        click.setClickTime(clickTime);

        clickRepository.save(click);
    }
}

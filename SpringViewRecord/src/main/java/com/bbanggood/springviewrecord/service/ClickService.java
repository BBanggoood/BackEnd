package com.bbanggood.springviewrecord.service;

import com.bbanggood.springviewrecord.entity.Click;
import com.bbanggood.springviewrecord.respository.ClickRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class ClickService {
    private final ClickRepository clickRepository;

    public void ClickPost(Integer setbxId, String vodName, String viewType, LocalDate clickTime) {
        Click click = new Click();

        click.setSetbxId(setbxId);
        click.setVodName(vodName);
        click.setViewType(viewType);
        click.setClickTime(clickTime);

        clickRepository.save(click);
    }
}

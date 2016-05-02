package com.lukegjpotter.spring.application.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.Categories;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.Constants;

@Service public class StageDetailsCategoryService {

    public Categories determineCategories(List<StageDetail> stageDetails) {
        Categories categories = new Categories();
        List<String> categoryStrings = new ArrayList<>();
        
        stageDetails.forEach(stageDetail -> {
            categoryStrings.add(stageDetail.getRaceType().toLowerCase());
        });
        
        if (categoryStrings.contains("a+")) categories.setAPlus(true);
        if (categoryStrings.contains("a1")) categories.setA1(true);
        if (categoryStrings.contains("a2")) categories.setA2(true);
        if (categoryStrings.contains("a3")) categories.setA3(true);
        if (categoryStrings.contains("a4")) categories.setA4(true);
        if (categoryStrings.contains("vets")) categories.setVets(true);
        if (categoryStrings.contains("women")) categories.setWoman(true);
        // TODO Determine a way to check for A3/Junior races.
        if (categoryStrings.contains("junior")) categories.setJunior(true);
        if (!Collections.disjoint(categoryStrings, Constants.YOUTH_CATEGORIES)) categories.setYouth(true);
        
        return categories;
    }

}

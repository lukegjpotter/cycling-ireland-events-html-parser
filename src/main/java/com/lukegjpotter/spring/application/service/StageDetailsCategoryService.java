package com.lukegjpotter.spring.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.Categories;
import com.lukegjpotter.spring.application.model.StageDetail;

@Service public class StageDetailsCategoryService {

    public Categories determineCategories(List<StageDetail> stageDetails) {
        Categories categories = new Categories();
        List<String> categoryStrings = new ArrayList<>();
        
        stageDetails.forEach(stageDetail -> {
            categoryStrings.add(stageDetail.getCategory().toLowerCase());
        });
        
        if (categoryStrings.contains("a+")) categories.setAPlus(true);
        if (categoryStrings.contains("a1")) categories.setA1(true);
        if (categoryStrings.contains("a2")) categories.setA2(true);
        if (categoryStrings.contains("a3")) categories.setA3(true);
        if (categoryStrings.contains("a4")) categories.setA4(true);
        if (categoryStrings.contains("vets")) categories.setVets(true);
        if (categoryStrings.contains("woman")) categories.setWoman(true);
        if (categoryStrings.contains("junior")) categories.setJunior(true);
        // TODO check for "U16", "U-16", "Under 16", etc, for the ages.
        if (categoryStrings.contains("youth")) categories.setYouth(true);
        
        return categories;
    }

}

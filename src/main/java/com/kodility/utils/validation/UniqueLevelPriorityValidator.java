package com.kodility.utils.validation;

import com.kodility.service.level.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.kodility.controller.level.model.SaveLevelAjaxRequest.LevelModel;

@Component
public class UniqueLevelPriorityValidator implements ConstraintValidator<UniqueLevelPriority, LevelModel> {

    @Autowired
    private LevelService levelService;

    @Override
    public void initialize(UniqueLevelPriority constraintAnnotation) {
    }

    @Override
    public boolean isValid(LevelModel levelModel, ConstraintValidatorContext context) {
        return levelModel == null || levelService.isValidToSave(levelModel.getPriority(), levelModel.getLevelId());
    }

}

package com.example.moviesapp.domain.usecase.validation.impl

import com.example.moviesapp.domain.helpers.validation.StringValidationHelper
import com.example.moviesapp.domain.usecase.validation.ValidateEmptyFieldUseCase
import com.example.moviesapp.domain.utils.HelperTexts
import javax.inject.Inject

class ValidateEmptyFieldUseCaseImpl @Inject constructor(private val stringValidationHelper: StringValidationHelper): ValidateEmptyFieldUseCase {
    override fun invoke(text: String): String {
        return if(stringValidationHelper.requiredField(text)){
            HelperTexts.VALID.message
        }else{
            HelperTexts.REQUIRED.message
        }
    }
}
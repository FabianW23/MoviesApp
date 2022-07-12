package com.example.moviesapp.domain.usecase.validation.impl

import com.example.moviesapp.domain.helpers.validation.StringValidationHelper
import com.example.moviesapp.domain.usecase.validation.ValidateEmailFieldUseCase
import com.example.moviesapp.domain.usecase.validation.ValidateEmptyFieldUseCase
import com.example.moviesapp.domain.utils.HelperTexts
import javax.inject.Inject

class ValidateEmailFieldUseCasedImpl @Inject constructor(private val stringValidationHelper: StringValidationHelper):
    ValidateEmailFieldUseCase {
    override fun invoke(text: String): String {
        return if(!stringValidationHelper.requiredField(text)){
            HelperTexts.REQUIRED.message
        }else if (!stringValidationHelper.isValidEmail(text)){
            HelperTexts.EMAIL.message
        }else{
            HelperTexts.VALID.message
        }
    }
}
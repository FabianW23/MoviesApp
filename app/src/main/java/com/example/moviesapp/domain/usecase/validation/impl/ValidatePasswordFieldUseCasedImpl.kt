package com.example.moviesapp.domain.usecase.validation.impl

import com.example.moviesapp.domain.helpers.validation.StringValidationHelper
import com.example.moviesapp.domain.usecase.validation.ValidatePasswordFieldUseCase
import com.example.moviesapp.domain.utils.HelperTexts
import javax.inject.Inject

class ValidatePasswordFieldUseCasedImpl @Inject constructor(private val stringValidationHelper: StringValidationHelper) :
    ValidatePasswordFieldUseCase {
    override fun invoke(text: String): String {
        return if (!stringValidationHelper.requiredField(text)) {
            HelperTexts.REQUIRED.message
        } else if (!stringValidationHelper.requiredCapitalLetter(text)) {
            HelperTexts.MUST_CONTAINS_CAPITAL_LETTER.message
        } else if (!stringValidationHelper.requiredNumber(text)) {
            HelperTexts.MUST_CONTAINS_CAPITAL_LETTER.message
        } else {
            HelperTexts.VALID.message
        }
    }
}
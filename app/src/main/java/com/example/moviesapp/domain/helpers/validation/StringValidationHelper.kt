package com.example.moviesapp.domain.helpers.validation

interface StringValidationHelper {

    fun requiredField(text : String) : Boolean

    fun requiredCapitalLetter(text : String) : Boolean

    fun requiredNumber(text : String) : Boolean

    fun isValidEmail(text : String) : Boolean
}
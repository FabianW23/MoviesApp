package com.example.moviesapp.domain.helpers.validation.impl

import com.example.moviesapp.domain.helpers.validation.StringValidationHelper

class StringValidationHelperImpl : StringValidationHelper {

    override fun requiredField(text: String): Boolean {
        return text != ""
    }

    override fun requiredCapitalLetter(text: String): Boolean {
        return text.contains("[A-Z]".toRegex())
    }

    override fun requiredNumber(text: String): Boolean {
        return text.contains("[0-9]".toRegex())
    }

    override fun isValidEmail(text: String): Boolean {
        return text.contains("^[A-Za-z](.*)([@])(.+)(\\.)(.+)".toRegex())
    }
}
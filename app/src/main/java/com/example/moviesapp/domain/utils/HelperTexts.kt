package com.example.moviesapp.domain.utils

enum class HelperTexts(val message:String) {
    VALID("Valid"),
    REQUIRED("Required field"),
    EMAIL("Email is not valid"),
    MUST_CONTAINS_NUMBER("Password must contain at least one number"),
    MUST_CONTAINS_CAPITAL_LETTER("Password must contain at least one capital character")
}
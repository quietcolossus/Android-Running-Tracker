package com.quietcolossus.auth.domain

interface PatternValidator {
    fun matches(value: String): Boolean
}
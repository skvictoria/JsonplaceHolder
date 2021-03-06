package com.example.newproject0112.di.util


enum class ApiErrorCode(val errorCode: Int) {

    GENERAL_BAD_REQUEST(1000),

    GENERAL_ILLEGAL_STATE(1001),

    ACCOUNT_NOT_EXIST(2000),

    ACCOUNT_UNAUTHENTICATED(2001),

    ACCOUNT_UNAUTHORIZED(2002),

}
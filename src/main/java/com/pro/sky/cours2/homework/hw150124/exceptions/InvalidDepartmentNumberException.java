package com.pro.sky.cours2.homework.hw150124.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "InvalidDepartmentNumber")
public class InvalidDepartmentNumberException extends IllegalArgumentException{
    public InvalidDepartmentNumberException() {
        super();
    }
    public InvalidDepartmentNumberException(String s) {
        super(s);
    }
}

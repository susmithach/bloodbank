package com.cognizant.onlinebloodbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="ACTIVE SLOT")
public class SlotsbookedException extends Exception{

}

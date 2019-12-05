package com.cognizant.onlinebloodbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="Slot already booked")
public class SlotsbookedException extends Exception{

}

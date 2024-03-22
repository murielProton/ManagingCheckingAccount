package com.example.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.model.entities.MyRecord;
import com.example.model.enums.TypeOfTransaction;

public class CheckNumberValidation {

    public static ResponseEntity<?> validateCheckNumber(MyRecord myRecord) {
        if (myRecord.getTypeTransaction() == TypeOfTransaction.CHECK) {
            if (myRecord.getCheckNumber() == null || myRecord.getCheckNumber().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ValidationConstant.CHECK_NUMBER_IS_NULL_OR_EMPTY);
            }
        }
        return ResponseEntity.ok().build(); // Check passed
    }
}

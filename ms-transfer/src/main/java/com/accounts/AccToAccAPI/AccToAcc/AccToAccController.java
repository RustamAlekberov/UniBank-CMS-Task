package com.accounts.AccToAccAPI.AccToAcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "UniTech/AccToAccAPI/transferAcc")
public class AccToAccController {
    private final AccToAccService accToAccService;

    @Autowired
    public AccToAccController(AccToAccService accToAccService) {
        this.accToAccService = accToAccService;
    }


    @PutMapping(value = "/properties/{amount}/{sendAccNumber}/{getAccNumber}")
    public ResponseEntity<String> updateTelebe(@PathVariable Double amount, @PathVariable String sendAccNumber, @PathVariable String getAccNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(accToAccService.moneyTransfer(amount, sendAccNumber, getAccNumber));

    }
}

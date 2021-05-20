package com.example.washmachinedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.washmachinedemo.entity.WashMachineEntity;
import com.example.washmachinedemo.service.IWashMachineService;

@RestController
@RequestMapping({ "/washMachineDemo" })
public class WashMachineController
{
    @Autowired
    IWashMachineService service;
    
    @PostMapping({ "/spin/{time}" })
    public ResponseEntity<WashMachineEntity> spin(@PathVariable final Long time) {
        return new ResponseEntity<WashMachineEntity>(service.spinFunctionality(time), new HttpHeaders(), HttpStatus.CREATED);
    }
    
    @PostMapping({ "/wash/{time}" })
    public ResponseEntity<WashMachineEntity> wash(@PathVariable final Long time) {
        return new ResponseEntity<WashMachineEntity>(service.washFunctionality(time), new HttpHeaders(), HttpStatus.CREATED);
    }
    
    @PutMapping({ "/stopSpin" })
    public ResponseEntity<Boolean> stopSpin() {
        this.service.stopSpinning();
        return new ResponseEntity<Boolean>(true, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping({ "/stopWash" })
    public ResponseEntity<Boolean> stopWash() {
        this.service.stopWashing();
        return new ResponseEntity<Boolean>(true, new HttpHeaders(), HttpStatus.OK);
    }
}

package com.example.washmachinedemo.service;

import com.example.washmachinedemo.entity.WashMachineEntity;

public interface IWashMachineService
{
    WashMachineEntity spinFunctionality(final Long time);
    
    void stopSpinning();
    
    WashMachineEntity washFunctionality(final Long time);
    
    void stopWashing();
}

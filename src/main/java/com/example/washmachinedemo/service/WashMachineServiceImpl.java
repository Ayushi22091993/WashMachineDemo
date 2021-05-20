package com.example.washmachinedemo.service;

import java.util.List;
import java.util.Date;
import com.example.washmachinedemo.exception.InvalidTimeException;
import com.example.washmachinedemo.entity.WashMachineEntity;
import com.example.washmachinedemo.repository.IWashMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Timer;
import org.springframework.stereotype.Service;

@Service
public class WashMachineServiceImpl implements IWashMachineService
{
    @Autowired
    Timer timer;
    @Autowired
    IWashMachineRepository repository;
    
    @Override
    public WashMachineEntity spinFunctionality(final Long time) {
        if (time > 15L) {
            throw new InvalidTimeException("Invalid Time. Time should be less than 16.");
        }
        final List<WashMachineEntity> entityList = (List<WashMachineEntity>)this.repository.findByType("Spin");
        if (entityList.size() > 0) {
            this.repository.deleteAll(entityList);
        }
        final long startTime = System.currentTimeMillis();
        final WashMachineEntity entity = new WashMachineEntity();
        entity.setStart_time(Long.valueOf(startTime));
        entity.setType("Spin");
        long elapsedTime;
        for (elapsedTime = 0L; elapsedTime < time * 60L * 1000L; elapsedTime = new Date().getTime() - startTime) {}
        System.out.println("Spin finished in time: " + elapsedTime);
        entity.setStop_time(Long.valueOf(System.currentTimeMillis()));
        return repository.save(entity);
    }
    
    @Override
    public WashMachineEntity washFunctionality(final Long time) {
        if (time > 15L) {
            throw new InvalidTimeException("Invalid Time. Time should be less than 16.");
        }
        final List<WashMachineEntity> entityList = (List<WashMachineEntity>)this.repository.findByType("Wash");
        if (entityList.size() > 0) {
            this.repository.deleteAll(entityList);
        }
        final long startTime = System.currentTimeMillis();
        final WashMachineEntity entity = new WashMachineEntity();
        entity.setStart_time(Long.valueOf(startTime));
        entity.setType("Wash");
        long elapsedTime;
        for (elapsedTime = 0L; elapsedTime < time * 60L * 1000L; elapsedTime = new Date().getTime() - startTime) {}
        System.out.println("Wash finished in time: " + elapsedTime);
        entity.setStop_time(Long.valueOf(System.currentTimeMillis()));
        return repository.save(entity);
    }
    
    @Override
    public void stopSpinning() {
        final List<WashMachineEntity> entityList = (List<WashMachineEntity>)this.repository.findByType("Spin");
        if (entityList.size() > 0) {
            final WashMachineEntity entity = entityList.get(entityList.size() - 1);
            entity.setStop_time(Long.valueOf(System.currentTimeMillis()));
            repository.save(entity);
        }
    }
    
    @Override
    public void stopWashing() {
        final List<WashMachineEntity> entityList = (List<WashMachineEntity>)this.repository.findByType("Wash");
        if (entityList.size() > 0) {
            final WashMachineEntity entity = entityList.get(entityList.size() - 1);
            entity.setStop_time(Long.valueOf(System.currentTimeMillis()));
            repository.save(entity);
        }
    }
}

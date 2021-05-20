package com.example.washmachinedemo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.washmachinedemo.entity.WashMachineEntity;
import com.example.washmachinedemo.repository.IWashMachineRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class WashMachineServiceImplTest {
	
	@InjectMocks
	private WashMachineServiceImpl service;
	
	@Mock
    Timer timer;
	
    @Mock
    IWashMachineRepository repository;
    
    @Mock
    WashMachineEntity entity;
    
    @BeforeAll
    void setup() {
    	MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testSpinFunctionality() {
    	List<WashMachineEntity> entityList = new ArrayList<>();
    	entityList.add(entity);
    	when(repository.findByType("Spin")).thenReturn(entityList);
    	Mockito.when(repository.save(Mockito.any(WashMachineEntity.class))).thenReturn(entity);
    	assertNotNull(service.spinFunctionality(1L));
    }
    
    @Test
    public void testWashFunctionality() {
    	List<WashMachineEntity> entityList = new ArrayList<>();
    	entityList.add(entity);
    	when(repository.findByType("Wash")).thenReturn(entityList);
    	Mockito.when(repository.save(Mockito.any(WashMachineEntity.class))).thenReturn(entity);
    	assertNotNull(service.washFunctionality(1L));
    }
    
    @Test
    public void testStopSpinning() {
    	List<WashMachineEntity> entityList = new ArrayList<>();
    	entityList.add(entity);
    	when(repository.findByType("Spin")).thenReturn(entityList);
    	Mockito.when(repository.save(Mockito.any(WashMachineEntity.class))).thenReturn(entity);
    	service.stopSpinning();
    }
    
    @Test
    public void testStopWashing() {
    	List<WashMachineEntity> entityList = new ArrayList<>();
    	entityList.add(entity);
    	when(repository.findByType("Wash")).thenReturn(entityList);
    	Mockito.when(repository.save(Mockito.any(WashMachineEntity.class))).thenReturn(entity);
    	service.stopWashing();
    }

}

package com.example.washmachinedemo.entity;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "TBL_WASH_MACHINE")
public class WashMachineEntity
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "TYPE")
    public String type;
    @Column(name = "START_TIME")
    public Long start_time;
    @Column(name = "STOP_TIME")
    public Long stop_time;
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public String getType() {
        return this.type;
    }
    
    public void setType(final String type) {
        this.type = type;
    }
    
    public Long getStart_time() {
        return this.start_time;
    }
    
    public void setStart_time(final Long start_time) {
        this.start_time = start_time;
    }
    
    public Long getStop_time() {
        return this.stop_time;
    }
    
    public void setStop_time(final Long stop_time) {
        this.stop_time = stop_time;
    }
}

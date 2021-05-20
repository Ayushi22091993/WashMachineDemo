package com.example.washmachinedemo.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.washmachinedemo.entity.WashMachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IWashMachineRepository extends JpaRepository<WashMachineEntity, Long>
{
    List<WashMachineEntity> findByType(final String type);
}

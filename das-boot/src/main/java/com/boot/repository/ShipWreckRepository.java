package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Shipwreck;

//# JpaRepository<Entity, Id> -- look at the params
public interface ShipWreckRepository extends JpaRepository<Shipwreck, Long>{

}

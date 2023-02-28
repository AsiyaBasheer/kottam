package com.asiya.kootam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asiya.kootam.model.ItemUOM;

@Repository
public interface ItemUOMRepository extends JpaRepository<ItemUOM, Integer> {

}
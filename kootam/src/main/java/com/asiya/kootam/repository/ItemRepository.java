package com.asiya.kootam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asiya.kootam.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}

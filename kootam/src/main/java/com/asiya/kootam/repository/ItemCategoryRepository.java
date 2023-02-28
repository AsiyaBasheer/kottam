package com.asiya.kootam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asiya.kootam.model.ItemCategory;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Integer> {

}

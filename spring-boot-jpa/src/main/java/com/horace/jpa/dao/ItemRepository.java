package com.horace.jpa.dao;

import com.horace.jpa.controller.model.ItemReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-11-23 11:52
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}

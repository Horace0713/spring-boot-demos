package com.horace.jpa.dao;

import com.horace.jpa.controller.model.ItemReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-11-23 11:52
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long>, JpaSpecificationExecutor<ItemEntity> {
    /**
     * @param title
     * @param pageable
     * @return
     */
    @Query("from ItemEntity i where i.title = :title order by i.id desc")
    Page<ItemEntity> findByTitle(@Param("title") String title, Pageable pageable);
}

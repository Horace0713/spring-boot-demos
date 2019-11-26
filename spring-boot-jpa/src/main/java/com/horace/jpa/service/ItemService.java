package com.horace.jpa.service;

import com.horace.jpa.controller.model.ItemPageReq;
import com.horace.jpa.controller.model.ItemReq;
import com.horace.jpa.controller.model.PageResp;
import com.horace.jpa.dao.ItemEntity;
import com.horace.jpa.dao.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-11-23 11:53
 */
@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public ItemReq create(ItemReq req) {
        if (!Objects.isNull(req.getId())) {
            Optional<ItemEntity> byId = repository.findById(req.getId());
            if (byId.isPresent()) {
                ItemReq itemReq = new ItemReq();
                BeanUtils.copyProperties(byId.get(), itemReq);
                return itemReq;
            }
        }
        ItemEntity entity = new ItemEntity();
        BeanUtils.copyProperties(req, entity);
        entity.setUpTime(LocalDateTime.now());
        ItemEntity saved = repository.save(entity);
        BeanUtils.copyProperties(saved, req);
        return req;
    }

    public ItemReq findById(Long id) {
        Optional<ItemEntity> byId = repository.findById(id);
        ItemEntity entity = byId.orElseThrow(() -> new EntityNotFoundException("找不到item，id为" + id));
        ItemReq itemReq = new ItemReq();
        BeanUtils.copyProperties(entity, itemReq);
        return itemReq;
    }

    public List<ItemReq> findAll() {
        return repository.findAll()
                .stream()
                .map((e) -> {
                    ItemReq itemReq = new ItemReq();
                    BeanUtils.copyProperties(e, itemReq);
                    return itemReq;
                }).collect(Collectors.toList());
    }

    public PageResp<ItemReq> findPage(int page, int size) {
        Page<ItemEntity> entityPage = repository.findAll(PageRequest.of(page, size));
        List<ItemReq> itemReqList = copyEntitysToDtos(entityPage);

        PageResp<ItemReq> pageResp = new PageResp<ItemReq>(); //todo  为什么不能用builder
        pageResp.setPage(entityPage.getPageable().getPageNumber());
        pageResp.setTotalNum(entityPage.getTotalElements());
        pageResp.setTotalPage(entityPage.getTotalPages());
        pageResp.setContent(itemReqList);
        return pageResp;
    }

    public Page<ItemReq> findPage(Pageable pageable) {
        Page<ItemEntity> entityPage = repository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
        List<ItemReq> itemReqList = copyEntitysToDtos(entityPage);
        return new PageImpl(itemReqList, entityPage.getPageable(), entityPage.getTotalElements());
    }

    private List<ItemReq> copyEntitysToDtos(Page<ItemEntity> entityPage) {
        return entityPage.getContent().stream()
                .map(e -> {
                    ItemReq itemReq = new ItemReq();
                    BeanUtils.copyProperties(e, itemReq);
                    return itemReq;
                }).collect(Collectors.toList());
    }

    public Page<ItemReq> findPageByTitle(String title, Pageable pageable) {
        Page<ItemEntity> entityPage = repository.findByTitle(title, pageable);
        List<ItemReq> itemReqs = copyEntitysToDtos(entityPage);
        return new PageImpl(itemReqs, entityPage.getPageable(), entityPage.getTotalElements());
    }

//    public Page<ItemReq> findPageByExam(Pageable page) {
//        Page<ItemEntity> entityPage = repository.findAll(null, page);
//        List<ItemReq> itemReqs = copyEntitysToDtos(entityPage);
//        return new PageImpl(itemReqs, entityPage.getPageable(), entityPage.getTotalElements());
//    }

    public Page<ItemReq> findAllBySpec(ItemPageReq req) {
        Specification<ItemEntity> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(req.getTitle())) {
                Predicate p = criteriaBuilder.equal(root.get("title").as(String.class), req.getTitle());
                predicates.add(p);
            }
            if (StringUtils.hasText(req.getBarcode())) {
                Predicate p = criteriaBuilder.equal(root.get("barcode").as(String.class), req.getBarcode());
                predicates.add(p);
            }
            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        };

        Sort sort = new Sort(Sort.Direction.ASC, "createTime");
        Page<ItemEntity> entityPage = repository.findAll(specification, PageRequest.of(req.getPage(), req.getPageSize(), sort));
        List<ItemReq> itemReqs = copyEntitysToDtos(entityPage);
        return new PageImpl(itemReqs, entityPage.getPageable(), entityPage.getTotalElements());
    }
}

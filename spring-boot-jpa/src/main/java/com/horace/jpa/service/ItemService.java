package com.horace.jpa.service;

import com.horace.jpa.controller.model.ItemReq;
import com.horace.jpa.controller.model.PageResp;
import com.horace.jpa.dao.ItemEntity;
import com.horace.jpa.dao.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
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
        List<ItemReq> itemReqList = entityPage.getContent().stream()
                .map(e -> {
                    ItemReq itemReq = new ItemReq();
                    BeanUtils.copyProperties(e, itemReq);
                    return itemReq;
                }).collect(Collectors.toList());

        PageResp<ItemReq> pageResp = new PageResp<ItemReq>(); //todo  为什么不能用builder
        pageResp.setPage(entityPage.getPageable().getPageNumber());
        pageResp.setTotalNum(entityPage.getTotalElements());
        pageResp.setTotalPage(entityPage.getTotalPages());
        pageResp.setContent(itemReqList);
        return pageResp;
    }
}

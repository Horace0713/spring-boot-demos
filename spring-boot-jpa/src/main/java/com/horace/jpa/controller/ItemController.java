package com.horace.jpa.controller;

import com.horace.jpa.controller.model.ItemReq;
import com.horace.jpa.controller.model.PageResp;
import com.horace.jpa.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-11-23 12:05
 */
@RestController
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping("/item/create")
    public ItemReq create(@RequestBody ItemReq req) {
        return service.create(req);
    }

    @GetMapping("/item/find/{id}")
    public ItemReq find(@PathVariable(required = true) Long id) {
        return service.findById(id);
    }

    @GetMapping("/item/findAll")
    public List<ItemReq> findAll() {
        return service.findAll();
    }

    /**
     * 无条件分页  用PagingAndSortingRepository
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/item/findPage")
    public PageResp<ItemReq> findPage(@RequestParam(name = "page", defaultValue = "0") int page,
                                      @RequestParam(name = "size", defaultValue = "2")
                                      @Max(3)//todo 不管用 如何限制大小
                                              int size) {
        return service.findPage(page, size);
    }

    /**
     * 有条件分页 用 QueryByExampleExecutor
     */

}

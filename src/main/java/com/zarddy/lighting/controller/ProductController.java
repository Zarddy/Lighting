package com.zarddy.lighting.controller;

import com.zarddy.lighting.entity.ProductEntity;
import com.zarddy.lighting.jpa.ProductJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <a href="https://www.jianshu.com/p/b6932740f3c0">第三章：SpringBoot使用SpringDataJPA完成CRUD</a>
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductJPA productJPA;

    /**
     * 查询所有产品信息
     * @return
     */
    @RequestMapping(value = "/listall", method = RequestMethod.GET)
    public List<ProductEntity> listProducts() {
        return productJPA.findAll();
    }

    /**
     * 添加、更新产品信息
     * @param product 产品信息
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ProductEntity save(ProductEntity product) {
        return productJPA.save(product);
    }

    /**
     * 根据产品id删除对应产品信息
     * @param id 产品id
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<ProductEntity> deleteById(Long id) {
        productJPA.deleteById(id);
        return productJPA.findAll();
    }
}

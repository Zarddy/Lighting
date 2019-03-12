package com.zarddy.lighting.jpa;

import com.zarddy.lighting.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * JpaRepository接口：SpringDataJPA提供的简单数据接口
 * JpaSpecificationExecutor接口：SpringDataJPA提供的复杂查询接口
 * Serializable接口：序列化接口
 */
public interface ProductJPA extends JpaRepository<ProductEntity, Long>,
        JpaSpecificationExecutor<ProductEntity>, Serializable {
}

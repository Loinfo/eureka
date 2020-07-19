package com.xili.productservice.product.repository;


import com.xili.productservice.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 产品管理repository
 *
 * @author xili
 * @since 1.0.0
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}

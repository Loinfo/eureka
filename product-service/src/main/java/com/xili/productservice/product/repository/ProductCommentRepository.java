package com.xili.productservice.product.repository;


import com.xili.productservice.product.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品评论管理repository
 *
 * @author xili
 * @since 1.0.0
 */
public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {
    List<ProductComment> findByProductIdOrderByCreated(Long productId);
}

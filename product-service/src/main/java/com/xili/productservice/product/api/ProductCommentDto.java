package com.xili.productservice.product.api;

import com.google.common.base.MoreObjects;
import com.xili.productservice.product.entity.Product;
import com.xili.productservice.product.entity.ProductComment;

import java.io.Serializable;
import java.util.Date;


/**
 * 商品评论信息DTO定义
 *
 * @author xili
 * @since 1.0.0
 */
public class ProductCommentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    // ========================================================================
    // fields =================================================================
    private Long id;
    private Product product;                                    // 所属商品
    private UserDto author;                                     // 评论作者
    private String content;                                     // 评论内容
    private Date created;                                       // 创建时间

    public ProductCommentDto() {

    }

    public ProductCommentDto(ProductComment productComment) {
        this.id = productComment.getId();
        this.content = productComment.getContent();
        this.created = productComment.getCreated();
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("productId", getProduct());
    }

    // ========================================================================
    // setter/getter ==========================================================
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public UserDto getAuthor() {
        return author;
    }
    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
}
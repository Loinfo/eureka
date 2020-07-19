package com.xili.productservice.product.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * 商品评论信息定义
 *
 * @author CD826(CD826Dong@gmail.com)
 * @since 1.0.0
 */
@Entity
@Table(name = "tbProduct_Comment")
public class ProductComment implements Serializable {
    private static final long serialVersionUID = 1L;

    // ========================================================================
    // fields =================================================================
    @Id
    @GeneratedValue
    private Long id;
    private Long productId;                                     // 所属产品Id
    private Long authorId;                                      // 评论作者Id
    private String content;                                     // 评论内容
    private Date created;                                       // 创建时间

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("productId", getProductId());
    }

    // ========================================================================
    // setter/getter ==========================================================
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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
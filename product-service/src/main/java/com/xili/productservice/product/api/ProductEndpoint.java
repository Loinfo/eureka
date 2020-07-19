package com.xili.productservice.product.api;

import com.xili.productservice.product.entity.Product;
import com.xili.productservice.product.entity.ProductComment;
import com.xili.productservice.product.repository.ProductCommentRepository;
import com.xili.productservice.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品管理的Endpoint
 *
 * @author xili
 * @since 1.0.0
 */
@RestController
@RequestMapping("/products")
public class ProductEndpoint {
    protected Logger logger = LoggerFactory.getLogger(ProductEndpoint.class);

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCommentRepository productCommentRepository;

    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    /**
     * 获取商品列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> list() {
        return this.productRepository.findAll();
    }

    /**
     * 获取指定商品的详情
     * @param id 商品的Id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product detail(@PathVariable Long id){
        return this.productRepository.findOne(id);
    }

    /**
     * 获取指定商品的评论列表
     * @param id 商品的Id
     * @return
     */
    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public List<ProductCommentDto> comments(@PathVariable Long id){
        List<ProductComment> commentList = this.productCommentRepository.findByProductIdOrderByCreated(id);
        if (null == commentList || commentList.isEmpty())
            return Collections.emptyList();

        return commentList.stream().map((comment) -> {
            ProductCommentDto dto = new ProductCommentDto(comment);
            dto.setProduct(this.productRepository.findOne(comment.getProductId()));
            dto.setAuthor(this.loadUser(comment.getAuthorId()));
            return dto;
        }).collect(Collectors.toList());
    }

    /**
     * 通过RestTemplate加载评论作者的用户信息
     * @param userId 用户Id
     * @return
     */
    protected UserDto loadUser(Long userId) {
        UserDto userDto = this.restTemplate.getForEntity("http://USERSERVICE/users/{id}", UserDto.class, userId).getBody();
        return userDto;
    }
}
package com.xili.productservice.product.service;

import com.xili.productservice.product.api.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author xili
 * @since 2020/7/21 23:59
 **/
@FeignClient("USERSERVICE")
public interface UserService {

    /**
     * 这里是获取用户列表，注意请求的地址一定要与用户微服务所提供的地址一致
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<UserDto> findAll();

    /**
     * 获取用户详情，需要注意的是用户的主键也是通过pathvalue的方式传递的
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    UserDto load(@PathVariable("id") Long id);
}

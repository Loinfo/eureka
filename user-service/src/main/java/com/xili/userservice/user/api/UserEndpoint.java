package com.xili.userservice.user.api;

import com.xili.userservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理的Endpoint
 *
 * @author xinliang
 * @since 1.0.0
 */
@RestController
@RequestMapping("/users")
public class UserEndpoint {
    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> findAll(){
        return this.userService.findAll();
    }

    /**
     * 获取用户详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto detail(@PathVariable Long id){
        return this.userService.load(id);
    }

    /**
     * 更新用户详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public UserDto update(@PathVariable Long id, @RequestBody UserDto userDto){
        return this.userService.save(userDto);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id){
        this.userService.delete(id);
        return true;
    }
}

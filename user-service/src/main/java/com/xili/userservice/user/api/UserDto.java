package com.xili.userservice.user.api;

import com.google.common.base.MoreObjects;
import com.xili.userservice.user.entity.User;

import java.io.Serializable;


/**
 * 用户信息定义
 *
 * @author xinliang
 * @since 1.0.0
 */
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    // ========================================================================
    // fields =================================================================
    private Long id;
    private String nickname;                                // 昵称
    private String avatar;                                  // 用户头像
    /**
     * 用户服务器端口
     */
    private int userServicePort;

    public UserDto() {

    }

    public UserDto(User user, int userServicePort) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.avatar = user.getAvatar();
        this.userServicePort = userServicePort;
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("nickname", getNickname())
                .add("userServicePort", getUserServicePort());
    }

    // ========================================================================
    // setter/getter ==========================================================
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getUserServicePort() {
        return userServicePort;
    }

    public void setUserServicePort(int userServicePort) {
        this.userServicePort = userServicePort;
    }
}
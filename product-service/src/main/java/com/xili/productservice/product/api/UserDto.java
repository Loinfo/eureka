package com.xili.productservice.product.api;

import com.google.common.base.MoreObjects;

import java.io.Serializable;


/**
 * 用户信息定义
 *
 * @author xili
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

    public UserDto(Long id, String nickname, String avatar, int userServicePort) {
        this.id = id;
        this.nickname = nickname;
        this.avatar = avatar;
        this.userServicePort = userServicePort;
    }

    @Override
    public String toString() {
        return this.toStringHelper().toString();
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("userServicePort", getUserServicePort())
                .add("nickname", getNickname());
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
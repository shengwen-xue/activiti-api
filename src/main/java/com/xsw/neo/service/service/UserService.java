package com.xsw.neo.service.service;

import com.xsw.neo.service.model.dto.UserDTO;

import java.util.List;

/**
 * <p>
 * 用户服务类
 * </p>
 *
 * @author xueshengwen
 * @since 2020-12-18
 */
public interface UserService {

    /**
     * 获取用户信息
     *
     * @param userId 用户id
     * @return 用户列表
     */
    List<UserDTO> getUserInfo(String userId);

    String test1();

    String test2();

    String test3();
}
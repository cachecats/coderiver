package com.solo.coderiver.user.controller;

import com.solo.coderiver.user.common.UserInfoForComments;
import com.solo.coderiver.user.dataobject.UserInfo;
import com.solo.coderiver.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对其他服务提供数据的 controller
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    UserService userService;

    /**
     * 通过 userId 获取用户头像
     *
     * @param userId
     * @return
     */
    @GetMapping("/get-avatar")
    public UserInfoForComments getAvatarByUserId(@RequestParam("userId") String userId) {
        UserInfo info = userService.findById(userId);
        if (info == null){
            return null;
        }
        return new UserInfoForComments(info.getId(), info.getAvatar());
    }
}

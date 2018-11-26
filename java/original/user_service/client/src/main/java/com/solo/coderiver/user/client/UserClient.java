package com.solo.coderiver.user.client;

import com.solo.coderiver.user.common.UserInfoForComments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user")
public interface UserClient {

    @GetMapping("/user/get-avatar")
    UserInfoForComments getAvatarByUserId(@RequestParam("userId") String userId);
}

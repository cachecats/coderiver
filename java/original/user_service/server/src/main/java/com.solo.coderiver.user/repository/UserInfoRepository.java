package com.solo.coderiver.user.repository;

import com.solo.coderiver.user.dataobject.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    UserInfo findUserInfoById(String id);

    UserInfo findUserInfoByEmail(String email);

    @Override
    Page<UserInfo> findAll(Pageable pageable);

    Page<UserInfo> findAllByRoleAndExperience(Pageable pageable, Integer role, Integer experience);

    Page<UserInfo> findAllByRole(Pageable pageable, Integer role);

    Page<UserInfo> findAllByExperience(Pageable pageable, Integer experience);


}

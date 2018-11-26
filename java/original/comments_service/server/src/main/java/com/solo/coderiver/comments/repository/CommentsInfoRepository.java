package com.solo.coderiver.comments.repository;

import com.solo.coderiver.comments.dataobject.CommentsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsInfoRepository extends JpaRepository<CommentsInfo, String> {

    List<CommentsInfo> findByOwnerId(String ownerId);
}

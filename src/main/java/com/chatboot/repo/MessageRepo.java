package com.chatboot.repo;

import com.chatboot.model.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<MessageModel, Integer> {
}

package com.chatboot.repo;

import com.chatboot.model.ChatroomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatroomRepo extends JpaRepository<ChatroomModel, Integer> {
}

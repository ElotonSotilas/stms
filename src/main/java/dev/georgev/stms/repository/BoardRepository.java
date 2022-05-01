package dev.georgev.stms.repository;

import dev.georgev.stms.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("SELECT COUNT (board_id) FROM Task")
    long getTaskSize(Long id);

    @Query("SELECT COUNT (Project.owner_id) FROM Project")
    long getProjectSize(@Param("owner_id") Long id);

    @Query("SELECT COUNT (Board.members) FROM Board")
    long getMemberSize(@Param("account_id") Long id);
}

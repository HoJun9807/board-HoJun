package idusw.springboot.boardlhj.repository;

import idusw.springboot.boardlhj.entity.MemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<MemoEntity, Long> {

}

package idusw.springboot.boardHoJun.repository;

import idusw.springboot.boardHoJun.entity.MemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<MemoEntity, Long> {

}

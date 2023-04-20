package idusw.springboot.boardHoJun.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity // 엔티티 클래스임으로 나타내는 애노테이션
@Table(name = "b_member")

@ToString   // lombok 라이브러리 사용
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MemberEntity {
    // Entity : Service -> Repository -> Service 데이터 객체, Database 관전
    // Repository : Persistence Data 처리
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // Oracle : GenerationType.SEQUENCE, Mysql : GenerationType.IDENTITY
    // Oracle : sequence / Mysql : auto increment : 자동 증가 식별 번호
    private Long seq;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String pw;
}

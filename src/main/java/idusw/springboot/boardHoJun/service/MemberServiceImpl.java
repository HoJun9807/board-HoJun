package idusw.springboot.boardHoJun.service;

import idusw.springboot.boardHoJun.domain.Member;
import idusw.springboot.boardHoJun.domain.Memo;
import idusw.springboot.boardHoJun.entity.MemberEntity;
import idusw.springboot.boardHoJun.entity.MemoEntity;
import idusw.springboot.boardHoJun.repository.MemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public int create(Member m) {
        //DTO -> Entity : Repository에서 처리하기 위해
        MemberEntity entity = MemberEntity.builder()
                .seq(m.getSeq())
                .email(m.getEmail())
                .name(m.getName())
                .pw(m.getPw())
                .build();
       // MemberEntity entity = new MemberEntity(m.getSeq(), m.getEmail(), m.getName(), m.getPw());
        if(memberRepository.save(entity) != null) //저장 성공
            return 1;
        else
            return 0;
    }

    @Override
    public Member read(Member m) {
        MemberEntity e = memberRepository.getById(m.getSeq());
        Member result = new Member(); // DTO (Data Transfer Object) : Controller - Service or Controller - View
        result.setSeq(e.getSeq());
        result.setEmail(e.getEmail());
        result.setName(e.getName());
        return result;
    }


    @Override
    public  List<Member> readList() {
        //1. 매개변수를 처리(처리를 위한 객체 선언 및 초기화), repository 객체에게 전달
        //2. repository 객체의 해달 메소드가 처리한 결과를 반환 유형으로 변환
        //repository : entity 객체를 대상으로 한다. service : DTO or Domain 객체를 대상으로 한다.

        List<Member> result = new ArrayList<>();
        List<MemberEntity> entities = memberRepository.findAll();
        for(MemberEntity e : entities) {
            // Function Language 특징을 활용한 처리, Lambda 식, Lombok library 활용
            Member m = Member.builder()
                    .seq(e.getSeq())
                    .email(e.getEmail())
                    .name(e.getName())
                    .build();

            result.add(m);
        }

        return result;
    }


    @Override
    public int update(Member m) {
        return 0;
    }

    @Override
    public int delete(Member m) {
        return 0;
    }

    @Override
    public Member login(Member m) { //인터페이스에 선언된 메소드 중 구현하지 않은 메소드를 구현
        Member result = null;
        MemberEntity entity = memberRepository.getByEmailPw(m.getEmail(), m.getPw());
        if(entity != null) {
            result = new Member();
            result.setSeq(entity.getSeq());
            result.setEmail(entity.getEmail());
            result.setName(entity.getName());
            result.setPw(entity.getPw());
        }
        return result;
    }
}

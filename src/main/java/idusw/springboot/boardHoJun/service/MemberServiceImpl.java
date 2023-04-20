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
        Member member = Member.builder()
                .seq(e.getSeq())
                .email(e.getEmail())
                .name(e.getName())
                .pw(e.getPw())
                .build();
        return member;
    }

    @Override
    public  List<Member> readList() {
        List<Member> result = new ArrayList<>();
        List<MemberEntity> entities = memberRepository.findAll();
        for(MemberEntity e : entities) {
            Member member = Member.builder()
                    .seq(e.getSeq())
                    .email(e.getEmail())
                    .name(e.getName())
                    .build();
            result.add(member);
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
}

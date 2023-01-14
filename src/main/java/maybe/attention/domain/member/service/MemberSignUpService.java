package maybe.attention.domain.member.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.Member;
import maybe.attention.domain.member.exception.ExistsEmailException;
import maybe.attention.domain.member.presentation.dto.request.MemberSignUpRequest;
import maybe.attention.domain.member.repo.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberSignUpService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Transactional(rollbackFor = Exception.class)
    public void execute(MemberSignUpRequest request) {

        if(memberRepository.existsByEmail(request.getEmail()))
            throw new ExistsEmailException("이미 존재하는 이메일입니다.");

        Member member = Member.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .specialty(request.getSpecialty())
                .build();

        memberRepository.save(member);
    }
}


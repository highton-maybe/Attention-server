package maybe.attention.domain.member.service;

import lombok.RequiredArgsConstructor;
import maybe.attention.domain.member.Member;
import maybe.attention.domain.member.exception.MemberNotFoundException;
import maybe.attention.domain.member.facade.MemberFacade;
import maybe.attention.domain.member.presentation.dto.request.MemberLoginRequest;
import maybe.attention.domain.member.presentation.dto.response.TokenResponse;
import maybe.attention.domain.member.repo.MemberRepository;
import maybe.attention.global.security.jwt.JwtTokenProvider;
import maybe.attention.global.security.jwt.properties.JwtProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberLoginService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final MemberFacade memberFacade;;

    @Transactional(rollbackFor = Exception.class)
    public TokenResponse execute(MemberLoginRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new MemberNotFoundException("존재하지 않는 회원입니다."));

        memberFacade.checkPassword(member, request.getPassword());

        String accessToken = jwtTokenProvider.generatedAccessToken(request.getEmail());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(jwtTokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret()))
                .build();
    }
}
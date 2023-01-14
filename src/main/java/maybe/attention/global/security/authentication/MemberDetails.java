package maybe.attention.global.security.authentication;

import lombok.Getter;
import maybe.attention.domain.member.Member;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Getter
public class MemberDetails extends User {

    private final Member member;

    public MemberDetails(Member member) {
        super(member.getEmail(), member.getPassword(), List.of(new SimpleGrantedAuthority("MEMBER")));
        this.member = member;
    }
}
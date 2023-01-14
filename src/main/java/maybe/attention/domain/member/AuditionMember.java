package maybe.attention.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maybe.attention.domain.recruit.ContestRecruit;

import javax.persistence.*;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditionMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "audition_member_id", nullable = false)
    private Long auditionMemberId;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member auditionMember;

    @ManyToOne
    @JoinColumn(name = "recruit_id")
    private ContestRecruit contestRecruit;
}

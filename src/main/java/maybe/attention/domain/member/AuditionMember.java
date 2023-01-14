package maybe.attention.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maybe.attention.domain.recruit.ContestRecruit;

import javax.persistence.*;

@Entity
@Getter
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
    private ContestRecruit contestRecruit;
}
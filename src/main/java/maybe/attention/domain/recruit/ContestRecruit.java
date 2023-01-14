package maybe.attention.domain.recruit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maybe.attention.domain.member.AuditionMember;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContestRecruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contest_recruit_id", nullable = false)
    private Long contestRecruitId;

    @Column(name = "recruit_title")
    private String recruitTitle;

    @Column(name = "recruit_content")
    private String recruitContent;

    @Column(name = "recruit_start_date")
    private String recruitStartDate;

    @Column(name = "recruit_end_date")
    private String recruitEndDate;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "auditionMember")
    private List<AuditionMember> auditionMembers;
}
package maybe.attention.domain.recruit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maybe.attention.domain.member.AuditionMember;
import maybe.attention.domain.member.Member;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "auditionMember", cascade = CascadeType.PERSIST)
    private List<AuditionMember> auditionMembers = new ArrayList<>();

    public void updateContestRecruit(String recruitTitle, String recruitContent,
                                     String recruitStartDate, String recruitEndDate) {
        this.recruitTitle = recruitTitle != null ? recruitTitle : this.recruitTitle;
        this.recruitContent = recruitContent != null ? recruitContent : this.recruitContent;
        this.recruitStartDate = recruitStartDate != null ? recruitStartDate : this.recruitStartDate;
        this.recruitEndDate = recruitEndDate != null ? recruitEndDate : this.recruitEndDate;
    }

    public void addAuditionMember(AuditionMember auditionMember) {
        auditionMembers.add(auditionMember);
    }
}

package maybe.attention.domain.schedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maybe.attention.domain.member.Member;

import javax.persistence.*;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContestSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contest_schedule_id", nullable = false)
    private Long contestScheduleId;

    @Column(name = "schedule_title")
    private String scheduleTitle;

    @Column(name = "schedule_content")
    private String scheduleContent;

    @Column(name = "schedule_date")
    private String scheduleDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id")
    private Member member;

    public void updateContestSchedule(String scheduleTitle , String scheduleContent, String scheduleDate) {
        this.scheduleTitle = scheduleTitle != null ? scheduleTitle : this.scheduleTitle;
        this.scheduleContent = scheduleContent != null ? scheduleContent : this.scheduleContent;
        this.scheduleDate = scheduleDate != null ? scheduleDate : this.scheduleDate;
    }
}

package maybe.attention.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maybe.attention.domain.recruit.ContestRecruit;
import maybe.attention.domain.schedule.ContestSchedule;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "major")
    private String specialty;

    @Builder.Default
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "member")
    private List<ContestSchedule> schedules = new ArrayList<>();

    @Builder.Default
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "member")
    private List<ContestRecruit> recruits = new ArrayList<>();

    public void addSchedule(ContestSchedule contestSchedule) {
        schedules.add(contestSchedule);
    }

    public void addRecruit(ContestRecruit contestRecruit) {
        recruits.add(contestRecruit);
    }
}

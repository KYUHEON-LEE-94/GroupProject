package lee.GroupProject.domain.grade.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@SequenceGenerator(name = "grade_seq_gen", sequenceName = "grade_seq", allocationSize = 1)
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Grade {
	@Id
	@Column(name="grade_num")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grade_seq_gen")
	private Integer gradeNum;
	private String productNum;
	private String memberId;
	private Integer score;
}


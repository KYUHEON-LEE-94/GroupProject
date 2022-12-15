package lee.GroupProject.domain.member.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@DynamicInsert
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Members {
	@Id
	@Column(name="member_id")
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberEmail;
	private String phoneNum;
	private String homeNum;
	private String memberAddress;
	private LocalDateTime joinDate;
}


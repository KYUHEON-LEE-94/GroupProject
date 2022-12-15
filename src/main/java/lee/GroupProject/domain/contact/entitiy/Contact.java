package lee.GroupProject.domain.contact.entitiy;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@DynamicInsert
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Contact {
	@Id
	@Column(name="contact_num")
	private Integer contactNum;
	@Column(name="member_id")
	private String memberId;
	@Column(name="contact_name")
	private String contactName;
	@Column(name="contact_email")
	private String contactEmail;
	private String title;
	private String content;
}


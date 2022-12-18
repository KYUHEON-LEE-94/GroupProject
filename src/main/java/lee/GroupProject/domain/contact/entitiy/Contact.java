package lee.GroupProject.domain.contact.entitiy;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@SequenceGenerator(name = "contact_seq_gen", sequenceName = "contact_seq", allocationSize = 1)
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Contact {
	@Id
	@Column(name="contact_num")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq_gen")
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


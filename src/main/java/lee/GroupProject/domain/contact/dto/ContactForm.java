package lee.GroupProject.domain.contact.dto;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@SequenceGenerator(name = "contact_seq_gen", sequenceName = "contact_seq", allocationSize = 1)
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ContactForm {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq_gen")
	private Integer contactNum;
	private String memberId;

	@NotBlank(message = "문의하시는 분 성함을 입력해주세요")
	private String contactName;

	@NotBlank(message = "이메일을 입력해주세요")
	@Email(message = "이메일 형식을 확인해주세요")
	private String contactEmail;
	@NotBlank(message = "제목을 입력해주세요")
	private String title;
	@NotBlank(message = "내용을 상세하게 입력해주세요")
	private String content;
}


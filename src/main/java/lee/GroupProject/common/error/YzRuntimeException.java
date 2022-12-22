package lee.GroupProject.common.error;

import lombok.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
/**
 * 사용자 정의 예외 런타임 클래스
 * @author LEE KYUHEON
 */
public class YzRuntimeException extends RuntimeException {
	
	private String rediectUrl;

	private ErrorCode errorCode;


	public YzRuntimeException(String message, String rediectUrl) {
		super(message);
		this.rediectUrl = rediectUrl;
	}


}


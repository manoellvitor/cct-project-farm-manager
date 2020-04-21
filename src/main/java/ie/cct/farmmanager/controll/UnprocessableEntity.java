package ie.cct.farmmanager.controll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @author: Manoel Vitor Nascimento Lopes
 * @college: CCT College Dublin
 * @studentID: 2019286
 * */

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntity extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UnprocessableEntity(String message) {
		super(message);
	}

}

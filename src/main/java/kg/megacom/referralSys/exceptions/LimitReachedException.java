package kg.megacom.referralSys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.LOCKED)
public class LimitReachedException extends RuntimeException{

}

package projekt_bdbt.SpringApplication;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status!=null){
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode== HttpStatus.FORBIDDEN.value()){
                return "errors/403";
            }
            if(statusCode== HttpStatus.NOT_FOUND.value()){
                return "errors/404";
            }
            if(statusCode== HttpStatus.INTERNAL_SERVER_ERROR.value()){
                return "errors/500";
            }
            if(statusCode== HttpStatus.GATEWAY_TIMEOUT.value()){
                return "errors/504";
            }

        }
        return "errors/other";
    }
}

package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.spaceships.controller.SpaceShipController.getSpaceShipById(..)) && args(id)")
    public void logNegativeId(Long id) {
        if (id < 0) {
            System.out.println("Received negative id: " + id);
        }
    }
}

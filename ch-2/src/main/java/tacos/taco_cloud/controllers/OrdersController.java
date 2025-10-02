package tacos.taco_cloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import tacos.taco_cloud.domains.TacoOrder;



@Slf4j
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@Controller
public class OrdersController {

    @GetMapping("/current")
    public String orderForm() {   
        return "orderForm";
    }

    @PostMapping()
    public String postMethodName(@Valid TacoOrder tacoOrder,Errors errors, SessionStatus sessionStatus) {

        if(errors.hasErrors()){
            return "orderForm";
        }
        log.info("created order:" + tacoOrder);
        sessionStatus.setComplete();

        return "redirect:/";
        
    }
    
    

}

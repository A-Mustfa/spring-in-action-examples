package tacos.taco_cloud.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import tacos.taco_cloud.JDBC.JDBCIngredientRepository;
import tacos.taco_cloud.domains.Ingredients;
import tacos.taco_cloud.domains.Ingredients.Type;
import tacos.taco_cloud.domains.Taco;
import tacos.taco_cloud.domains.TacoOrder;





@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private final JDBCIngredientRepository jdbcIngredientRepository;

    @Autowired
    public DesignTacoController(JDBCIngredientRepository jdbcIngredientRepository) {
        this.jdbcIngredientRepository = jdbcIngredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredients> ingredients =  new ArrayList<>();

        jdbcIngredientRepository.findAll().forEach(i -> ingredients.add(i));

        Type [] type = Ingredients.Type.values();
        for(Type xtype : type){
            model.addAttribute(xtype.toString().toLowerCase(), filterByType(ingredients, xtype));
        }
    }

    @ModelAttribute("taco")
    private Taco createTaco(){
        return new Taco();
    }

    @ModelAttribute("tacoOrder")
    private TacoOrder createTacoOrder(){
        return new TacoOrder();
    }

    @GetMapping
    public String showDesignForm() {
        return "Design";
    }

    @PostMapping
    public String postMethodName(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {

        if(errors.hasErrors()){
            return "Design";
        }

        tacoOrder.addTaco(taco);
        log.info("processing taco: {}"+taco);

        return "redirect:/orders/current";
    }
    
    

    private Iterable<Ingredients> filterByType(List<Ingredients> ingredtients, Type type){
        return ingredtients.stream()
        .filter(x -> x.getType().equals(type))
        .collect(Collectors.toList());
    }


}
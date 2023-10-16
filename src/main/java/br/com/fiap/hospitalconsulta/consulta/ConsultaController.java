package br.com.fiap.hospitalconsulta.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {
    
    @Autowired
    ConsultaService service;

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user){
        model.addAttribute("avatar_url",user.getAttribute("avatar_url"));
        model.addAttribute("consultas", service.findAll());
        return "consulta/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        if (service.delete(id)){
            redirect.addFlashAttribute("success", "Consulta apagada com sucesso");
        }else{
            redirect.addFlashAttribute("error", "Consulta não encontrada");
        }
        return "redirect:/consulta";
    }

    @DeleteMapping
    public String deleteobject(Consulta consulta){
        System.out.println(consulta);
        return "redirect:/consulta";
    }

    @GetMapping("new")
    public String form(Consulta consulta){
        return "consulta/form";
    }

    @PostMapping
    public String save(@Valid Consulta consulta, BindingResult result, RedirectAttributes redirect){
        if (result.hasErrors()) return "/consulta/form";

        service.save(consulta);
        redirect.addFlashAttribute("success", "Consulta cadastrada com sucesso");
        return "redirect:/consulta";
    }
}

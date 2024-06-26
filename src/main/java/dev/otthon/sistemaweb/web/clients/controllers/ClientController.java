package dev.otthon.sistemaweb.web.clients.controllers;

import java.util.Map;
import java.util.NoSuchElementException;

import dev.otthon.sistemaweb.core.exceptions.ClientNotFoundException;
import dev.otthon.sistemaweb.web.clients.mappers.ClientMapper;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.otthon.sistemaweb.core.repositories.ClientRepository;
import dev.otthon.sistemaweb.web.clients.dtos.ClientForm;
import dev.otthon.sistemaweb.web.clients.dtos.ClientListItem;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // Cria os construtores com argumentos obrigatórios `final`, como o ClientRepository
@RequestMapping("/clients")
public class ClientController {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @GetMapping
    public ModelAndView index() {
        var clients = clientRepository.findAll()
            .stream()
            .map(clientMapper::toClientListItem)
            .toList();
            
        var model = Map.of("clients", clients);
        return new ModelAndView("clients/index", model);
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/create")
    public ModelAndView create() {
        var model = Map.of(
            "clientForm", new ClientForm(),
            "pageTitle", "Cadastro de Cliente"
        );
        return new ModelAndView("clients/form", model);
    }
//    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public String create(@Valid ClientForm clientForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Cadastro de Cliente");
            return "clients/form";
        }

        var client = clientMapper.toClient(clientForm);
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        var clientForm = clientRepository.findById(id)
            .map(clientMapper::toClientForm)
            .orElseThrow(ClientNotFoundException::new);
        var model = Map.of(
            "clientForm", clientForm,
            "pageTitle", "Edição de Cliente"
        );
        return new ModelAndView("clients/form", model);
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id, @Valid ClientForm clientForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Cadastro de Cliente");
            return "clients/form";
        }

        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException();
        }
        var client = clientMapper.toClient(clientForm);
        client.setId(id);
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException();
        }
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }
    
}

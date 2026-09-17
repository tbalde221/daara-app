package sn.tbalde.daara_app.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import lombok.AllArgsConstructor;
import sn.tbalde.daara_app.entities.Talibe;
import sn.tbalde.daara_app.entities.Classe;
import sn.tbalde.daara_app.entities.Progression;
import sn.tbalde.daara_app.repositories.ClasseRepository;
import sn.tbalde.daara_app.repositories.TalibeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class TalibeController {
    TalibeRepository talibeRepository;
    ClasseRepository classeRepository;

    @GetMapping("/listTalibe")
    public String listTalibe(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "") String keyword,
            @RequestParam(name = "size", defaultValue = "6") int size) {
        Page<Talibe> talibes = talibeRepository.findByNomContainsIgnoreCaseOrPrenomContainsIgnoreCase(keyword, keyword,
                PageRequest.of(page, size));
        model.addAttribute("listTalibe", talibes);
        model.addAttribute("pages", new int[talibes.getTotalPages()]);
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", page);
        return "talibe/talibe";
    }

    @GetMapping("/formTalibe")
    public String formTalibe(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Talibe talibe = new Talibe();
        talibe.setIdTalibe(UUID.randomUUID().toString());
        List<Classe> classes = classeRepository.findAll();
        model.addAttribute("talibe", talibe);
        model.addAttribute("listClasse", classes);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "talibe/formTalibe";
    }

    @PostMapping("/saveTalibe")
    public String save(Talibe talibe, @RequestParam(name = "codeClasse") String codeClasse,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "") String keyword, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "talibe/talibe";
        }
        Classe classe = classeRepository.findById(codeClasse).get();
        talibe.setClasse(classe);
        talibeRepository.save(talibe);
        return "redirect:/listTalibe?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/editTalibe")
    public String editTalibe(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "id") String idTalibe,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Talibe talibe = talibeRepository.findById(idTalibe).orElse(null);
        if (talibe == null) {
            throw new RuntimeException("Talibé Introuvable.");
        }
        List<Classe> classes = classeRepository.findAll();
        model.addAttribute("talibe", talibe);
        model.addAttribute("listClasse", classes);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "talibe/editTalibe";
    }

    @GetMapping("/deleteTalibe")
    public String deleteTalibe(@RequestParam(name = "id") String idTalibe,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        talibeRepository.deleteById(idTalibe);
        return "redirect:/listTalibe?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/exportTalibeCsv")
    public void exportProgressionCsv(
            @RequestParam(name = "keyword", defaultValue = "") String keyword,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setCharacterEncoding("UTF-8");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=talibe.csv");

        List<Talibe> talibes;

        if (keyword == null || keyword.isBlank()) {
            talibes = talibeRepository.findAll();
        } else {
            talibes = talibeRepository.findByNomContainsIgnoreCase(keyword);
        }

        PrintWriter writer = response.getWriter();

        // Pour une meilleure compatibilité avec Excel
        writer.write('\uFEFF');

        writer.println("N°;Nom;Prénom;Date Naissance;Nom Tuteur;Téléphone tuteur");

        int compteur = 1;

        for (Talibe talibe : talibes) {
            writer.println(
                    compteur++ + ";" +
                            talibe.getNom() + ";" +
                            talibe.getPrenom() + ";" +
                            talibe.getDateNaissance() + ";" +
                            talibe.getNomTuteur() + ";" +
                            talibe.getTelephoneTuteur());
        }

        writer.flush();
    }

}

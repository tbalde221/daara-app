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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import sn.tbalde.daara_app.entities.Classe;
import sn.tbalde.daara_app.entities.Maitre;
import sn.tbalde.daara_app.repositories.ClasseRepository;
import sn.tbalde.daara_app.repositories.MaitreRepository;

@Controller
@AllArgsConstructor
public class ClasseController {
    ClasseRepository classeRepository;
    MaitreRepository maitreRepository;

    @GetMapping("/listClasse")
    public String listClasse(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "6") int size,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Classe> classes = classeRepository.findByLibelleContainsIgnoreCase(keyword, PageRequest.of(page, size));
        model.addAttribute("listClasse", classes);
        model.addAttribute("pages", new int[classes.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "classe/classe";
    }

    @GetMapping("/editClasse")
    public String editClasse(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "id") String id, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Classe classe = classeRepository.findById(id).orElse(null);
        if (classe == null) {
            throw new RuntimeException("Classe Introuvable.");
        }
        List<Maitre> listMaitre = maitreRepository.findAll();
        model.addAttribute("currentPage", page);
        model.addAttribute("classe", classe);
        model.addAttribute("keyword", keyword);
        model.addAttribute("id", id);
        model.addAttribute("listMaitre", listMaitre);
        return "classe/editClasse";
    }

    @PostMapping("/saveClasse")
    public String save(Model model, @Valid Classe classe, BindingResult bindingResult,
            @RequestParam(name = "page", defaultValue = "0") int page, @RequestParam() String keyword,
            @RequestParam(name = "idMaitre") String idMaitre) {
        if (bindingResult.hasErrors()) {
            return "accueil";
        }
        Maitre maitre = maitreRepository.findById(idMaitre).get();
        classe.setMaitre(maitre);
        classeRepository.save(classe);
        return "redirect:/listClasse?pge=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/deleteClasse")
    public String deleteClasse(String id, int page, String keyword) {
        classeRepository.deleteById(id);
        return "redirect:/listClasse?pge=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/formClasse")
    public String formClasse(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Classe classe = new Classe();
        classe.setCodeClasse(UUID.randomUUID().toString());
        List<Maitre> maitres = maitreRepository.findAll();
        model.addAttribute("classe", classe);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("listMaitre", maitres);
        return "classe/formClasse";
    }

    @GetMapping("/exportClasseCsv")
    public void exportClasseCsv(@RequestParam(name = "keyword", defaultValue = "") String keyword,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setCharacterEncoding("UTF-8");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=classes.csv");

        List<Classe> classes;

        if (keyword == null || keyword.isBlank()) {
            classes = classeRepository.findAll();
        } else {
            classes = classeRepository.findByLibelleContainsIgnoreCase(keyword);
        }

        PrintWriter writer = response.getWriter();

        // Pour une meilleure compatibilité avec Excel
        writer.write('\uFEFF');

        writer.println("N°;Libelle;Niveau;Maitre");

        int compteur = 1;

        for (Classe classe : classes) {
            Maitre maitre = classe.getMaitre();
            writer.println(
                    compteur++ + ";" +
                            classe.getLibelle() + ";" +
                            classe.getNiveau() + ";" +
                            maitre.getPrenom() + " " + maitre.getNom());
        }

        writer.flush();

    }

}

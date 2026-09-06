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
import sn.tbalde.daara_app.entities.Maitre;
import sn.tbalde.daara_app.repositories.MaitreRepository;

@Controller
@AllArgsConstructor
public class MaitreController {
    final MaitreRepository maitreRepository;

    @GetMapping("/listMaitre")
    public String listMaitre(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "6") int size,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Maitre> maitres = maitreRepository.findByNomContainsIgnoreCase(keyword, PageRequest.of(page, size));
        model.addAttribute("listMaitre", maitres);
        model.addAttribute("pages", new int[maitres.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "maitre/maitre";
    }

    @GetMapping("/")
    public String acceuil() {
        return "accueil";
    }

    @GetMapping("/deleteMaitre")
    public String delete(String id, int page, String keyword) {
        maitreRepository.deleteById(id);
        return "redirect:/listMaitre?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/editMaitre")
    public String editMaitre(Model model, @RequestParam(name = "id") String id,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Maitre maitre = maitreRepository.findById(id).orElse(null);
        if (maitre == null) {
            throw new RuntimeException("Maitre Introuvable.");
        }
        model.addAttribute("maitre", maitre);
        model.addAttribute("keyword", keyword);
        model.addAttribute("id", id);
        model.addAttribute("currentPage", page);
        return "maitre/editMaitre";
    }

    @PostMapping("/saveMaitre")
    public String save(Model model, @Valid Maitre maitre, BindingResult bindingResult,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        if (bindingResult.hasErrors()) {
            return "accueil";
        }
        maitreRepository.save(maitre);
        return "redirect:/listMaitre?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/formMaitre")
    public String formMaitre(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Maitre maitre = new Maitre();
        maitre.setIdMaitre(UUID.randomUUID().toString());
        model.addAttribute("maitre", maitre);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "maitre/formMaitre";
    }

    @GetMapping("/exportMaitreCsv")
    public void exportMaitreCsv(
            @RequestParam(name = "keyword", defaultValue = "") String keyword,
            HttpServletResponse response) throws IOException {

        response.setContentType("text/csv");
        response.setCharacterEncoding("UTF-8");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=maitres.csv");

        List<Maitre> maitres;

        if (keyword == null || keyword.isBlank()) {
            maitres = maitreRepository.findAll();
        } else {
            maitres = maitreRepository.findByNomContainsIgnoreCase(keyword);
        }

        PrintWriter writer = response.getWriter();

        // Pour une meilleure compatibilité avec Excel
        writer.write('\uFEFF');

        writer.println("N°;Nom;Prenom;Telephone");

        int compteur = 1;

        for (Maitre maitre : maitres) {
            writer.println(
                    compteur++ + ";" +
                            maitre.getNom() + ";" +
                            maitre.getPrenom() + ";" +
                            maitre.getTelephone());
        }

        writer.flush();
    }
}

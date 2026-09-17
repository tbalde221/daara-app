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
import sn.tbalde.daara_app.entities.*;
import sn.tbalde.daara_app.repositories.ProgressionRepository;
import sn.tbalde.daara_app.repositories.TalibeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProgressionController {
    ProgressionRepository progressionRepository;
    TalibeRepository talibeRepository;

    @GetMapping("/listProgression")
    public String listProgression(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "6") int size,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Progression> progressions = progressionRepository.findBySourateContainsIgnoreCase(keyword,
                PageRequest.of(page, size));
        model.addAttribute("listProgression", progressions);
        model.addAttribute("pages", new int[progressions.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "progression/progression";
    }

    @GetMapping("/formProgression")
    public String formProgression(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Progression progression = new Progression();
        List<Talibe> listTalibe = talibeRepository.findAll();
        progression.setIdProgression(UUID.randomUUID().toString());
        model.addAttribute("progression", progression);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("listTalibe", listTalibe);
        return "progression/formProgression";
    }

    @PostMapping("/saveProgression")
    public String save(Model model, Progression progression, @RequestParam(name = "idTalibe") String idTalibe,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "") String keyword, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "";
        }
        Talibe talibe = talibeRepository.findById(idTalibe).orElse(null);
        progression.setTalibe(talibe);
        progressionRepository.save(progression);

        return "redirect:/listProgression?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/editProgression")
    public String editProgression(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "") String keyword,
            @RequestParam(name = "id") String idProgression) {
        Progression progression = progressionRepository.findById(idProgression).orElse(null);
        if (progression == null) {
            throw new RuntimeException("Progression Introuvable.");
        }
        List<Talibe> listTalibe = talibeRepository.findAll();
        model.addAttribute("progression", progression);
        model.addAttribute("listTalibe", listTalibe);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "progression/editProgression";
    }

    @GetMapping("/deleteProgression")
    public String deleteProgression(String id, @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        progressionRepository.deleteById(id);
        return "redirect:/listProgression?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/exportProgressionCsv")
    public void exportProgressionCsv(
            @RequestParam(name = "keyword", defaultValue = "") String keyword,
            HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setCharacterEncoding("UTF-8");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=progression.csv");

        List<Progression> progressions;

        if (keyword == null || keyword.isBlank()) {
            progressions = progressionRepository.findAll();
        } else {
            progressions = progressionRepository.findBySourateContainsIgnoreCase(keyword);
        }

        PrintWriter writer = response.getWriter();

        // Pour une meilleure compatibilité avec Excel
        writer.write('\uFEFF');

        writer.println("N°;Sourate;Nombre de versers;Apréciation;Date d'évaluation");

        int compteur = 1;

        for (Progression progression : progressions) {
            writer.println(
                    compteur++ + ";" +
                            progression.getSourate() + ";" +
                            progression.getNombreVersets() + ";" +
                            progression.getApreciation() + ";" +
                            progression.getDateEvaluation());
        }

        writer.flush();
    }

}

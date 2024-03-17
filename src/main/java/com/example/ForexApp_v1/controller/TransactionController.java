package com.example.ForexApp_v1.controller;

import com.example.ForexApp_v1.model.CustomUser;
import com.example.ForexApp_v1.model.Transac;
import com.example.ForexApp_v1.model.TransacDTO;
import com.example.ForexApp_v1.model.UploadedFile;
import com.example.ForexApp_v1.service.CustomUserService;
import com.example.ForexApp_v1.service.TransacService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.net.ssl.HandshakeCompletedEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class TransactionController {
    private final TransacService transacService = new TransacService();
    private List<TransacDTO> transacDTOList = new ArrayList<>();

    private LocalDate day = ((LocalDate.now()).minusDays(1));

    private final CustomUserService customUserService = new CustomUserService();

    @GetMapping("/singleTransaction")
    public String showToSingleTransaction(Model model) {
        try {
            model.addAttribute("day", day);
            model.addAttribute("transacDTO", new TransacDTO());
//            return new ModelAndView("singleTransaction", model.asMap());
            return "singleTransaction";
        }catch (NullPointerException npe) {
            npe.printStackTrace();
//            return new ModelAndView("singleTransaction", model.asMap());
            return "singleTransaction";

        }
    }

    @PostMapping("/singleTransaction")
    public String addToSingleTransaction(final @Valid @ModelAttribute("transacDTO") TransacDTO transacDTO, final Model model, final BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "singleTransaction";
        }
        try {
            TransacDTO transac = transacService.addTransaction(transacDTO);
            model.addAttribute("transac", transac);
            return "singleTransaction";
        }catch (ConstraintViolationException cve){
            cve.printStackTrace();
            return "singleTransaction";
        }catch (NullPointerException npe) {
            npe.printStackTrace();
            return "singleTransaction";
        }
    }

    @GetMapping("/manyTransactions")
    public String addToManyTransactions(final Model model){
        try {
            model.addAttribute("day", day);
            model.addAttribute("transacDTOList", transacDTOList);
            model.addAttribute("newTransacDTO", new TransacDTO());
            return "manyTransactions";
        }catch (NullPointerException npe) {
            npe.printStackTrace();
            return "manyTransactions";
        }
    }

    @PostMapping("/addTransactions")
    public String showCreateFormTransactions(final @ModelAttribute(name = "transacDTO") TransacDTO transacDTO, final BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "manyTransactions";
        }
        try {
            transacDTOList.add(transacDTO);
            return "redirect:/manyTransactions";
        }catch (NullPointerException npe){
            npe.printStackTrace();
            return "manyTransactions";
        }
    }

    @PostMapping("/calculateTransactions")
    public String showMultipleTransactions(final Model model) {
        try {
            List<TransacDTO> resultTransacList = transacService.addManyTransactions(transacDTOList);
            transacDTOList.clear();
            model.addAttribute("resultTransacList", resultTransacList);
            return "showResultTransactions";
        }catch (NullPointerException npe) {
            npe.printStackTrace();
            return "calculateTransactions";
        }catch (ConstraintViolationException cve) {
            cve.printStackTrace();
            return "calculateTransactions";
        }
    }

    @GetMapping("/readerFile")
    public String loadFile(Model model){

        return "loadFile";
    }
    @PostMapping("/readerFile")
    public String loadFile(@ModelAttribute UploadedFile uploadedFile) {
        MultipartFile file = uploadedFile.getFile();

        if (!file.isEmpty()) {
            return "index"; //odczytać zawartość pliku,
            //ustalić format pliku i jak go czytać
            // czy lepiej do bazy zapisac plik a potem go w metodzie czytac ??

        }else {
            return "index"; //błąd jeśli plik jest pusty - wyswietlic komunikakt
        }
    }
}
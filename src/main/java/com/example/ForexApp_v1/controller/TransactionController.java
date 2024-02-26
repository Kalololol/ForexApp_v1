package com.example.ForexApp_v1.controller;

import com.example.ForexApp_v1.model.Transac;
import com.example.ForexApp_v1.model.TransacDTO;
import com.example.ForexApp_v1.model.UploadedFile;
import com.example.ForexApp_v1.service.TransacService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@Controller
@Validated
public class TransactionController {
    private final TransacService transacService;
    private List<TransacDTO> transacDTOList = new ArrayList<>();
    public TransactionController(TransacService transacService) {
        this.transacService = transacService;
    }
    @GetMapping("/singleTransaction")
    public String showToSingleTransaction(Model model) {
        try {
            model.addAttribute("transacDTO", new TransacDTO());
            return "singleTransaction";
        }catch (Exception e){
            e.printStackTrace();
            return "index"; // wstawić stronę że błąd
        }
    }

    @PostMapping("/singleTransaction")
        public String addToSingleTransaction(@Valid @ModelAttribute("transacDTO") TransacDTO transacDTO, Model model, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "singleTransaction";
        }
        try {
          Transac transac = transacService.addTransaction(transacDTO);
          model.addAttribute("transac", transac);
          return "singleTransaction";
      }catch (ConstraintViolationException cve){
            cve.printStackTrace();
            return "index";
        }
        catch (Exception e){
          e.printStackTrace();
            return "index"; // strona z błędem
        }
    }

    @GetMapping("/manyTransactions")
    public String addToManyTransactions(Model model){

        try {
            model.addAttribute("transacDTOList", transacDTOList);
            model.addAttribute("newTransacDTO", new TransacDTO());

            return "manyTransactions";
        }catch (Exception e){
            return "index";
        }
    }

    @PostMapping("/addTransactions")
    public String showCreateFormTransactions(@Valid @ModelAttribute(name = "transacDTO") TransacDTO transacDTO,  BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "index";
//            return "redirect:/manyTransactions";
        }
        try {
            transacDTOList.add(transacDTO);
            return "redirect:/manyTransactions";
        }catch (Exception e){
            e.printStackTrace();
            return "index";
        }
    }
    @PostMapping("/calculateTransactions")
    public String showMultipleTransactions(Model model) {
        try {
            List<Transac> resultTransacList = transacService.addManyTransactions(transacDTOList);
            transacDTOList.clear();

            model.addAttribute("resultTransacList", resultTransacList);
            return "showResultTransactions";
        }catch (Exception e){
            e.printStackTrace();
            return "index";
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

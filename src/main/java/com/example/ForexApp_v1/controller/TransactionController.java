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

    //w przypadku pojedynczego obiketu wykorzystać walidacje

    //obiekt przejsiowy, ktory zawiera cutomowy walidator
    // List<TransacDTO> transacList
    // napisac swoj wlasny walidator


    //if (bindingResult.hasErrors()) {
    //			return "form";
    //		}



    //    //adnotacja aby sprawdzać czy dane nie są puste bądź nullem ---np noEmpty
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
          return "singleTransaction";  // wstawić stronę że błąd
      }
    }

    //
//    @PostMapping("/addValidatePhone")
//    public String submitForm(@Valid ValidatedPhone validatedPhone,
//      BindingResult result, Model m) {
//        if(result.hasErrors()) {
//            return "phoneHome";
//        }
//        m.addAttribute("message", "Successfully saved phone: "
//          + validatedPhone.toString());
//        return "phoneHome";
//    }

    @GetMapping("/manyTransactions")
    public String addToManyTransactions(Model model){

        model.addAttribute("transacDTOList", transacDTOList);
        model.addAttribute("newTransacDTO", new TransacDTO());

        return "manyTransactions";
    }

    @PostMapping("/addTransactions")
    public String showCreateFormTransactions(@Valid @ModelAttribute(name = "transacDTO") TransacDTO transacDTO,  BindingResult bindingResult){

        if (bindingResult.hasErrors()) {

            return "redirect:/manyTransactions";
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
//     @PostMapping
//    public String create(@Valid @ModelAttribute(name = "note") NoteModel note,
//                         BindingResult bindingResult) {
//        LOGGER.info("create(" + note + ")");
//
//        if (bindingResult.hasErrors()) {
//            LOGGER.info("validation errors in Model: " + note);
//            LOGGER.info("validation errors: " + bindingResult.getAllErrors());
//            return "notes/create-note";
//        }
//
//        notes.add(note);
//        return "redirect:/notes";
//    }
//
//    @PostMapping("/singleTransaction")
//    ResponseEntity<String> addManyTransaction(@Valid @RequestBody List<TransacDTO> transacDTOList, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            StringBuilder errors = new StringBuilder();
//            bindingResult.getFieldErrors().forEach(error ->
//                    errors.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("\n")
//            );
//            return ResponseEntity.badRequest().body(errors.toString());
//        }
//
//        List<Transac> resultTransacList = transacService.addManyTransactions(transacDTOList);
//        transacDTOList.clear();
//
//        return ResponseEntity.ok("User is valid");
//
//    }

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

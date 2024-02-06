package com.example.ForexApp_v1.controller;

import com.example.ForexApp_v1.model.Transac;
import com.example.ForexApp_v1.model.TransacDTO;
import com.example.ForexApp_v1.model.UploadedFile;
import com.example.ForexApp_v1.service.TransacService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TransactionController {
    private final TransacService transacService;
    private List<TransacDTO> transacDTOList = new ArrayList<>();
    public TransactionController(TransacService transacService) {
        this.transacService = transacService;
    }

    //adnotacja aby sprawdzać czy dane nie są puste bądź nullem ---np noEmpty
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
    public String addToSingleTransaction(@ModelAttribute("transacDTO") TransacDTO transacDTO, Model model){
      try {
          Transac transac = transacService.addTransaction(transacDTO);
          model.addAttribute("transac", transac);
          return "singleTransaction";
      }catch (Exception e){
          e.printStackTrace();
          return "index";  // wstawić stronę że błąd
      }
    }
    @GetMapping("/manyTransactions")
    public String addToManyTransactions(Model model){

        model.addAttribute("transacDTOList", transacDTOList);
        model.addAttribute("newTransacDTO", new TransacDTO());

        return "manyTransactions";
    }

    @PostMapping("/addTransactions")
    public String showCreateFormTransactions(@ModelAttribute TransacDTO transacDTO){
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

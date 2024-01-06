package com.example.ForexApp_v1.controller;

import com.example.ForexApp_v1.api.CurrencyDownloadApi;
import com.example.ForexApp_v1.logic.CalculateTransaction;
import com.example.ForexApp_v1.model.Transac;
import com.example.ForexApp_v1.model.TransacDTO;
import com.example.ForexApp_v1.service.TransacService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TransactionController {
//    private final CurrencyDownloadApi currencyDownloadApi;
//    private final CalculateTransaction calculateTransaction;
    private final TransacService transacService;

    public TransactionController(TransacService transacService) {
        this.transacService = transacService;
    }

//    public TransactionController(CurrencyDownloadApi currencyDownloadApi, CalculateTransaction calculateTransaction) {
//        this.currencyDownloadApi = currencyDownloadApi;
//        this.calculateTransaction = calculateTransaction;
//    }
    //adnotacja aby sprawdzać czy dane nie są puste bądź nullem ---np noEmpty
    @GetMapping("/singleTransaction")
    public String showToSingleTransaction(Model model) {
        model.addAttribute("transacDTO", new TransacDTO());
        return "singleTransaction";
    }
    @PostMapping("/singleTransaction")
    public String addToSingleTransaction(@ModelAttribute("transacDTO") TransacDTO transacDTO, Model model){
      try {
          //String date = (transacDTO.getDateTransaction().toString()).substring(0,10);
          //Transac transac = calculateTransaction.manualCalculate(transacDTO.getValueCurrency(), transacDTO.getCodeCurrency(), date);
          Transac transac = transacService.addTransaction(transacDTO);
          model.addAttribute("transac", transac);
          return "singleTransaction";
      }catch (Exception e){
          e.printStackTrace();
          return "index";
      }
    }
    @GetMapping("/manyTransactions")
    public String showToManyTransactions(){
        return "manyTransactions";
    }
//    @PostMapping("/manyTransactions")
//    public String addToManyTransactions(){
//        return "/addToManyTransactions";
//    }

    @GetMapping("/showTransactions")
    public String showMultipleTransactions(Model model) {
        List<Transac> lista = new ArrayList<Transac>(); // pobranie listy z bazy danych

        model.addAttribute("transacList", lista);
        return "multipleTransactions";
    }
}

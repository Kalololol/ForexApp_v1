package com.example.ForexApp_v1.logic;

import com.example.ForexApp_v1.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class JsonMapper {
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    public List<TransacDTO> jsonMapToTransacDTOList(String objectJson){
        try {
            if (objectJson == null) {
                return null;
            }
            List<TransacDTO> transacDTOList = objectMapper.readValue(objectJson, new TypeReference<List<TransacDTO>>(){});

            return transacDTOList;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Currency jsonMapToCurrency(String objectJson){
        try {
            if (objectJson == null) {
                return null;
            }
            CurrencyDTO currencyDTO = objectMapper.readValue(objectJson, CurrencyDTO.class);
            List<RateDTO> rateDTOList = currencyDTO.getRates();
            RateDTO rateDTO = rateDTOList.get(0);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(rateDTO.getEffectiveDate(), formatter);

            Currency result = new Currency(date, currencyDTO.getCode(), rateDTO.getMid());
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String currencyMapToJson (Currency currency){
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
            objectMapper.setDateFormat(df);
            return objectMapper.writeValueAsString(currency);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
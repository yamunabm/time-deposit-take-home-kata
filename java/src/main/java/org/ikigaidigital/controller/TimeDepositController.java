package org.ikigaidigital.controller;

import lombok.extern.slf4j.Slf4j;
import org.ikigaidigital.model.TimeDepositDto;
import org.ikigaidigital.service.TimeDepositService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/time-deposits")
@Slf4j
public class TimeDepositController {

    private final TimeDepositService timeDepositService;

    public TimeDepositController(TimeDepositService timeDepositService) {
        this.timeDepositService = timeDepositService;
    }

    @GetMapping
    public ResponseEntity<List<TimeDepositDto>> getAll() {
        try {
            List<TimeDepositDto> deposits = timeDepositService.getAll();
            return ResponseEntity.ok(deposits);
        } catch (Exception e) {
            log.error("Error getting all the time deposits", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/calculate-balance")
    public ResponseEntity<Void> calculateBalances() {
        try {
            timeDepositService.recalculateAllBalances();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error("Error calculating/updating balances", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

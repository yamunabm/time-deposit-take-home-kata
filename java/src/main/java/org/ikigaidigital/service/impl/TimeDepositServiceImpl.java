package org.ikigaidigital.service.impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ikigaidigital.calculator.TimeDepositCalculator;
import org.ikigaidigital.mapper.TimeDepositMapper;
import org.ikigaidigital.model.TimeDepositDto;
import org.ikigaidigital.repository.TimeDepositRepository;
import org.ikigaidigital.service.TimeDepositService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TimeDepositServiceImpl implements TimeDepositService {

    private final TimeDepositRepository repository;
    private final TimeDepositCalculator timeDepositCalculator;

    @Override
    public List<TimeDepositDto> getAll() {
        return repository.findAll().stream()
                .map(TimeDepositMapper::of)
                .collect(Collectors.toList());
    }

    @Override
    public void recalculateAllBalances() {
        List<TimeDepositDto> allDeposits = this.getAll();
        timeDepositCalculator.updateBalance(allDeposits);
        repository.saveAll(TimeDepositMapper.of(allDeposits));
    }
}

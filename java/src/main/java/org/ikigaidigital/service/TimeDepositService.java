package org.ikigaidigital.service;

import org.ikigaidigital.model.TimeDepositDto;

import java.util.List;

public interface TimeDepositService {
    List<TimeDepositDto> getAll();

    void recalculateAllBalances();
}

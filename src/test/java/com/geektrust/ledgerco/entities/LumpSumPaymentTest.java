package com.geektrust.ledgerco.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Lump Sum Payment test")
class LumpSumPaymentTest {

    @DisplayName("Save Lump sum payment test")
    @Test
    void saveLumpSumPaymentTest() {
        LumpSumPayment lumpSumPaymentTest = new LumpSumPayment(1000, 4);
        assertEquals(2, lumpSumPaymentTest.getNumberOfEmiReducedForLumpSumPayment(500));
    }
}

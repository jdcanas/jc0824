package com.point_of_sale.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.point_of_sale.checkout.model.InvalidRentalAgreement;
import com.point_of_sale.checkout.model.UserRentalAgreementInput;

@SpringBootTest
public class UserRentalAgreementInputTest {
    // @Test
    // public void testMoneyAgreement_NegativeDaysValidation() throws InvalidRentalAgreement {
    //     assertThrows(InvalidRentalAgreement.class, () -> new UserRentalAgreementInput("CHNS", -1, 0, LocalDateTime.now()));
    // }

    // @Test
    // public void testMoneyAgreement_ZeroDaysValidation() throws InvalidRentalAgreement {
    //     assertThrows(InvalidRentalAgreement.class, () -> new UserRentalAgreementInput("CHNS", 0, 0, LocalDateTime.now()));
    // }

    // @Test
    // public void testMoneyAgreement_DiscountValidation() throws InvalidRentalAgreement {
    //     assertThrows(InvalidRentalAgreement.class, () -> new UserRentalAgreementInput("CHNS",1, -1, LocalDateTime.now()));
    // }

    // @Test
    // public void testMoneyAgreement_Valid() throws InvalidRentalAgreement {
    //     new UserRentalAgreementInput("CHNS",1, 0, LocalDateTime.now());
    // }
}

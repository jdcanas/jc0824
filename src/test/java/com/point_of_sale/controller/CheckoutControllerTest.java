package com.point_of_sale.controller;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.point_of_sale.checkout.controller.CheckoutController;
import com.point_of_sale.checkout.model.InvalidRentalAgreement;
import com.point_of_sale.checkout.model.RentalAgreement;
import com.point_of_sale.checkout.model.ToolType;
import com.point_of_sale.checkout.model.UserRentalAgreementInput;

@SpringBootTest
public class CheckoutControllerTest {
    @Autowired
    CheckoutController controller;

    @Test
    public void test_noHolidaysOnlyChargeOnWeekdays() {
        RentalAgreement agreement = controller.getAgreement(new UserRentalAgreementInput("CHNS", 5, 20, "04-25-2022"));
        assertEquals(ToolType.ChainSaw, agreement.getTool().getType());
        assertEquals("Stihl", agreement.getMetadata().brand());
        assertEquals(5, agreement.getRentalDays().rentalDays());
        assertEquals(4, agreement.getRentalDays().chargeDays());
        assertEquals(UserRentalAgreementInput.convert("04-25-2022"), agreement.getRentalDays().checkoutDate());
        assertEquals(UserRentalAgreementInput.convert("04-30-2022"), agreement.getRentalDays().checkoutDate().plusDays(agreement.getRentalDays().rentalDays()));
        assertEquals(new BigDecimal("5.96"), agreement.getPrice().originalPrice());
        assertEquals(new BigDecimal("4.77"), agreement.getPrice().finalPrice());
        assertEquals(20, agreement.getPrice().discountPercent());
        assertEquals(new BigDecimal("1.19"), agreement.getPrice().discountAmount());
    }

    

    @Test 
    public void test_multiYearAgreementWithNoHolidayCharge() {
        RentalAgreement agreement = controller.getAgreement(new UserRentalAgreementInput("LADW", 400, 10, "07-02-2020"));
        assertEquals(ToolType.Ladder, agreement.getTool().getType());
        assertEquals("Werner", agreement.getMetadata().brand());
        assertEquals(400, agreement.getRentalDays().rentalDays());
        assertEquals(397, agreement.getRentalDays().chargeDays());
        assertEquals(UserRentalAgreementInput.convert("07-02-2020"), agreement.getRentalDays().checkoutDate());
        assertEquals(UserRentalAgreementInput.convert("08-06-2021"), agreement.getRentalDays().checkoutDate().plusDays(agreement.getRentalDays().rentalDays()));
        assertEquals(new BigDecimal("790.03"), agreement.getPrice().originalPrice());
        assertEquals(new BigDecimal("711.03"), agreement.getPrice().finalPrice());
        assertEquals(10, agreement.getPrice().discountPercent());
        assertEquals(new BigDecimal("79.00"), agreement.getPrice().discountAmount());
    }

    
    @Test
    public void test_Test1() {
        assertThrows(InvalidRentalAgreement.class, () -> controller.getAgreement(new UserRentalAgreementInput("JAKR", 5, 101, "09-03-2015")));
    }

    @Test 
    public void test_Test2() {
        RentalAgreement agreement = controller.getAgreement(new UserRentalAgreementInput("LADW", 3, 10, "07-02-2020"));
        assertEquals(ToolType.Ladder, agreement.getTool().getType());
        assertEquals("Werner", agreement.getMetadata().brand());
        assertEquals(3, agreement.getRentalDays().rentalDays());
        assertEquals(2, agreement.getRentalDays().chargeDays());
        assertEquals(UserRentalAgreementInput.convert("07-02-2020"), agreement.getRentalDays().checkoutDate());
        assertEquals(UserRentalAgreementInput.convert("07-05-2020"), agreement.getRentalDays().checkoutDate().plusDays(agreement.getRentalDays().rentalDays()));
        assertEquals(new BigDecimal("3.98"), agreement.getPrice().originalPrice());
        assertEquals(new BigDecimal("3.58"), agreement.getPrice().finalPrice());
        assertEquals(10, agreement.getPrice().discountPercent());
        assertEquals(new BigDecimal(".40"), agreement.getPrice().discountAmount());
    }

    @Test
    public void test_Test3() {
        RentalAgreement agreement = controller.getAgreement(new UserRentalAgreementInput("CHNS", 5, 25, "07-02-2015"));
        assertEquals(ToolType.ChainSaw, agreement.getTool().getType());
        assertEquals("Stihl", agreement.getMetadata().brand());
        assertEquals(5, agreement.getRentalDays().rentalDays());
        assertEquals(3, agreement.getRentalDays().chargeDays());
        assertEquals(UserRentalAgreementInput.convert("07-02-2015"), agreement.getRentalDays().checkoutDate());
        assertEquals(UserRentalAgreementInput.convert("07-07-2015"), agreement.getRentalDays().checkoutDate().plusDays(agreement.getRentalDays().rentalDays()));
        assertEquals(new BigDecimal("4.47"), agreement.getPrice().originalPrice());
        assertEquals(new BigDecimal("3.35"), agreement.getPrice().finalPrice());
        assertEquals(25, agreement.getPrice().discountPercent());
        assertEquals(new BigDecimal("1.12"), agreement.getPrice().discountAmount());
    }

    @Test
    public void test_Test4() {
        RentalAgreement agreement = controller.getAgreement(new UserRentalAgreementInput("JAKD", 6, 0, "09-03-2015"));
        assertEquals(ToolType.Jackhammer, agreement.getTool().getType());
        assertEquals("DeWalt", agreement.getMetadata().brand());
        assertEquals(6, agreement.getRentalDays().rentalDays());
        assertEquals(3, agreement.getRentalDays().chargeDays());
        assertEquals(UserRentalAgreementInput.convert("09-03-2015"), agreement.getRentalDays().checkoutDate());
        assertEquals(UserRentalAgreementInput.convert("09-09-2015"), agreement.getRentalDays().checkoutDate().plusDays(agreement.getRentalDays().rentalDays()));
        assertEquals(new BigDecimal("8.97"), agreement.getPrice().originalPrice());
        assertEquals(new BigDecimal("8.97"), agreement.getPrice().finalPrice());
        assertEquals(0, agreement.getPrice().discountPercent());
        assertEquals(new BigDecimal("0.00"), agreement.getPrice().discountAmount());
    }

    @Test
    public void test_Test5() {
        RentalAgreement agreement = controller.getAgreement(new UserRentalAgreementInput("JAKR", 9, 0, "07-02-2015"));
        assertEquals(ToolType.Jackhammer, agreement.getTool().getType());
        assertEquals("Ridgid", agreement.getMetadata().brand());
        assertEquals(9, agreement.getRentalDays().rentalDays());
        assertEquals(5, agreement.getRentalDays().chargeDays());
        assertEquals(UserRentalAgreementInput.convert("07-02-2015"), agreement.getRentalDays().checkoutDate());
        assertEquals(UserRentalAgreementInput.convert("07-11-2015"), agreement.getRentalDays().checkoutDate().plusDays(agreement.getRentalDays().rentalDays()));
        assertEquals(new BigDecimal("14.95"), agreement.getPrice().originalPrice());
        assertEquals(new BigDecimal("14.95"), agreement.getPrice().finalPrice());
        assertEquals(0, agreement.getPrice().discountPercent());
        assertEquals(new BigDecimal("0.00"), agreement.getPrice().discountAmount());
    }

@Test
    public void test_Test6() {
        RentalAgreement agreement = controller.getAgreement(new UserRentalAgreementInput("JAKR", 4, 50, "07-02-2020"));
        assertEquals(ToolType.Jackhammer, agreement.getTool().getType());
        assertEquals("Ridgid", agreement.getMetadata().brand());
        assertEquals(4, agreement.getRentalDays().rentalDays());
        assertEquals(1, agreement.getRentalDays().chargeDays());
        assertEquals(UserRentalAgreementInput.convert("07-02-2020"), agreement.getRentalDays().checkoutDate());
        assertEquals(UserRentalAgreementInput.convert("07-06-2020"), agreement.getRentalDays().checkoutDate().plusDays(agreement.getRentalDays().rentalDays()));
        assertEquals(new BigDecimal("2.99"), agreement.getPrice().originalPrice());
        assertEquals(new BigDecimal("1.49"), agreement.getPrice().finalPrice());
        assertEquals(50, agreement.getPrice().discountPercent());
        assertEquals(new BigDecimal("1.50"), agreement.getPrice().discountAmount());
    }
}

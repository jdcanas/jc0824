package com.point_of_sale.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.point_of_sale.checkout.dao.ToolDao;
import com.point_of_sale.checkout.dao.ToolTypeNotFoundException;
import com.point_of_sale.checkout.model.ToolType;

@SpringBootTest
public class ToolDaoTests {

    @Autowired
    ToolDao toolDao;

    @Test
    void testGetTool() {
        assertNotNull(toolDao.getTool(ToolType.ChainSaw));
    }

    @Test
    void testGetToolWithException() {
        assertThrows(ToolTypeNotFoundException.class,
            () -> toolDao.getTool(ToolType.Jackhammer));
    }
    
}
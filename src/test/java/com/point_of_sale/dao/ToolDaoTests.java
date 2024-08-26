package com.point_of_sale.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.point_of_sale.checkout.dao.ToolDao;
import com.point_of_sale.checkout.model.ToolType;

@SpringBootTest
public class ToolDaoTests {

    @Autowired
    ToolDao toolDao;

    @Test
    void testGetTool() {
        assertNotNull(toolDao.getTool(ToolType.ChainSaw));
    }
}
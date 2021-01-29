package com.java.skywebtz;

import com.java.skywebtz.services.AdminService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminServiceTest {

    private AdminService adminService = new AdminService();

    @Test
    public void combine() {
        String res = adminService.combine("Xa-", "Xa");
        assertEquals("Xa- Xa", res);
    }

    @Test
    public void method1() {
        Long value = 123L;
        String res = adminService.method1(value);
        assertEquals("Hello, " + value + "!", res);
    }

    @Test
    public void method2() {
        Long value = 123L;
        String res = adminService.method2(value);
        assertEquals(value + "*2 = " + (value * 2) + ".", res);
    }

}

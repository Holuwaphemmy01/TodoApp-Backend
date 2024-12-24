package app.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ViewAllTaskControllerTest {

    @Autowired
    private ViewAllTaskController viewAllTaskController;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void test(){
        System.out.println(
                viewAllTaskController.viewAll("user151515")
        );
    }
}
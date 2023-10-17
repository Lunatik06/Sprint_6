package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.*;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensTestWith1() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, "Самец");
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        feline.getFood("Хищник");
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void doesHaveManeFemaleTest() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        lion.doesHaveMane();
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeMaleTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.doesHaveMane();
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeUnknownTest() {
        try {
            Lion lion = new Lion(feline, "Неизвестно");
            fail("Ожидается Exception");
        } catch (Exception exception) {
            String expected = "Используйте допустимые значения пола животного - самей или самка";
            String actual = exception.getMessage();
            assertEquals(expected, actual);
        }
    }


}
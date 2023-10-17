package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline(); // исправление: добавил создание экземпляра класса в тест
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline(); // исправление: добавил создание экземпляра класса в тест
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensTestWithoutNumber() {
        Feline feline = new Feline(); // исправление: добавил создание экземпляра класса в тест
        int expected = 1;
        int actual = feline.getKittens();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getKittensTestWith3() {
        Feline feline = new Feline(); // исправление: добавил создание экземпляра класса в тест
        int expected = 3;
        int actual = feline.getKittens(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        feline.getFood("Хищник");
        Mockito.verify(feline).getFood("Хищник");
    }
}

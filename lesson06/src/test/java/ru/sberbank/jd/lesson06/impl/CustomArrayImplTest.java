package ru.sberbank.jd.lesson06.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;


class CustomArrayImplTest {
    CustomArrayImpl<Integer> list = new CustomArrayImpl<>();
    CustomArrayImpl<Integer> listCap = new CustomArrayImpl<>(3);
    @Test
    void sizeAfterCreate() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Научиться основам Java");
        expected.add("Перестроить представление о программировании при переходе с ABAP");
        expected.add("Получить представление о современных подходах к разработке");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        Assertions.assertEquals( 0, list.size());
        Assertions.assertEquals( 0, listCap.size());
        Assertions.assertEquals( 3, listObj.size());
    }

    @Test
    void isEmpty() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Научиться основам Java");
        expected.add("Перестроить представление о программировании при переходе с ABAP");
        expected.add("Получить представление о современных подходах к разработке");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        Assertions.assertFalse( listObj.isEmpty());
        Assertions.assertTrue(listCap.isEmpty());
    }

    @Test
    void addSingleItem() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("345");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        Assertions.assertFalse(listObj.add("999"));
        listObj.ensureCapacity(3);
        Assertions.assertTrue(listObj.add("999"));
        Assertions.assertEquals( "[ 123 345 999 ]", listObj.toString());
    }

    @Test
    void addArrItems() {
        Integer[] list = {1,2,3,4};
        Assertions.assertEquals( "[ ]", listCap.toString());
        listCap.addAll( list );
        Assertions.assertEquals( "[ 1 2 3 4 ]", listCap.toString());
    }

    @Test
    void addCollect() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        listCap.addAll( expected );
        Assertions.assertEquals( "[ 1 2 ]", listCap.toString());
    }

    @Test
    void addArrFromIndex() {
        Integer[] list = {1,2,3,4};
        listCap.addAll( list );
        listCap.addAll( 2, list );
        Assertions.assertEquals( "[ 1 2 1 2 3 4 3 4 ]", listCap.toString());
    }

    @Test
    void get() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("345");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        Assertions.assertEquals( "123", listObj.get(0));
    }

    @Test
    void set() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("345");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        listObj.set(0 ,"888");
        Assertions.assertEquals( "888", listObj.get(0));
    }

    @Test
    void removeByIndex() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("345");
        expected.add("777");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        listObj.remove(0);
        Assertions.assertEquals( "[ 345 777 ]", listObj.toString());
    }

    @Test
    void removeByItem() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("345");
        expected.add("777");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        listObj.remove("345");
        Assertions.assertEquals( "[ 123 777 ]", listObj.toString());
    }

    @Test
    void contains() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("345");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        Assertions.assertTrue( listObj.contains("345"));
        Assertions.assertFalse( listObj.contains("555"));
    }

    @Test
    void indexOf() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("345");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        Assertions.assertEquals( 0, listObj.indexOf("123"));
        Assertions.assertEquals( -1, listObj.indexOf("333"));
    }

    @Test
    void ensureCapacity() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("345");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        listObj.ensureCapacity(5);
        Assertions.assertEquals( 5, listObj.getCapacity());
        listObj.ensureCapacity(1);
        Assertions.assertEquals( 5, listObj.getCapacity());
    }

    @Test
    void getCapacity() {
        Assertions.assertEquals( 10, list.getCapacity());
        Assertions.assertEquals( 3, listCap.getCapacity());
    }

    @Test
    void reverse() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("345");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        listObj.reverse();
        Assertions.assertEquals( "[ 345 123 ]", listObj.toString());
    }

    @Test
    void testToString() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("345");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        Assertions.assertEquals( "[ ]", listCap.toString());
        Assertions.assertEquals( "[ 123 345 ]", listObj.toString());
    }

    @Test
    void toArray() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("123");
        expected.add("345");
        CustomArrayImpl<String> listObj = new CustomArrayImpl<>( expected);
        Assertions.assertArrayEquals( expected.toArray(), listObj.toArray());
    }
}
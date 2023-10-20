package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    @Test
    void testPushBackThreeFourFive(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);

        assertEquals("3 4 5 ",a.toString());
    }

    @Test
    void testPushBeginThreeFourFive(){
        List<Integer> a=new List<>();
        a.push_begin(3);
        a.push_begin(4);
        a.push_begin(5);

        assertEquals("5 4 3 ",a.toString());
    }

    @Test
    void testSearchTree(){
        List <Integer>a=new List<>();
        a.push_back(4);
        a.push_back(3);
        a.push_back(5);
        List <Integer>.Node<Integer>  b=a.search_node(3);
        assertEquals("3",b.toString());
    }

    @Test
    void testInsertBeforeSixBeforeFour(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.insert_before(6,a.search_node(4));
        assertEquals("3 6 4 5 ",a.toString());
    }

    @Test
    void testInsertAfterSixAfterFour(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.insert_after(6,a.search_node(4));
        assertEquals("3 4 6 5 ",a.toString());
    }

    @Test
    void testDeleteBeginTreeFourFive(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.delete_begin();
        assertEquals("4 5 ",a.toString());
    }

    @Test
    void testDeleteBackTreeFourFive(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.delete_back();
        assertEquals("3 4 ",a.toString());
    }


    @Test
    void testDeleteAfterFour(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.push_back(6);
        a.delete_after(a.search_node(4));
        assertEquals("3 4 6 ",a.toString());
    }

    @Test
    void testDeleteBeforeFour(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.push_back(6);
        a.delete_before(a.search_node(4));
        assertEquals("4 5 6 ",a.toString());
    }

    @Test
    void testDeleteIndexeFour(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.push_back(6);
        a.delete_index(1);
        assertEquals("3 5 6 ",a.toString());
    }

    @Test
    void testSizeEqualTreeUsingPushBack(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);

        assertEquals(3,a.size());
    }

    @Test
    void testSizeEqualTreeUsingPushBegin(){
        List<Integer> a=new List<>();
        a.push_begin(3);
        a.push_begin(4);
        a.push_begin(5);

        assertEquals(3,a.size());
    }

    @Test
    void testSizeEquelFourUsingInsertBefore(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.insert_before(6,a.search_node(4));
        assertEquals(4,a.size());
    }

    @Test
    void testSizeEquelFourUsingInsertAfter(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.insert_after(6,a.search_node(4));
        assertEquals(4,a.size());
    }

    @Test
    void testSizeEquelTwoUsingDeleteBegin(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.delete_begin();
        assertEquals(2,a.size());
    }

    @Test
    void testSizeEquelTwoUsingDeleteBack(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.delete_back();
        assertEquals("3 4 ",a.toString());
    }


    @Test
    void testSizeEquelTthreeUsingDeleteAfter(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.push_back(6);
        a.delete_after(a.search_node(4));
        assertEquals(3,a.size());
    }

    @Test
    void testSizeEquelTthreeUsingDeleteBefore(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.push_back(6);
        a.delete_before(a.search_node(4));
        assertEquals(3,a.size());
    }

    @Test
    void testSizeEquelTthreeUsingDeleteIndex(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.push_back(6);
        a.delete_index(1);
        assertEquals(3,a.size());
    }

    @Test
    void testIndexFiveEquelTwoOrNot(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.push_back(6);
        assertEquals(2,a.index(a.search_node(5)));
    }

    @Test
    void testBeginEquelThree(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.push_back(6);
        assertEquals(a.search_node(3),a.begin());
    }

    @Test
    void testCountEquelFive(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(3);
        a.push_back(3);
        a.push_back(3);
        a.push_back(5);
        a.push_back(3);
        a.push_back(6);
        assertEquals(5,a.count(3));
    }

    @Test
    void testIsEmpty(){
        List<Integer> a=new List<>();
        List<Integer> b=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.push_back(6);
        assertEquals(false,a.isEmpty());
        assertEquals(true,b.isEmpty());
    }

    @Test
    void testClean(){
        List<Integer> a=new List<>();
        a.push_back(3);
        a.push_back(4);
        a.push_back(5);
        a.push_back(6);
        assertEquals(false,a.isEmpty());
        a.clean();
        assertEquals(true,a.isEmpty());
    }
}
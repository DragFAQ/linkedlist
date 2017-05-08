package com.drag.linkedlist;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.drag.linkedlist.ListTestData.*;

public class SinglyLinkedListTest {

    @Before
    public void setUp() throws Exception {
        ListTestData.init();
    }

    @Test
    public void testAppend() throws Exception {
        list.append(30);
        Item created = new Item(30);
        MATCHER.assertCollectionEquals(Arrays.asList(ITEM1, ITEM2, ITEM3, ITEM4, ITEM5, ITEM6, created), list);
    }

    @Test
    public void testRemoveLast() {
        list.removeLast();
        MATCHER.assertCollectionEquals(Arrays.asList(ITEM1, ITEM2, ITEM3, ITEM4, ITEM5), list);
    }

    @Test
    public void testRemoveByVal() {
        list.removeAllGreaterThan(22);
        MATCHER.assertCollectionEquals(Arrays.asList(ITEM1, ITEM3, ITEM4, ITEM5), list);
    }

    @Test
    public void testRemoveAll() {
        list.removeAllGreaterThan(Integer.MIN_VALUE);
        MATCHER.assertCollectionEquals(null, list);
    }

    @Test
    public void testRemoveAllOneByOne() {
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        MATCHER.assertCollectionEquals(null, list);
    }

    @Test
    public void testRemoveByValWithFirst() {
        list.removeAllGreaterThan(1);
        MATCHER.assertCollectionEquals(Arrays.asList(ITEM4, ITEM5), list);
    }

    @Test
    public void testAppentFromEmpty() {
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.append(30);
        list.append(59);
        Item created1 = new Item(30);
        Item created2 = new Item(59);
        MATCHER.assertCollectionEquals(Arrays.asList(created1, created2), list);
    }
}

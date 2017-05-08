package com.drag.linkedlist;

import com.drag.linkedlist.matcher.ListMatcher;

public class ListTestData {

    public static final Item ITEM6 = new Item(55);
    public static final Item ITEM5 = new Item(0);
    public static final Item ITEM4 = new Item(-33);
    public static final Item ITEM3 = new Item(22);
    public static final Item ITEM2 = new Item(66);
    public static final Item ITEM1 = new Item(11);

    public static SinglyLinkedList list;

    public static final ListMatcher MATCHER = new ListMatcher();

    public static void init() {
        ITEM1.setNext(ITEM2);
        ITEM2.setNext(ITEM3);
        ITEM3.setNext(ITEM4);
        ITEM4.setNext(ITEM5);
        ITEM5.setNext(ITEM6);
        ITEM6.setNext(null);

        list = new SinglyLinkedList(ITEM1, ITEM6, 6);
    }
}

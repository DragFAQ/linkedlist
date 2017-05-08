package com.drag.linkedlist.matcher;

import com.drag.linkedlist.Item;
import com.drag.linkedlist.SinglyLinkedList;
import org.junit.Assert;

import java.util.List;

public class ListMatcher {
    public void assertCollectionEquals(List<Item> expected, SinglyLinkedList actual) {
        if (expected == null)
            Assert.assertEquals(0, actual.getCount());
        else
            Assert.assertArrayEquals(getArrayByList(expected), getArrayBySinglyLinkedList(actual));
    }

    private Integer[] getArrayBySinglyLinkedList(SinglyLinkedList actual) {
        Integer[] array = new Integer[actual.getCount()];

        Item item = actual.getFirst();

        for (int i = 0; i < actual.getCount(); i++) {
            array[i] = item.getValue();
            if (item.getNext() != null)
                item = item.getNext();
        }

        return array;
    }

    private Integer[] getArrayByList(List<Item> expected) {
        Integer[] array = new Integer[expected.size()];

        for (int i = 0; i < expected.size(); i++) {
            array[i] = expected.get(i).getValue();
        }

        return array;
    }
}

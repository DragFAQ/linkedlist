package com.drag.linkedlist;

public class SinglyLinkedList {
    private Item first;
    private Item last;
    private int count;

    public SinglyLinkedList() {
        count = 0;
    }

    public SinglyLinkedList(Item first, Item last, int count) {
        this.first = first;
        this.last = last;
        this.count = count;
    }

    public Item getFirst() {
        return first;
    }

    public Item getLast() {
        return last;
    }

    public int getCount() {
        return count;
    }

    public Item append(int value) {
        Item item = new Item(value);
        if (count == 0) {
            first = item;
            last = item;
        } else {
            last.setNext(item);
            last = item;
        }
        count ++;

        return item;
    }

    public void removeLast() {
        if (count == 0)
            return;

        if (count == 1) {
            first = null;
            last = null;
        } else {
            Item item = first;

            while ((item = item.getNext()) != last) {
            }

            item.setNext(null);
            last = item;
        }

        count --;
    }

    public void removeAllGreaterThan(int value) {
        if (count == 0)
            return;

        // Need to receive first element less then target value
        boolean isNeedAnotherOneCycle = true;
        while (isNeedAnotherOneCycle) {
            isNeedAnotherOneCycle = false;
            if (first.getValue() > value) {
                if (count == 1) {
                    removeLast();
                    return;
                } else {
                    first = first.getNext();
                    count --;
                    isNeedAnotherOneCycle = true;
                }
            }
        }

        // bypass all "bad" items except the last one
        if (count > 1) {
            Item item = first;

            while (item.getNext() != last) {
                if (item.getNext().getValue() > value) {
                    item.setNext(item.getNext().getNext());
                    count--;
                } else {
                    item = item.getNext();
                }
            }
        }

        // check the last one
        if (last.getValue() > value)
            removeLast();
    }
}

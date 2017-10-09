package com.sgalaktionov.homework8_1;

import com.sgalaktionov.homework8_1.exceptions.LimitedListCapacityExceed;

import java.util.*;

public class LimitedList<T> implements List<T> {
    private List<T> list;
    private int capacity;

    public LimitedList(int capacity) {

        this.capacity = capacity;
        list = new ArrayList<T>(capacity);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public boolean add(T o) {
        if (list.size() < capacity) {
            list.add(o);
        } else {
            throw new LimitedListCapacityExceed();
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        //retrn false;
        return list.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        if (c.size() <= capacity - list.size()) {
            list.addAll(c);
        } else {
            throw new LimitedListCapacityExceed();
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if (c.size() <= capacity - index) {
            list.addAll(index, c);
        } else {
            throw new LimitedListCapacityExceed();
        }
        return true;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public T get(int index) {
        return list.get(index);

    }

    @Override
    public T set(int index, T element) {
        T rewritedElement = list.get(index);
        list.set(index, element);
        return rewritedElement;
    }

    @Override
    public void add(int index, T element) {
        if (index < capacity) {
            list.add(index, element);
        } else {
            throw new LimitedListCapacityExceed();
        }

    }

    @Override
    public T remove(int index) {
        T removedElement = list.get(index);
        list.remove(index);
        return removedElement;
    }

    @Override
    public int indexOf(Object o) {

        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    @Override
    public boolean retainAll(Collection c) {
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return list.removeAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return list.toArray(a);
    }
}

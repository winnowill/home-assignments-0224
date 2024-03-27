package ru.sberbank.jd.lesson06.impl;

import java.util.Arrays;
import java.util.Collection;
import ru.sberbank.jd.lesson06.CustomArray;

/**
 * Класс реализация безразмерного массива.
 *
 * @param <T> Any type
 */
public class CustomArrayImpl<T> implements CustomArray<T> {
    private Object[] list;
    private static final int DEFAULT_CAPACITY = 10;
    private final int minCapacity;
    private int size;

    public CustomArrayImpl() {
        list = new Object[DEFAULT_CAPACITY];
        minCapacity = DEFAULT_CAPACITY;
    }

    /**
     * Constructor.
     *
     * @param capacity arr
     */
    public CustomArrayImpl(int capacity) {
        if (capacity == 0) {
            list = new Object[DEFAULT_CAPACITY];
            minCapacity = DEFAULT_CAPACITY;
        } else if (capacity > 0) {
            list = new Object[capacity];
            minCapacity = capacity;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    /**
     * Constructor.
     *
     * @param c Collection
     */
    public CustomArrayImpl(Collection<T> c) {
        list = c.toArray();
        size = c.size();
        minCapacity = list.length;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Add single item.
     *
     * @param item add to arr
     * @return true if add item
     */
    @Override
    public boolean add(T item) {
        int capacity = getCapacity();
        if (capacity > size) {
            list[size] = item;
            size++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Add all items.
     *
     * @param items - items for insert
     * @return true if add items
     * @throws IllegalArgumentException if parameter items is null
     */
    @Override
    public boolean addAll(T[] items) {
        int capacity = getCapacity();
        int numNew = items.length;
        if (numNew == 0) {
            return false;
        }
        final int s;
        if (numNew > capacity - (s = size)) {
            ensureCapacity(s + numNew);
        }
        System.arraycopy(items, 0, list, s, numNew);
        size = s + numNew;
        return true;
    }

    /**
     * Add all items.
     *
     * @param items - items for insert
     * @return true if add items collection
     * @throws IllegalArgumentException if parameter items is null
     */
    @Override
    public boolean addAll(Collection<T> items) {
        return addAll((T[]) items.toArray());
    }

    /**
     * Add items to current place in array.
     *
     * @param index - index
     * @param items - items for insert
     * @return true if add items to index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     * @throws IllegalArgumentException       if parameter items is null
     */
    @Override
    public boolean addAll(int index, T[] items) {
        int capacity = getCapacity();
        int numNew = items.length;
        if (numNew == 0) {
            return false;
        }
        final int s;
        if (numNew > capacity - (s = size)) {
            ensureCapacity(s + numNew);
        }
        int numMoved = s - index;
        if (numMoved > 0) {
            System.arraycopy(list, index,
                    list, index + numNew,
                    numMoved);
        }
        System.arraycopy(items, 0, list, index, numNew);
        size = s + numNew;
        return true;
    }

    /**
     * Get item by index.
     *
     * @param index - index item
     * @return item
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public T get(int index) {
        return (T) list[index];
    }

    /**
     * Set item by index.
     *
     * @param index - index
     * @param item  - item for insert
     * @return old value
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public T set(int index, T item) {
        if (list.length - 1 < index) {
            throw new ArrayIndexOutOfBoundsException("Illegal index: " + index);
        } else {
            T oldVal = (T) list[index];
            list[index] = item;
            return oldVal;
        }
    }

    /**
     * Remove item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public void remove(int index) {
        if (list.length - 1 < index) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + " is out of bounds");
        } else {
            for (int i = index + 1; i <= list.length - 1; ++i) {

                list[index] = list[i];
                list[i] = null;
                index++;
            }
            size--;
        }
    }

    /**
     * Remove item by value. Remove first item occurrence.
     *
     * @param item - item
     * @return true if item was removed
     */
    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if (index >= 0) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if item exists.
     *
     * @param item - item
     * @return true or false
     */
    @Override
    public boolean contains(T item) {
        for (Object element : list) {
            if (item == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Index of item.
     *
     * @param item - item
     * @return index of element or -1 of list doesn't contain element
     */
    @Override
    public int indexOf(T item) {
        int index = 0;
        for (Object element : list) {
            if (item == element) {
                return index;
            }
            index = index + 1;
        }
        return -1;
    }

    /**
     * Grow current capacity to store new elements if needed.
     *
     * @param newElementsCount - new elements count
     */
    @Override
    public void ensureCapacity(int newElementsCount) {
        if (minCapacity < newElementsCount) {
            Object[] listNew = new Object[newElementsCount];
            int index = 0;
            for (Object item : list) {
                listNew[index] = item;
                if (index == list.length - 1) {
                    break;
                }
                index++;
            }
            list = listNew;
        }
    }

    /**
     * Get current capacity.
     */
    @Override
    public int getCapacity() {
        return list.length;
    }

    /**
     * Reverse list.
     */
    @Override
    public void reverse() {
        int index = getCapacity();
        Object[] listNew = new Object[index];
        for (Object item : list) {
            index--;
            listNew[index] = item;
        }
        list = listNew;
    }

    /**
     * Get content in format '[ element1 element2 ... elementN ] or [ ] if empty.
     *
     * @return string for print
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(" ");
            for (Object item : list) {
                if (item != null) {
                    sb.append(item).append(" ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    /**
     * Get copy of current array.
     *
     * @return list
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(list, size);

    }
}

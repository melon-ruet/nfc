package android.support.v4.util;

public class CircularArray {
    private int mCapacityBitmask;
    private Object[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    public CircularArray(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        if (Integer.bitCount(i) != 1) {
            i = 1 << (Integer.highestOneBit(i) + 1);
        }
        this.mCapacityBitmask = i - 1;
        this.mElements = new Object[i];
    }

    private void doubleCapacity() {
        int length = this.mElements.length;
        int i = length - this.mHead;
        int i2 = length << 1;
        if (i2 < 0) {
            throw new RuntimeException("Too big");
        }
        Object obj = new Object[i2];
        System.arraycopy(this.mElements, this.mHead, obj, 0, i);
        System.arraycopy(this.mElements, 0, obj, i, this.mHead);
        this.mElements = (Object[]) obj;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i2 - 1;
    }

    public final void addFirst(Object obj) {
        this.mHead = (this.mHead - 1) & this.mCapacityBitmask;
        this.mElements[this.mHead] = obj;
        if (this.mHead == this.mTail) {
            doubleCapacity();
        }
    }

    public final void addLast(Object obj) {
        this.mElements[this.mTail] = obj;
        this.mTail = (this.mTail + 1) & this.mCapacityBitmask;
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public final Object get(int i) {
        if (i < 0 || i >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[(this.mHead + i) & this.mCapacityBitmask];
    }

    public final Object getFirst() {
        if (this.mHead != this.mTail) {
            return this.mElements[this.mHead];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final Object getLast() {
        if (this.mHead != this.mTail) {
            return this.mElements[(this.mTail - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        return this.mHead == this.mTail;
    }

    public final Object popFirst() {
        if (this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Object obj = this.mElements[this.mHead];
        this.mElements[this.mHead] = null;
        this.mHead = (this.mHead + 1) & this.mCapacityBitmask;
        return obj;
    }

    public final Object popLast() {
        if (this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = (this.mTail - 1) & this.mCapacityBitmask;
        Object obj = this.mElements[i];
        this.mElements[i] = null;
        this.mTail = i;
        return obj;
    }

    public final int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }
}

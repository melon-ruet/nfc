package android.support.v4.util;

public class LongSparseArray implements Cloneable {
    private static final Object DELETED;
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    static {
        DELETED = new Object();
    }

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i) {
        this.mGarbage = false;
        if (i == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i);
            this.mKeys = new long[idealLongArraySize];
            this.mValues = new Object[idealLongArraySize];
        }
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.mGarbage = false;
        this.mSize = i2;
    }

    public void append(long j, Object obj) {
        if (this.mSize == 0 || j > this.mKeys[this.mSize - 1]) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
            }
            int i = this.mSize;
            if (i >= this.mKeys.length) {
                int idealLongArraySize = ContainerHelpers.idealLongArraySize(i + 1);
                Object obj2 = new long[idealLongArraySize];
                Object obj3 = new Object[idealLongArraySize];
                System.arraycopy(this.mKeys, 0, obj2, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, obj3, 0, this.mValues.length);
                this.mKeys = obj2;
                this.mValues = obj3;
            }
            this.mKeys[i] = j;
            this.mValues[i] = obj;
            this.mSize = i + 1;
            return;
        }
        put(j, obj);
    }

    public void clear() {
        int i = this.mSize;
        Object[] objArr = this.mValues;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public LongSparseArray clone() {
        try {
            LongSparseArray longSparseArray = (LongSparseArray) super.clone();
            try {
                longSparseArray.mKeys = (long[]) this.mKeys.clone();
                longSparseArray.mValues = (Object[]) this.mValues.clone();
                return longSparseArray;
            } catch (CloneNotSupportedException e) {
                return longSparseArray;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public void delete(long j) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (binarySearch >= 0 && this.mValues[binarySearch] != DELETED) {
            this.mValues[binarySearch] = DELETED;
            this.mGarbage = true;
        }
    }

    public Object get(long j) {
        return get(j, null);
    }

    public Object get(long j, Object obj) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        return (binarySearch < 0 || this.mValues[binarySearch] == DELETED) ? obj : this.mValues[binarySearch];
    }

    public int indexOfKey(long j) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
    }

    public int indexOfValue(Object obj) {
        if (this.mGarbage) {
            gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    public long keyAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i];
    }

    public void put(long j, Object obj) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = obj;
            return;
        }
        binarySearch ^= -1;
        if (binarySearch >= this.mSize || this.mValues[binarySearch] != DELETED) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
                binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j) ^ -1;
            }
            if (this.mSize >= this.mKeys.length) {
                int idealLongArraySize = ContainerHelpers.idealLongArraySize(this.mSize + 1);
                Object obj2 = new long[idealLongArraySize];
                Object obj3 = new Object[idealLongArraySize];
                System.arraycopy(this.mKeys, 0, obj2, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, obj3, 0, this.mValues.length);
                this.mKeys = obj2;
                this.mValues = obj3;
            }
            if (this.mSize - binarySearch != 0) {
                System.arraycopy(this.mKeys, binarySearch, this.mKeys, binarySearch + 1, this.mSize - binarySearch);
                System.arraycopy(this.mValues, binarySearch, this.mValues, binarySearch + 1, this.mSize - binarySearch);
            }
            this.mKeys[binarySearch] = j;
            this.mValues[binarySearch] = obj;
            this.mSize++;
            return;
        }
        this.mKeys[binarySearch] = j;
        this.mValues[binarySearch] = obj;
    }

    public void remove(long j) {
        delete(j);
    }

    public void removeAt(int i) {
        if (this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    public void setValueAt(int i, Object obj) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i] = obj;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(keyAt(i));
            stringBuilder.append('=');
            LongSparseArray valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Object valueAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mValues[i];
    }
}

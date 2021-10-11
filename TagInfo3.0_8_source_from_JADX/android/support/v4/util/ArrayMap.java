package android.support.v4.util;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayMap extends SimpleArrayMap implements Map {
    MapCollections mCollections;

    /* renamed from: android.support.v4.util.ArrayMap.1 */
    class C00411 extends MapCollections {
        C00411() {
        }

        protected void colClear() {
            ArrayMap.this.clear();
        }

        protected Object colGetEntry(int i, int i2) {
            return ArrayMap.this.mArray[(i << 1) + i2];
        }

        protected Map colGetMap() {
            return ArrayMap.this;
        }

        protected int colGetSize() {
            return ArrayMap.this.mSize;
        }

        protected int colIndexOfKey(Object obj) {
            return obj == null ? ArrayMap.this.indexOfNull() : ArrayMap.this.indexOf(obj, obj.hashCode());
        }

        protected int colIndexOfValue(Object obj) {
            return ArrayMap.this.indexOfValue(obj);
        }

        protected void colPut(Object obj, Object obj2) {
            ArrayMap.this.put(obj, obj2);
        }

        protected void colRemoveAt(int i) {
            ArrayMap.this.removeAt(i);
        }

        protected Object colSetValue(int i, Object obj) {
            return ArrayMap.this.setValueAt(i, obj);
        }
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    private MapCollections getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new C00411();
        }
        return this.mCollections;
    }

    public boolean containsAll(Collection collection) {
        return MapCollections.containsAllHelper(this, collection);
    }

    public Set entrySet() {
        return getCollection().getEntrySet();
    }

    public Set keySet() {
        return getCollection().getKeySet();
    }

    public void putAll(Map map) {
        ensureCapacity(this.mSize + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean removeAll(Collection collection) {
        return MapCollections.removeAllHelper(this, collection);
    }

    public boolean retainAll(Collection collection) {
        return MapCollections.retainAllHelper(this, collection);
    }

    public Collection values() {
        return getCollection().getValues();
    }
}

package com.nxp.taginfolite.fragments.p020a;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

/* renamed from: com.nxp.taginfolite.fragments.a.h */
public class C0381h extends CursorWrapper {
    private final SparseBooleanArray f1210a;
    private int f1211b;
    private final SparseIntArray f1212c;

    public C0381h(Cursor cursor, SparseBooleanArray sparseBooleanArray) {
        super(cursor);
        this.f1211b = -1;
        this.f1210a = sparseBooleanArray;
        this.f1212c = new SparseIntArray();
        cursor.moveToFirst();
        Integer valueOf = Integer.valueOf(0);
        Integer valueOf2 = Integer.valueOf(0);
        while (valueOf.intValue() < cursor.getCount() - sparseBooleanArray.size()) {
            while (sparseBooleanArray.get(valueOf2.intValue())) {
                valueOf2 = Integer.valueOf(valueOf2.intValue() + 1);
            }
            this.f1212c.put(valueOf.intValue(), valueOf2.intValue());
            valueOf = Integer.valueOf(valueOf.intValue() + 1);
            valueOf2 = Integer.valueOf(valueOf2.intValue() + 1);
        }
    }

    public int getCount() {
        return super.getCount() - this.f1210a.size();
    }

    public int getPosition() {
        return this.f1211b;
    }

    public final boolean isAfterLast() {
        return getCount() == 0 || this.f1211b == getCount();
    }

    public final boolean isBeforeFirst() {
        return getCount() == 0 || this.f1211b == -1;
    }

    public final boolean isFirst() {
        return this.f1211b == 0 && getCount() != 0;
    }

    public final boolean isLast() {
        int count = getCount();
        return this.f1211b == count + -1 && count != 0;
    }

    public final boolean move(int i) {
        return moveToPosition(this.f1211b + i);
    }

    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    public final boolean moveToNext() {
        return moveToPosition(this.f1211b + 1);
    }

    public boolean moveToPosition(int i) {
        Integer valueOf = Integer.valueOf(this.f1212c.get(i));
        if (valueOf == null) {
            return false;
        }
        boolean moveToPosition = super.moveToPosition(valueOf.intValue());
        if (!moveToPosition) {
            return moveToPosition;
        }
        this.f1211b = i;
        return moveToPosition;
    }

    public final boolean moveToPrevious() {
        return moveToPosition(this.f1211b - 1);
    }
}

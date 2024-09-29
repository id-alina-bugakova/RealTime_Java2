package ru.mirea.lab6;

import java.util.ArrayList;

public class StringBuilder {
    private java.lang.StringBuilder builder;
    private ArrayList<String> prev_states;

    public StringBuilder() {
        this.builder = new java.lang.StringBuilder();
        this.prev_states = new ArrayList<>();
    }
    public StringBuilder(CharSequence seq) {
        this.builder = new java.lang.StringBuilder(seq);
        this.prev_states = new ArrayList<>();
    }
    public StringBuilder(int capacity) {
        this.builder = new java.lang.StringBuilder(capacity);
        this.prev_states = new ArrayList<>();
    }
    public StringBuilder(String str) {
        this.builder = new java.lang.StringBuilder(str);
        this.prev_states = new ArrayList<>();
    }

    public java.lang.StringBuilder undo () {
        int capacity = this.builder.capacity();
        this.builder = new java.lang.StringBuilder(this.prev_states.get(this.prev_states.size() - 1));
        this.builder.ensureCapacity(capacity);
        this.prev_states.remove(this.prev_states.size() - 1);
        return this.builder;
    }

    public java.lang.StringBuilder append(boolean b) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(b);
    }
    public java.lang.StringBuilder append(char c) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(c);
    }
    public java.lang.StringBuilder append(char[] str) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(str);
    }
    public java.lang.StringBuilder append(char[] str, int offset, int len) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(str, offset, len);
    }
    public java.lang.StringBuilder append(CharSequence s) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(s);
    }
    public java.lang.StringBuilder append(CharSequence s, int start, int end) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(s, start, end);
    }
    public java.lang.StringBuilder append(double d) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(d);
    }
    public java.lang.StringBuilder append(float f) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(f);
    }
    public java.lang.StringBuilder append(int i) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(i);
    }
    public java.lang.StringBuilder append(long lng) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(lng);
    }
    public java.lang.StringBuilder append(Object obj) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(obj);
    }
    public java.lang.StringBuilder append(String str) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(str);
    }
    public java.lang.StringBuilder append(StringBuffer sb) {
        this.prev_states.add(this.builder.toString());
        return this.builder.append(sb);
    }
    public java.lang.StringBuilder appendCodePoint(int codePoint) {
        this.prev_states.add(this.builder.toString());
        return this.builder.appendCodePoint(codePoint);
    }
    public int capacity() {
        return this.builder.capacity();
    }
    public char charAt(int index) {
        return this.builder.charAt(index);
    }
    public int codePointAt(int index) {
        return this.builder.codePointAt(index);
    }
    public int codePointBefore(int index) {
        return this.builder.codePointBefore(index);
    }
    public int codePointCount(int beginIndex, int endIndex) {
        return this.builder.codePointCount(beginIndex, endIndex);
    }
    public java.lang.StringBuilder delete(int start, int end) {
        this.prev_states.add(this.builder.toString());
        return this.builder.delete(start, end);
    }
    public java.lang.StringBuilder deleteCharAt(int index) {
        this.prev_states.add(this.builder.toString());
        return this.builder.deleteCharAt(index);
    }
    public void ensureCapacity(int minimumCapacity) {
        this.builder.ensureCapacity(minimumCapacity);
    }
    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        this.builder.getChars(srcBegin, srcEnd, dst, dstBegin);
    }
    public int indexOf(String str) {
        return this.builder.indexOf(str);
    }
    public int indexOf(String str, int fromIndex) {
        return this.builder.indexOf(str, fromIndex);
    }
    public java.lang.StringBuilder insert(int offset, boolean b) {
        this.prev_states.add(this.builder.toString());
        return this.builder.insert(offset, b);
    }
    public java.lang.StringBuilder insert(int offset, char c) {
        this.prev_states.add(this.builder.toString());
        return this.builder.insert(offset, c);
    }
    public java.lang.StringBuilder insert(int offset, char[] str) {
        this.prev_states.add(this.builder.toString());
        return this.builder.insert(offset, str);
    }
    public java.lang.StringBuilder insert(int dstOffset, CharSequence s) {
        this.prev_states.add(this.builder.toString());
        return this.builder.insert(dstOffset, s);
    }
    public java.lang.StringBuilder insert(int dstOffset, CharSequence s, int start, int end) {
        this.prev_states.add(this.builder.toString());
        return this.builder.insert(dstOffset, s, start, end);
    }
    public java.lang.StringBuilder insert(int offset, double d) {
        this.prev_states.add(this.builder.toString());
        return this.builder.insert(offset, d);
    }
    public java.lang.StringBuilder insert(int offset, float f) {
        this.prev_states.add(this.builder.toString());
        return this.builder.insert(offset, f);
    }
    public java.lang.StringBuilder insert(int offset, int i) {
        this.prev_states.add(this.builder.toString());
        return this.builder.insert(offset, i);
    }
    public java.lang.StringBuilder insert(int offset, long l) {
        this.prev_states.add(this.builder.toString());
        return this.builder.insert(offset, l);
    }
    public java.lang.StringBuilder insert(int offset, Object obj) {
        this.prev_states.add(this.builder.toString());
        return this.builder.insert(offset, obj);
    }
    public java.lang.StringBuilder insert(int offset, String str) {
        this.prev_states.add(this.builder.toString());
        return this.builder.insert(offset, str);
    }
    public int lastIndexOf(String str) {
        return this.builder.lastIndexOf(str);
    }
    public int lastIndexOf(String str, int fromIndex) {
        return this.builder.lastIndexOf(str, fromIndex);
    }
    public int length() {
        return this.builder.length();
    }
    public int offsetByCodePoints(int index, int codePointOffset) {
        return this.builder.offsetByCodePoints(index, codePointOffset);
    }
    public java.lang.StringBuilder replace(int start, int end, String str) {
        this.prev_states.add(this.builder.toString());
        return this.builder.replace(start, end, str);
    }
    public java.lang.StringBuilder reverse() {
        this.prev_states.add(this.builder.toString());
        return this.builder.reverse();
    }
    public void setCharAt(int index, char ch) {
        this.prev_states.add(this.builder.toString());
        this.builder.setCharAt(index, ch);
    }
    public void setLength(int newLength) {
        this.builder.setLength(newLength);
    }
    public CharSequence subSequence(int start, int end) {
        return this.builder.subSequence(start, end);}
    public String substring(int start) {
        return this.builder.substring(start);
    }
    public String substring(int start, int end) {
        return this.builder.substring(start, end);
    }
    public void trimToSize() {
        this.builder.trimToSize();
    }
    @Override
    public String toString() {
        return this.builder.toString();
    }
}

package ru.mirea.lab20.task4_2;

public class Calculator {
    public static <T, S> Object add (T s1, S s2) {
        if((s1 instanceof Double && (s2 instanceof Byte || s2 instanceof Short || s2 instanceof Integer || s2 instanceof Long || s2 instanceof Float)) ||
                (s2 instanceof Double && (s1 instanceof Byte || s1 instanceof Short || s1 instanceof Integer || s1 instanceof Long || s1 instanceof Float)) ||
                (s1 instanceof Double && s2 instanceof Double)) {
            return Double.parseDouble(s1.toString()) + Double.parseDouble(s2.toString());
        }
        else if ((s1 instanceof Float && (s2 instanceof Byte || s2 instanceof Short || s2 instanceof Integer || s2 instanceof Long)) ||
                (s2 instanceof Float && (s1 instanceof Byte || s1 instanceof Short || s1 instanceof Integer || s1 instanceof Long)) ||
                (s1 instanceof Float && s2 instanceof Float)) {
            return Float.parseFloat(s1.toString()) + Float.parseFloat(s2.toString());
        }
        else if ((s1 instanceof Long && (s2 instanceof Byte || s2 instanceof Short || s2 instanceof Integer)) ||
                (s2 instanceof Long && (s1 instanceof Byte || s1 instanceof Short || s1 instanceof Integer)) ||
                (s1 instanceof Long && s2 instanceof Long)) {
            return Long.parseLong(s1.toString()) + Long.parseLong(s2.toString());
        }
        else if ((s1 instanceof Integer && (s2 instanceof Byte || s2 instanceof Short)) ||
                (s2 instanceof Integer && (s1 instanceof Byte || s1 instanceof Short)) ||
                (s1 instanceof Integer && s2 instanceof Integer)) {
            return Integer.parseInt(s1.toString()) + Integer.parseInt(s2.toString());
        }
        else if ((s1 instanceof Short && s2 instanceof Byte) ||
                (s2 instanceof Short && s1 instanceof Byte) ||
                (s1 instanceof Short && s2 instanceof Short)) {
            return Short.parseShort(s1.toString()) + Short.parseShort(s2.toString());
        }
        else if (s1 instanceof Byte && s2 instanceof Byte) {
            return (Byte)s1 + (Byte)s2;
        }
        else if(s1 instanceof String || s2 instanceof String) {
            return s1.toString() + s2.toString();
        }
        else if(s1 instanceof Character) {
            if(s2 instanceof Double)
                return Double.valueOf((Character)s1) + (Double)s2;
            else if (s2 instanceof Float)
                return Float.valueOf((Character)s1) + (Float)s2;
            else if (s2 instanceof Long)
                return Long.valueOf((Character)s1) + (Long)s2;
            else if (s2 instanceof Integer)
                return Integer.valueOf((Character)s1) + (Integer)s2;
            else if (s2 instanceof Short)
                return Integer.valueOf((Character)s1) + (Short)s2;
            else if (s2 instanceof Byte)
                return Integer.valueOf((Character)s1) + (Byte)s2;
            else if (s2 instanceof Character)
                return Integer.valueOf((Character)s1) + Integer.valueOf((Character)s2);
        }
        else if(s2 instanceof Character) {
            if(s1 instanceof Double)
                return Double.valueOf((Character)s2) + (Double)s1;
            else if (s1 instanceof Float)
                return Float.valueOf((Character)s2) + (Float)s1;
            else if (s1 instanceof Long)
                return Long.valueOf((Character)s2) + (Long)s1;
            else if (s1 instanceof Integer)
                return Integer.valueOf((Character)s2) + (Integer)s1;
            else if (s1 instanceof Short)
                return Integer.valueOf((Character)s2) + (Short)s1;
            else if (s1 instanceof Byte)
                return Integer.valueOf((Character)s2) + (Byte)s1;
        }
        else if (s1 instanceof Calculable && s2 instanceof Calculable) {
            return ((Calculable)s1).add((Calculable)s2);
        }
        throw new CalculationWithIncompatibleTypesException("Attempted to add incompatible types: " + s1.getClass().getName() + " and " + s2.getClass().getName());
    }
    public static <T, S> Object subtract (T dim, S sub) {
        if((dim instanceof Double && (sub instanceof Byte || sub instanceof Short || sub instanceof Integer || sub instanceof Long || sub instanceof Float)) ||
                (sub instanceof Double && (dim instanceof Byte || dim instanceof Short || dim instanceof Integer || dim instanceof Long || dim instanceof Float)) ||
                (dim instanceof Double && sub instanceof Double)) {
            return Double.parseDouble(dim.toString()) - Double.parseDouble(sub.toString());
        }
        else if ((dim instanceof Float && (sub instanceof Byte || sub instanceof Short || sub instanceof Integer || sub instanceof Long)) ||
                (sub instanceof Float && (dim instanceof Byte || dim instanceof Short || dim instanceof Integer || dim instanceof Long)) ||
                (dim instanceof Float && sub instanceof Float)) {
            return Float.parseFloat(dim.toString()) - Float.parseFloat(sub.toString());
        }
        else if ((dim instanceof Long && (sub instanceof Byte || sub instanceof Short || sub instanceof Integer)) ||
                (sub instanceof Long && (dim instanceof Byte || dim instanceof Short || dim instanceof Integer)) ||
                (dim instanceof Long && sub instanceof Long)) {
            return Long.parseLong(dim.toString()) - Long.parseLong(sub.toString());
        }
        else if ((dim instanceof Integer && (sub instanceof Byte || sub instanceof Short)) ||
                (sub instanceof Integer && (dim instanceof Byte || dim instanceof Short)) ||
                (dim instanceof Integer && sub instanceof Integer)) {
            return Integer.parseInt(dim.toString()) - Integer.parseInt(sub.toString());
        }
        else if ((dim instanceof Short && sub instanceof Byte) ||
                (sub instanceof Short && dim instanceof Byte) ||
                (dim instanceof Short && sub instanceof Short)) {
            return Short.parseShort(dim.toString()) - Short.parseShort(sub.toString());
        }
        else if (dim instanceof Byte && sub instanceof Byte) {
            return (Byte)dim - (Byte)sub;
        }
        else if(dim instanceof Character) {
            if(sub instanceof Double)
                return Double.valueOf((Character)dim) - (Double)sub;
            else if (sub instanceof Float)
                return Float.valueOf((Character)dim) - (Float)sub;
            else if (sub instanceof Long)
                return Long.valueOf((Character)dim) - (Long)sub;
            else if (sub instanceof Integer)
                return Integer.valueOf((Character)dim) - (Integer)sub;
            else if (sub instanceof Short)
                return Integer.valueOf((Character)dim) - (Short)sub;
            else if (sub instanceof Byte)
                return Integer.valueOf((Character)dim) - (Byte)sub;
            else if (sub instanceof Character)
                return Integer.valueOf((Character)dim) - Integer.valueOf((Character)sub);
        }
        else if(sub instanceof Character) {
            if(dim instanceof Double)
                return (Double)dim - Double.valueOf((Character)sub);
            else if (dim instanceof Float)
                return (Float)dim - Float.valueOf((Character)sub);
            else if (dim instanceof Long)
                return (Long)dim - Long.valueOf((Character)sub);
            else if (dim instanceof Integer)
                return (Integer)dim - Integer.valueOf((Character)sub);
            else if (dim instanceof Short)
                return (Short)dim - Integer.valueOf((Character)sub);
            else if (dim instanceof Byte)
                return (Byte)dim - Integer.valueOf((Character)sub);
        }
        else if (dim instanceof Calculable && sub instanceof Calculable) {
            return ((Calculable)dim).subtract((Calculable)sub);
        }
        throw new CalculationWithIncompatibleTypesException("Attempted to subtract incompatible types: " + dim.getClass().getName() + " and " + sub.getClass().getName());
    }
    public static <T, S> Object multiply (T m1, S m2) {
        if((m1 instanceof Double && (m2 instanceof Byte || m2 instanceof Short || m2 instanceof Integer || m2 instanceof Long || m2 instanceof Float)) ||
                (m2 instanceof Double && (m1 instanceof Byte || m1 instanceof Short || m1 instanceof Integer || m1 instanceof Long || m1 instanceof Float)) ||
                (m1 instanceof Double && m2 instanceof Double)) {
            return Double.parseDouble(m1.toString()) * Double.parseDouble(m2.toString());
        }
        else if ((m1 instanceof Float && (m2 instanceof Byte || m2 instanceof Short || m2 instanceof Integer || m2 instanceof Long)) ||
                (m2 instanceof Float && (m1 instanceof Byte || m1 instanceof Short || m1 instanceof Integer || m1 instanceof Long)) ||
                (m1 instanceof Float && m2 instanceof Float)) {
            return Float.parseFloat(m1.toString()) * Float.parseFloat(m2.toString());
        }
        else if ((m1 instanceof Long && (m2 instanceof Byte || m2 instanceof Short || m2 instanceof Integer)) ||
                (m2 instanceof Long && (m1 instanceof Byte || m1 instanceof Short || m1 instanceof Integer)) ||
                (m1 instanceof Long && m2 instanceof Long)) {
            return Long.parseLong(m1.toString()) * Long.parseLong(m2.toString());
        }
        else if ((m1 instanceof Integer && (m2 instanceof Byte || m2 instanceof Short)) ||
                (m2 instanceof Integer && (m1 instanceof Byte || m1 instanceof Short)) ||
                (m1 instanceof Integer && m2 instanceof Integer)) {
            return Integer.parseInt(m1.toString()) * Integer.parseInt(m2.toString());
        }
        else if ((m1 instanceof Short && m2 instanceof Byte) ||
                (m2 instanceof Short && m1 instanceof Byte) ||
                (m1 instanceof Short && m2 instanceof Short)) {
            return Short.parseShort(m1.toString()) * Short.parseShort(m2.toString());
        }
        else if (m1 instanceof Byte && m2 instanceof Byte) {
            return (Byte)m1 * (Byte)m2;
        }
        else if(m1 instanceof Character) {
            if(m2 instanceof Double)
                return Double.valueOf((Character)m1) * (Double)m2;
            else if (m2 instanceof Float)
                return Float.valueOf((Character)m1) * (Float)m2;
            else if (m2 instanceof Long)
                return Long.valueOf((Character)m1) * (Long)m2;
            else if (m2 instanceof Integer)
                return Integer.valueOf((Character)m1) * (Integer)m2;
            else if (m2 instanceof Short)
                return Integer.valueOf((Character)m1) * (Short)m2;
            else if (m2 instanceof Byte)
                return Integer.valueOf((Character)m1) * (Byte)m2;
            else if (m2 instanceof Character)
                return Integer.valueOf((Character)m1) * Integer.valueOf((Character)m2);
        }
        else if(m2 instanceof Character) {
            if(m1 instanceof Double)
                return (Double)m1 * Double.valueOf((Character)m2);
            else if (m1 instanceof Float)
                return (Float)m1 * Float.valueOf((Character)m2);
            else if (m1 instanceof Long)
                return (Long)m1 * Long.valueOf((Character)m2);
            else if (m1 instanceof Integer)
                return (Integer)m1 * Integer.valueOf((Character)m2);
            else if (m1 instanceof Short)
                return (Short)m1 * Integer.valueOf((Character)m2);
            else if (m1 instanceof Byte)
                return (Byte)m1 * Integer.valueOf((Character)m2);
        }
        else if(m1 instanceof String && (m2 instanceof Byte || m2 instanceof Short || m2 instanceof Integer || m2 instanceof Long)) {
            String res = "";
            for(long i = 0L; i < ((Number)m2).longValue(); i++)
                res += m1;
            return res;
        }
        else if(m2 instanceof String && (m1 instanceof Byte || m1 instanceof Short || m1 instanceof Integer || m1 instanceof Long)) {
            String res = "";
            for(long i = 0L; i < ((Number)m1).longValue(); i++)
                res += m2;
            return res;
        }
        else if (m1 instanceof Calculable && m2 instanceof Calculable) {
            return ((Calculable)m1).multiply((Calculable)m2);
        }
        throw new CalculationWithIncompatibleTypesException("Attempted to multiply incompatible types: " + m1.getClass().getName() + " and " + m2.getClass().getName());
    }
    public static <T, S> Object divide(T dd, S ds) {
        if((dd instanceof Double && (ds instanceof Byte || ds instanceof Short || ds instanceof Integer || ds instanceof Long || ds instanceof Float)) ||
                (ds instanceof Double && (dd instanceof Byte || dd instanceof Short || dd instanceof Integer || dd instanceof Long || dd instanceof Float)) ||
                (dd instanceof Double && ds instanceof Double)) {
            return Double.parseDouble(dd.toString()) / Double.parseDouble(ds.toString());
        }
        else if ((dd instanceof Float && (ds instanceof Byte || ds instanceof Short || ds instanceof Integer || ds instanceof Long)) ||
                (ds instanceof Float && (dd instanceof Byte || dd instanceof Short || dd instanceof Integer || dd instanceof Long)) ||
                (dd instanceof Float && ds instanceof Float)) {
            return Float.parseFloat(dd.toString()) / Float.parseFloat(ds.toString());
        }
        else if ((dd instanceof Long && (ds instanceof Byte || ds instanceof Short || ds instanceof Integer)) ||
                (ds instanceof Long && (dd instanceof Byte || dd instanceof Short || dd instanceof Integer)) ||
                (dd instanceof Long && ds instanceof Long)) {
            return Long.parseLong(dd.toString()) / Long.parseLong(ds.toString());
        }
        else if ((dd instanceof Integer && (ds instanceof Byte || ds instanceof Short)) ||
                (ds instanceof Integer && (dd instanceof Byte || dd instanceof Short)) ||
                (dd instanceof Integer && ds instanceof Integer)) {
            return Integer.parseInt(dd.toString()) / Integer.parseInt(ds.toString());
        }
        else if ((dd instanceof Short && ds instanceof Byte) ||
                (ds instanceof Short && dd instanceof Byte) ||
                (dd instanceof Short && ds instanceof Short)) {
            return Short.parseShort(dd.toString()) / Short.parseShort(ds.toString());
        }
        else if (dd instanceof Byte && ds instanceof Byte) {
            return (Byte)dd / (Byte)ds;
        }
        else if(dd instanceof Character) {
            if(ds instanceof Double)
                return Double.valueOf((Character)dd) / (Double)ds;
            else if (ds instanceof Float)
                return Float.valueOf((Character)dd) / (Float)ds;
            else if (ds instanceof Long)
                return Long.valueOf((Character)dd) / (Long)ds;
            else if (ds instanceof Integer)
                return Integer.valueOf((Character)dd) / (Integer)ds;
            else if (ds instanceof Short)
                return Integer.valueOf((Character)dd) / (Short)ds;
            else if (ds instanceof Byte)
                return Integer.valueOf((Character)dd) / (Byte)ds;
            else if (ds instanceof Character)
                return Integer.valueOf((Character)dd) / Integer.valueOf((Character)ds);
        }
        else if(ds instanceof Character) {
            if(dd instanceof Double)
                return (Double)dd / Double.valueOf((Character)ds);
            else if (dd instanceof Float)
                return (Float)dd / Float.valueOf((Character)ds);
            else if (dd instanceof Long)
                return (Long)dd / Long.valueOf((Character)ds);
            else if (dd instanceof Integer)
                return (Integer)dd / Integer.valueOf((Character)ds);
            else if (dd instanceof Short)
                return (Short)dd / Integer.valueOf((Character)ds);
            else if (dd instanceof Byte)
                return (Byte)dd / Integer.valueOf((Character)ds);
        }
        else if (dd instanceof Calculable && ds instanceof Calculable) {
            return ((Calculable)dd).divide((Calculable)ds);
        }
        throw new CalculationWithIncompatibleTypesException("Attempted to divide incompatible types: " + dd.getClass().getName() + " and " + ds.getClass().getName());
    }
}

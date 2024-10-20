package ru.mirea.lab20.task5;

import java.util.ArrayList;

public class Matrix<E extends Number>{
    private ArrayList<ArrayList<E>> mtr = new ArrayList<>();
    private int[] size;

    public Matrix() {
        this.size = new int[]{0, 0};
    }
    public Matrix(int[] size) {
        if(size.length != 2)
            throw new IllegalArgumentException("Incorrect length of the parameter \"size\" in Matrix(int[] size). Length of \"size\" must be 2.");
        if(size[0] < 0 || size[1] < 0)
            throw new IllegalArgumentException("Incorrect matrix sizes in Matrix(int[] size). Matrix dimensions must be natural numbers.");
        this.size = new int[]{size[0], size[1]};
        if(size[0] > 0)
            for (int i = 0; i < size[0]; i++) {
                this.mtr.add(new ArrayList<>(size[1]));
                for(int j = 0; j < size[1]; j++)
                    this.mtr.get(i).add(null);
            }
    }
    public Matrix(ArrayList<ArrayList<E>> mtr) {
        this.mtr = (ArrayList<ArrayList<E>>)mtr.clone();
        this.size = new int[]{0, 0};
        this.size[0] = mtr.size();
        if(!mtr.isEmpty())
            this.size[1] = mtr.get(0).size();
    }

    public ArrayList<ArrayList<E>> getMtr() {
        return (ArrayList<ArrayList<E>>)mtr.clone();
    }
    public void setMtr(ArrayList<ArrayList<E>> mtr) {
        this.mtr = (ArrayList<ArrayList<E>>)mtr.clone();
        this.size[0] = mtr.size();
        if(!mtr.isEmpty())
            this.size[1] = mtr.get(0).size();
        else
            this.size[1] = 0;
    }
    public int[] size() {
        return this.size.clone();
    }

    public void set(int i, int j, E val) {
        if(i < 0 || i > this.size[0] || j < 0 || j > this.size[1])
            throw new IndexOutOfBoundsException("Incorrect indexes in Matrix.set; size: [" + this.size[0] + ", " + this.size[1] + "], indexes: [" + i + ", " + j + "]");
        mtr.get(i).set(j, val);
    }
    public E get(int i, int j) {
        if(i < 0 || i > this.size[0] || j < 0 || j > this.size[1])
            throw new IndexOutOfBoundsException("Incorrect indexes in Matrix.get; size: [" + this.size[0] + ", " + this.size[1] + "], indexes: [" + i + ", " + j + "]");
        return mtr.get(i).get(j);
    }

    public Matrix<E> minor(int row, int col) {
        if(row < 0 || row > this.size[0] || col < 0 || col > this.size[1])
            throw new IndexOutOfBoundsException("Incorrect indexes in Matrix.minor; size: [" + this.size[0] + ", " + this.size[1] + "], indexes: [" + row + ", " + col + "]");
        Matrix<E> res = new Matrix<>(new int[]{this.size[0] - 1, this.size[1] - 1});
        for (int i = 0, mji = 0; i < res.size[0]; ++i, ++mji)
        {
            if (mji == row)
                ++mji;
            for (int j = 0, mjj = 0; j < res.size[1]; ++j, ++mjj)
            {
                if (mjj == col)
                    ++mjj;
                res.set(i, j, this.get(mji, mjj));
            }
        }
        return res;
    }

    public double det() {
        if(this.size[0] == 0 || this.size[1] == 0)
            throw new UnsupportedOperationException("Matrix.det: cannot calculate the determinant for an empty matrix");
        if(this.size[0] != this.size[1])
            throw new UnsupportedOperationException("Matrix.det: cannot calculate the determinant of a rectangular matrix");
        if(this.size[0] == 1)
            return this.get(0, 0).doubleValue();
        if(this.size[0] == 2)
            return this.get(0, 0).doubleValue() * this.get(1, 1).doubleValue() - this.get(0, 1).doubleValue() * this.get(1, 0).doubleValue();
        double det = 0;
        for (int j = 0; j < this.size[1]; ++j)
            det += Math.pow(-1, j % 2) * this.get(0, j).doubleValue() * this.minor(0, j).det();
        return det;
    }

    public Matrix<E> cofactor() {
        Matrix<E> res = new Matrix<>(this.size);
        for(int i = 0; i < this.size[0]; ++i)
            for (int j = 0; j < this.size[1]; ++j)
                res.set(i, j, (E)Double.valueOf(Math.pow(-1, i + j) * this.minor(i, j).det()));
        return res;
    }
    public Matrix<E> transposed() {
        Matrix<E> tmp = new Matrix<>(new int[]{this.size[1], this.size[0]});
        for (int i = 0; i < tmp.size[0]; ++i)
            for (int j = 0; j < tmp.size[1]; ++j)
                tmp.set(i, j, this.get(j, i));
        return tmp;
    }
    public Matrix<E> inverse() {
        if(this.size[0] != this.size[1])
            throw new UnsupportedOperationException("Matrix.inverse: cannot calculate the inverse matrix of a rectangular matrix");
        return new Matrix<>(Matrix.multiply(this.cofactor().transposed(), 1.0 / this.det()).getMtr());
    }

    public static <S extends Number> Matrix<S> add(Matrix<S> mtr1, Matrix<S> mtr2) {
        if(mtr1.size[0] != mtr2.size[0] || mtr1.size[1] != mtr2.size[1])
            throw new IncompatibleMatrixSizesException("Incompatible matrix sizes in Matrix.add: [" + mtr1.size[0] + ", " + mtr1.size[1] + "], [" + mtr2.size[0] + ", " + mtr2.size[1] + "]");
        Matrix<S> res = new Matrix<>(mtr1.size);
        for(int i = 0; i < mtr1.size[0]; i++)
            for(int j = 0; j < mtr1.size[1]; j++)
                res.set(i, j, (S)Double.valueOf(mtr1.get(i, j).doubleValue() + mtr2.get(i, j).doubleValue()));
        return res;
    }

    public static <S extends Number> Matrix<S> multiply(Matrix<S> mtr, double mult) {
        Matrix<S> res = new Matrix<>(mtr.size);
        for(int i = 0; i < mtr.size[0]; i++)
            for(int j = 0; j < mtr.size[1]; j++)
                res.set(i, j, (S)Double.valueOf(mtr.get(i, j).doubleValue() * mult));
        return res;
    }

    public static <S extends Number> Matrix<S> multiply(Matrix<S> mtr1, Matrix<S> mtr2) {
        if(mtr1.size[1] != mtr2.size[0])
            throw new IncompatibleMatrixSizesException("Incompatible matrix sizes in Matrix.multiply: [" + mtr1.size[0] + ", " + mtr1.size[1] + "], [" + mtr2.size[0] + ", " + mtr2.size[1] + "]");
        Matrix<S> res = new Matrix<>(mtr1.size);
        for(int i = 0; i < mtr1.size[0]; i++)
            for(int j = 0; j < mtr2.size[1]; j++) {
                double temp = 0;
                for (int k = 0; k < mtr1.size[1]; k++)
                    temp += mtr1.get(i, k).doubleValue() * mtr2.get(k, j).doubleValue();
                res.set(i, j, (S)Double.valueOf(temp));
            }
        return res;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Matrix [" + this.size[0] + ", " + this.size[1] + "] = {\n";
        for(int i = 0; i < this.size[0]; i++) {
            ret += "    { ";
            for(int j = 0; j < this.size[1]; j++) {
                if(this.get(i, j) != null)
                    ret += String.format("%8.2f", this.get(i, j).doubleValue());
                else
                    ret += "    null";
                if(j != this.size[1] - 1)
                    ret += ", ";
                else
                    ret += " }";
            }
            if(i != this.size[0] - 1)
                ret += "},\n";
            else
                ret += "}\n}";
        }
        return ret;
    }
}

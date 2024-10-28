package ru.mirea.lab23.task2;

public class Node <E>{
        private E data;
        protected Node<E> next = null;

        public Node() {
            this.data = null;
        }
        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return this.data;
        }
        public void setData(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node { " +
                    "data = " + this.data.toString() + " }";
        }
}

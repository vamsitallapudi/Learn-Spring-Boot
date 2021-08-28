package com.coderefer.learnconcepts;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StreamsPractice {
    public static class Product {

        int id;
        String code;

        void setCode(String code) {
            this.code = code;
        }

        String getCode() {
            return code;
        }

        void setId(int id) {
            this.id = id;
        }

    }

    private static void solve() throws IOException {
        // List<String> list = new ArrayList<>();
        // list.add("Vamsi");
        // list.add("Krishna");
        // list.add("Tallapudi");
        // System.out.println(list);
        // Long l2 = list.stream().filter(i -> i.length() > 5).count();
        // System.out.println(l2);

        // List<Integer> l1 = new ArrayList<>();
        // l1.add(0);
        // l1.add(10);
        // l1.add(5);
        // l1.add(15);
        // l1.add(25);
        // System.out.println(l1); // [0, 10, 5, 15, 25]
        // List<Integer> l2 = l1.stream().sorted().collect(Collectors.toList());
        // System.out.println(l2); // [0, 5, 10, 15, 25]
        // List<Integer> l3 = l1.stream().sorted((i, j) ->
        // j.compareTo(i)).collect(Collectors.toList());
        // System.out.println("Custom sorting order: " + l3);

        // List<Integer> l1 = new ArrayList<>();
        // l1.add(0);
        // l1.add(10);
        // l1.add(5);
        // l1.add(15);
        // l1.add(25);
        // Integer min = l1.stream().min((i, j) -> i.compareTo(j)).get();
        // System.out.println(min); // 0
        // Integer max = l1.stream().max((i, j) -> i.compareTo(j)).get();
        // System.out.println(max); // 25

        List<Product> productCategories = new ArrayList<>();
        Product product = new Product();
        product.setId(100);
        product.setCode("Product1");
        productCategories.add(product);
        product = new Product();
        product.setId(200);
        product.setCode("Product2");
        productCategories.add(product);
        product = new Product();
        product.setId(300);
        product.setCode("Product3");
        productCategories.add(product);

        List<String> codes = new ArrayList<>();
        productCategories.stream().forEach(it -> codes.put(it.getCode()));

    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static Reader sc = new Reader();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        /*
         * For integer input: int n=inputInt(); For long input: long n=inputLong(); For
         * double input: double n=inputDouble(); For String input: String
         * s=inputString(); Logic goes here For printing without space: print(a+"");
         * where a is a variable of any datatype For printing with space: printSp(a+"");
         * where a is a variable of any datatype For printing with new line:
         * println(a+""); where a is a variable of any datatype
         */

        solve();
        bw.flush();
        bw.close();
    }

    public static int inputInt() throws IOException {
        return sc.nextInt();
    }

    public static long inputLong() throws IOException {
        return sc.nextLong();
    }

    public static double inputDouble() throws IOException {
        return sc.nextDouble();
    }

    public static String inputString() throws IOException {
        return sc.readLine();
    }

    public static void print(String a) throws IOException {
        bw.write(a);
    }

    public static void printSp(String a) throws IOException {
        bw.write(a + " ");
    }

    public static void println(String a) throws IOException {
        bw.write(a + "\n");
    }
}

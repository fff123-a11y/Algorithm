package Shibing;

import java.util.ArrayList;
import java.util.Comparator;

public class Code04_DoubleLinkedListQuickSort {

    public class Node {
        public int value;
        public Node last;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    public static Node quickSort(Node h) {
        if (h == null) {
            return null;
        }
        int N = 0;
        Node c = h;
        Node e = null;
        while (c != null) {
            N++;
            e = c;
            c = c.next;
        }
        return process(h, e, N).h;
    }

    public static class HeadTail {
        public Node h;
        public Node t;

        public HeadTail(Node head, Node tail) {
            h = head;
            t = tail;
        }
    }

    // L...R��һ��˫�������ͷ��β,
    // L��lastָ��ָ��null��R��nextָ��ָ��null
    // Ҳ����˵L�����û�У�R���ұ�Ҳû�ڵ�
    // ����һ��������˫������һ����N���ڵ�
    // ����һ����������ŵķ�ʽ�ź���
    // �����ź���֮���˫�������ͷ��β(HeadTail)
    public static HeadTail process(Node L, Node R, int N) {
        if (L == null) {
            return null;
        }
        if (L == R) {
            return new HeadTail(L, R);
        }
        // L..R�ϲ�ֻһ���ڵ�
        // ����õ�һ������±�
        int randomIndex = (int) (Math.random() * N);
        // ��������±�õ�����ڵ�
        Node randomNode = L;
        while (randomIndex-- != 0) {
            randomNode = randomNode.next;
        }
        // ������ڵ��ԭ���Ļ�����������
        // ���� a(L) -> b -> c -> d(R), ���randomNode = c����ô����֮��
        // a(L) -> b -> d(R), c�ᱻ�ڳ�����randomNode = c
        if (randomNode == L || randomNode == R) {
            if (randomNode == L) {
                L = randomNode.next;
                L.last = null;
            } else {
                randomNode.last.next = null;
            }
        } else { // randomNodeһ�����м�Ľڵ�
            randomNode.last.next = randomNode.next;
            randomNode.next.last = randomNode.last;
        }
        randomNode.last = null;
        randomNode.next = null;
        Info info = partition(L, randomNode);
        // <randomNode�Ĳ���ȥ����
        HeadTail lht = process(info.lh, info.lt, info.ls);
        // >randomNode�Ĳ���ȥ����
        HeadTail rht = process(info.rh, info.rt, info.rs);
        // �󲿷��ź����Ҳ����ź���
        // �����Ǵ���һ��
        if (lht != null) {
            lht.t.next = info.eh;
            info.eh.last = lht.t;
        }
        if (rht != null) {
            info.et.next = rht.h;
            rht.h.last = info.et;
        }
        // �����ź���֮���ܵ�ͷ���ܵ�β
        Node h = lht != null ? lht.h : info.eh;
        Node t = rht != null ? rht.t : info.et;
        return new HeadTail(h, t);
    }

    public static class Info {
        public Node lh;
        public Node lt;
        public int ls;
        public Node rh;
        public Node rt;
        public int rs;
        public Node eh;
        public Node et;

        public Info(Node lH, Node lT, int lS, Node rH, Node rT, int rS, Node eH, Node eT) {
            lh = lH;
            lt = lT;
            ls = lS;
            rh = rH;
            rt = rT;
            rs = rS;
            eh = eH;
            et = eT;
        }
    }

    // (L....һֱ����)����һ��˫������
    // pivot��һ������(L....һֱ����)�Ķ����ڵ㣬����Ϊ����ֵ
    // ���ݺ�����������Ļ��ַ�ʽ����(L....һֱ����)���ֳ�:
    // <pivot �� =pivot �� >pivot �������֣�Ȼ���pivot�ڽ�=pivot�Ĳ���
    // ���� 4(L)->6->7->1->5->0->9->null pivot=5(���5�������е�5���ǲ�ͬ�Ľڵ�)
    // ������ɺ�:
    // 4->1->0 С�ڵĲ���
    // 5->5 ���ڵĲ���
    // 6->7->9 ���ڵĲ���
    // ���������ǶϿ���
    // Ȼ�󷵻�Info��
    // С�ڲ��ֵ�ͷ��β���ڵ���� : lh,lt,ls
    // ���ڲ��ֵ�ͷ��β���ڵ���� : rh,rt,rs
    // ���ڲ��ֵ�ͷ��β : eh,et
    public static Info partition(Node L, Node pivot) {
        Node lh = null;
        Node lt = null;
        int ls = 0;
        Node rh = null;
        Node rt = null;
        int rs = 0;
        Node eh = pivot;
        Node et = pivot;
        Node tmp = null;
        while (L != null) {
            tmp = L.next;
            L.next = null;
            L.last = null;
            if (L.value < pivot.value) {
                ls++;
                if (lh == null) {
                    lh = L;
                    lt = L;
                } else {
                    lt.next = L;
                    L.last = lt;
                    lt = L;
                }
            } else if (L.value > pivot.value) {
                rs++;
                if (rh == null) {
                    rh = L;
                    rt = L;
                } else {
                    rt.next = L;
                    L.last = rt;
                    rt = L;
                }
            } else {
                et.next = L;
                L.last = et;
                et = L;
            }
            L = tmp;
        }
        return new Info(lh, lt, ls, rh, rt, rs, eh, et);
    }

    // Ϊ�˲���
    public static class NodeComp implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.value - o2.value;
        }
    }

    // Ϊ�˲���
    public static Node sort(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head);
            head = head.next;
        }
        arr.sort(new NodeComp());
        Node h = arr.get(0);
        h.last = null;
        Node p = h;
        for (int i = 1; i < arr.size(); i++) {
            Node c = arr.get(i);
            p.next = c;
            c.last = p;
            c.next = null;
            p = c;
        }
        return h;
    }

    // Ϊ�˲���
    public Node generateRandomDoubleLinkedList(int n, int v) {
        if (n == 0) {
            return null;
        }
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node((int) (Math.random() * v));
        }
        Node head = arr[0];
        Node pre = head;
        for (int i = 1; i < n; i++) {
            pre.next = arr[i];
            arr[i].last = pre;
            pre = arr[i];
        }
        return head;
    }

    // Ϊ�˲���
    public Node cloneDoubleLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        Node h = new Node(head.value);
        Node p = h;
        head = head.next;
        while (head != null) {
            Node c = new Node(head.value);
            p.next = c;
            c.last = p;
            p = c;
            head = head.next;
        }
        return h;
    }

    // Ϊ�˲���
    public static boolean equal(Node h1, Node h2) {
        return doubleLinkedListToString(h1).equals(doubleLinkedListToString(h2));
    }

    // Ϊ�˲���
    public static String doubleLinkedListToString(Node head) {
        Node cur = head;
        Node end = null;
        StringBuilder builder = new StringBuilder();
        while (cur != null) {
            builder.append(cur.value + " ");
            end = cur;
            cur = cur.next;
        }
        builder.append("| ");
        while (end != null) {
            builder.append(end.value + " ");
            end = end.last;
        }
        return builder.toString();
    }

    // Ϊ�˲���
    private void main(String[] args) {
        int N = 500;
        int V = 500;
        int testTime = 10000;
        System.out.println("���Կ�ʼ");
        for (int i = 0; i < testTime; i++) {
            int size = (int) (Math.random() * N);
            Node head1 = generateRandomDoubleLinkedList(size, V);
            Node head2 = cloneDoubleLinkedList(head1);
            Node sort1 = quickSort(head1);
            Node sort2 = sort(head2);
            if (!equal(sort1, sort2)) {
                System.out.println("������!");
                break;
            }
        }
        System.out.println("���Խ���");
    }
}



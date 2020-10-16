import java.util.NoSuchElementException;

class SList<E> {
    Link<E> link = new Link<>(null);

    public SList() {

    }
    SListIterator iterator() {
        return new SListIterator();
    }

    @Override
    public String toString() {
        if (link.next == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        SListIterator it = new SListIterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(", ");
        }
        return sb.delete(sb.length() - 2, sb.length()).append("]").toString();
    }

    class SListIterator {
        Link<E> current = link;

        boolean hasNext() {
            return current.next != null;
        }

        E next() {
            current = current.next;
            return current.e;
        }

        void insert(E e) {
            current.next = new Link<>(e, current.next);
        }

        void remove() {
            current.next = current.next.next;
        }
    }
}

class Link<E> {
    E e;
    Link<E> next;

    Link(E e) {
        this(e, null);
    }

    Link(E e, Link<E> next) {
        this.e = e;
        this.next = next;
    }

    @Override
    public String toString() {
        if (e == null) {
            return "null";
        } else {
            return e.toString();
        }
    }
}

public class assignment10 {
    public static void main(String[] args) {
        SList<String> sList = new SList<>();
        SList<String>.SListIterator iterator = sList.iterator();
        iterator.insert("ABC");
        iterator.insert("EFG");
        iterator.insert("HIJ");
        System.out.println(sList);
    }
}

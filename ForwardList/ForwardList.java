/**ForwardList represents a list with single linked nodes, that do have
 a next-pointer. */

public class ForwardList<T> implements Iterable<T> {
    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//
    public String toString() {
        if (is_empty())
            return "[]";
        String rv = "[";
        Node node = head_;
        do {
            rv += node.data_.toString();
            if (node.next_ != head_)
                rv += ",";
            node = node.next_;
        } while (node != null);
        rv += "]";
        return rv;
    }

    //-----------------------------------------------------------------//
    //---------------- !!Insert your solution below!! -----------------//
    // A Node is a single element in the list
    public class Node {
        //---------------------------------------------------------------//
        //    !!! Do not change the existing lines in class Node!!!      //
        //            !!! It is allowed to add new content !!!           //
        //       !!! It is not allowed to add a previous pointer !!!     //
        //---------------------------------------------------------------//
        public T data_;
        public Node next_ = null;

        public Node(T data, Node next) {
            data_ = data;
            next_ = next;

        }
    }

    //-----------------------------------------------------------------//
    public Node head_ = null;

    //-----------------------------------------------------------------//
    public ForwardList() {
    }


    //-----------------------------------------------------------------//
    public void push_front(T obj) {
        // TODO: implement adding elements to the front of the list

        Node new_node = new Node(obj, head_);
        head_ = new_node;
    }

    //-----------------------------------------------------------------//
    public boolean is_empty() {
        // TODO: should return `true` if the list is empty else `false`
        if (head_ == null) {
            return true;
        } else {
            return false;
        }
    }

    //-----------------------------------------------------------------//
    public void backTraverse() {
        // TODO: implement a recursive method to print out reversed
        backTraverse(head_);
    }

    private void backTraverse(Node node) {
        if (node == null) {
            return;
        } else {

            backTraverse(node.next_);

            System.out.println(node.data_ + " ");
        }

    }

    public class BackIterator implements java.util.Iterator<T> {
        // TODO: implement an iterator that provides a reveres iteration
         Node current_;

        public BackIterator() {
            current_ = head_;
            while (current_ != null && current_.next_ != null) {
                current_ = current_.next_;
            }
        }

        @Override
        public boolean hasNext() {
            if (current_ != null){
                return true;
            }
            else {
                return false;
            }
        }

        public T next() {
            T data = current_.data_;
            Node prev = null;
            Node node = head_;
            while (node != null && node != current_) {
                prev = node;
                node = node.next_;
            }
            current_ = prev;
            return data;
        }

    }

    public BackIterator iterator() {
        // TODO: return an instance of the iterator
        return new BackIterator();
    }

    public static void main(String[] args) {
        // TODO: test your code with appropriate examples
        ForwardList<Integer> list = new ForwardList<>();
        list.push_front(5);
        list.push_front(4);
        list.push_front(3);
        list.push_front(2);
        list.push_front(1);
        list.backTraverse();

        for (int el : list) {
            System.out.print(el + " ");
        }

        System.out.println();
    }
}

/*

 */
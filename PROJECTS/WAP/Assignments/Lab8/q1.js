function LinkedList(node = null) {
    this.root = node;
    this.size = 0;

    function Node(value) {
        this.value = value;
        this.next = null;
    }

    this.add = function(newValue) {
        let newNode = new Node(newValue);
        newNode.next = this.root;
        this.root = newNode;
        this.size++;
    };

    this.remove = function(value) {
        if (this.root.value === value) {
            this.root = this.root.next;
            this.size--;
            return;
        }

        let current = this.root;
        while (current.next) {
            if (current.next.value === value) {
                current.next = current.next.next;
                this.size--;
                return;
            }
            current = current.next;
        }
    };

    this.print = function() {
        let answer = "LinkedList{";
        let current = this.root;
        while (current) {
            answer += current.value;
            if (current.next) {
                answer += ",";
            }
            current = current.next;
        }
        answer += "}";
        console.log(answer);
    };
}



let linkedlist = new LinkedList();

linkedlist.add(1);
linkedlist.add(2);
linkedlist.add(3);
linkedlist.print();
linkedlist.remove(2);
linkedlist.print();

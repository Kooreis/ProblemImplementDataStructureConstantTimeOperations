class CustomDataStructure {
    private Node head, tail;
    private Map<String, Node> countNodeMap;
    private Map<String, Integer> keyCountMap;

    public CustomDataStructure() {
        this.head = new Node(0);
        this.tail = new Node(0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.countNodeMap = new HashMap<>();
        this.keyCountMap = new HashMap<>();
        this.countNodeMap.put(0, this.head);
    }
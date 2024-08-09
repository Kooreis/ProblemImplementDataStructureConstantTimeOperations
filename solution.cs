public class AllOne
{
    private Dictionary<string, int> dict;
    private Dictionary<int, Node> nodes;
    private Node head, tail;

    public AllOne()
    {
        dict = new Dictionary<string, int>();
        nodes = new Dictionary<int, Node>();
        head = new Node(int.MinValue);
        tail = new Node(int.MaxValue);
        head.next = tail;
        tail.prev = head;
    }
}
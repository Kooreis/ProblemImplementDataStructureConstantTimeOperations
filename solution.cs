using System;
using System.Collections.Generic;

public class Node
{
    public int val;
    public HashSet<string> keys = new HashSet<string>();
    public Node prev, next;
    public Node(int val)
    {
        this.val = val;
    }
}

public class TreapNode {

    TreapNode left;//左节点
    TreapNode right;//右节点
    int priority;//优先级
    int key;//存储的关键字

    public TreapNode() {}

    public TreapNode(int key, int priority) {
        this.priority = priority;
        this.key = key;
    }
}
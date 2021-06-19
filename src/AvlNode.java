public class AvlNode {
    protected long height;       // Height
    protected long key;
    protected AvlNode left, right;

    public AvlNode ( long theElement ) {
        this( theElement, null, null );
    }

    public AvlNode ( long x, AvlNode lt, AvlNode rt ) {
        key = x;
        left = lt;
        right = rt;
        height   = 0;
    }
}
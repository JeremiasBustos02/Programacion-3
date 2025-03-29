package ProgramacionIII.TP2_1_Arboles;

public class TreeNodeInt {
    private Integer value;
    private TreeNodeInt left;
    private TreeNodeInt right;

    public TreeNodeInt(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Integer getValue() {
        return value;
    }

    public TreeNodeInt getLeft() {
        return left;
    }

    public TreeNodeInt getRight() {
        return right;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setLeft(TreeNodeInt left) {
        this.left = left;
    }

    public void setRight(TreeNodeInt right) {
        this.right = right;
    }
}

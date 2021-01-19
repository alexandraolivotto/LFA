package glyphoinstructions;

public abstract class GlyphoInstruction {
    protected Type name;
    private int tag;
    private int idx;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getTag() {
        return tag;
    }

    public Type getName() {
        return name;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public abstract void run();
}

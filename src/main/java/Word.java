public class Word implements Comparable<Word>{
    String name;
    int count;

    public Word(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(Word o) {
        if(count == o.count)
            return 0;
        if(count > o.count)
            return -1;
        return 1;
    }

    @Override
    public String toString() {
        return name + " " + count;
    }
}


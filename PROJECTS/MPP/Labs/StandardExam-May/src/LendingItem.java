import java.util.Objects;

public class LendingItem {

    private int numCopiesInLib;

    LendingItem(int numCopiesInLib){
        this.numCopiesInLib = numCopiesInLib;
    }

    public int getNumCopiesInLib() {
        return numCopiesInLib;
    }

    public void setNumCopiesInLib(int numCopiesInLib) {
        this.numCopiesInLib = numCopiesInLib;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LendingItem that)) return false;
        return getNumCopiesInLib() == that.getNumCopiesInLib();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumCopiesInLib());
    }
}

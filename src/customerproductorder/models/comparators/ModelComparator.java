

package customerproductorder.models.comparators;
import java.util.*;
import customerproductorder.models.*;

public class ModelComparator implements Comparator<NameGetable> {
    @Override
    public int compare(NameGetable t, NameGetable t1) {
       return t1.getName().compareTo(t.getName());
    }

}

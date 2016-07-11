package customerproductorder.models.comparators;

import java.util.Comparator;
import customerproductorder.models.NameGetable;

/**
 * Our comparator.
 */
public class ModelComparator implements Comparator<NameGetable> {

    /**
     * Overrided method Comparator.compare()
     *
     * @return int result of comparing
     */
    @Override
    public int compare(NameGetable t, NameGetable t1) {
        return t1.getName().compareTo(t.getName());
    }

}

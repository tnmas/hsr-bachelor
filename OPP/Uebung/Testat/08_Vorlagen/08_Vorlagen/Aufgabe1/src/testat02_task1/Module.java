package testat02_task1;

/*
 * @author Tsigereda
 * */

import java.util.Set;
import java.util.TreeSet;

public class Module {


    private final String module;
    private final Set<String> prerequisites = new HashSet<String>();


    public Module(String module) {
        this.module = module;
    }

    public String getName() {
        return module;
    }

    /**
     * Add a prerequisite module into the container
     *
     * @param module prerequisite module
     */

    public void addPrerequisites(String module) {
        prerequisites.add(module);
    }

    /**
     * Remove a prerequisite module from the container
     *
     * @param module prerequisite module
     */
    public void removePrerequisites(String module) {
        prerequisites.remove(module);
    }

    /**
     * Check if module has prerequisites
     */
    public boolean hasPrerequisites() {
        return !prerequisites.isEmpty();
    }

    @Override
    public String toString() {
        return module;
    }


}

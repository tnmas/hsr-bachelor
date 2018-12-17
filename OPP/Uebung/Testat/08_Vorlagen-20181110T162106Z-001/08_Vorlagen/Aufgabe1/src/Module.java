/*
 * @author Tsigereda
 * */

import java.util.Set;
import java.util.TreeSet;

public class Module {


    private final String module;
    private final Set<String> prerequisites = new TreeSet<>();


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

    public void addModule(String module) {
        prerequisites.add(module);
    }

    /**
     * Remove a prerequisite module from the container
     *
     * @param module prerequisite module
     */
    public void removeModule(String module) {
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

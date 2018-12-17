import java.util.HashSet;
import java.util.Set;


public class Test {
	public static void main(String[] args) throws Exception {
        Set<Module> modules = new HashSet<>();

		try (var reader = new CatalogueReader("StudyCatalogue.txt")) {
			String[] names;
			while ((names = reader.readNexteLine()) != null) {
                Module module = new Module(names[0]);
                modules.add(module);

				for (int i = 1; i < names.length; i++) {
                    module.addModule(names[i]);
				}
			}
			semester(modules);
		}
	}

	/**
     * Add the modules that could be taken this semester
     * @param modules
     *         modules of the current semester
     * */

	private static void semester(Set<Module> modules) {
	    int num = 0;
	    while (!modules.isEmpty()) {
	        Set<Module> thisSemester = new HashSet<>();
	        num++;
            for (Module module: modules) {
                if (!module.hasPrerequisites()) {
                    thisSemester.add(module);
                }
            }

            System.out.println("Semester - " + num + " " + thisSemester);
            removeModules(modules, thisSemester);
        }

    }

    /**
     * Delete the modules, which already taken
     * @param modules
     *          modules of the current semester
     * @param thisSemester
     *      current semester
     * */

    private static void removeModules(Set<Module> modules, Set<Module> thisSemester) {

	    for (Module thisSemesterModule : thisSemester) {
	        modules.remove(thisSemesterModule);
	        for (Module otherSemesterModule : modules) {
	            otherSemesterModule.removeModule(thisSemesterModule.getName());
            }
        }
    }
}

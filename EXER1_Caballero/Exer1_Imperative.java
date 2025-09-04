/**
 * Imperative Programming Example
 * 
 * This program demonstrates imperative programming concepts in Java
 * by processing a list of GitHub repositories and generating a report.
 * 
 * @author Aldryan Venth Caballero 
 * @version 1.0
 */
public class GitHubRepositoriesProcessor {

    /**
     * Repository class representing a GitHub repository
     */
    static class Repository {
        private String name;
        private int stars;
        private int forks;
        private boolean isPublic;
        
        public Repository(String name, int stars, int forks, boolean isPublic) {
            this.name = name;
            this.stars = stars;
            this.forks = forks;
            this.isPublic = isPublic;
        }
        
        public String getName() { return name; }
        public int getStars() { return stars; }
        public int getForks() { return forks; }
        public boolean isPublic() { return isPublic; }
        
        @Override
        public String toString() {
            return String.format("Repository{name='%s', stars=%d, forks=%d, public=%b}", 
                                name, stars, forks, isPublic);
        }
    }
    
    /**
     * Main method - program entry point
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("GitHub Repository Processor");
        System.out.println("===========================");
        
        // Create a list of repositories (imperative data creation)
        Repository[] repositories = {
            new Repository("awesome-project", 150, 30, true),
            new Repository("private-tool", 42, 5, false),
            new Repository("java-utils", 87, 15, true),
            new Repository("learning-resources", 210, 45, true),
            new Repository("experimental-feature", 15, 2, true)
        };
        
        // Process repositories (imperative approach)
        processRepositories(repositories);
    }
    
    /**
     * Process repositories using imperative programming style
     * 
     * @param repositories array of Repository objects to process
     */
    public static void processRepositories(Repository[] repositories) {
        // 1. Filter public repositories (imperative filtering)
        System.out.println("\n1. Public Repositories:");
        Repository[] publicRepos = filterPublicRepositories(repositories);
        printRepositories(publicRepos);
        
        // 2. Calculate total stars (imperative reduction)
        System.out.println("\n2. Total Stars across all repositories:");
        int totalStars = calculateTotalStars(repositories);
        System.out.println("Total stars: " + totalStars);
        
        // 3. Find most popular repository (imperative search)
        System.out.println("\n3. Most Popular Repository:");
        Repository mostPopular = findMostPopularRepository(repositories);
        System.out.println(mostPopular);
        
        // 4. Transform repository names to uppercase (imperative transformation)
        System.out.println("\n4. Repository Names in Uppercase:");
        String[] uppercaseNames = getUppercaseNames(repositories);
        printNames(uppercaseNames);
    }
    
    /**
     * Filter public repositories (imperative implementation)
     * 
     * @param repositories array of repositories to filter
     * @return array containing only public repositories
     */
    private static Repository[] filterPublicRepositories(Repository[] repositories) {
        // Count public repositories first
        int count = 0;
        for (Repository repo : repositories) {
            if (repo.isPublic()) {
                count++;
            }
        }
        
        // Create array of appropriate size
        Repository[] publicRepos = new Repository[count];
        
        // Fill the array
        int index = 0;
        for (Repository repo : repositories) {
            if (repo.isPublic()) {
                publicRepos[index] = repo;
                index++;
            }
        }
        
        return publicRepos;
    }
    
    /**
     * Calculate total stars across all repositories (imperative implementation)
     * 
     * @param repositories array of repositories
     * @return sum of all stars
     */
    private static int calculateTotalStars(Repository[] repositories) {
        int total = 0;
        for (Repository repo : repositories) {
            total += repo.getStars();
        }
        return total;
    }
    
    /**
     * Find the repository with the most stars (imperative implementation)
     * 
     * @param repositories array of repositories
     * @return repository with the highest star count
     */
    private static Repository findMostPopularRepository(Repository[] repositories) {
        if (repositories.length == 0) {
            return null;
        }
        
        Repository mostPopular = repositories[0];
        for (int i = 1; i < repositories.length; i++) {
            if (repositories[i].getStars() > mostPopular.getStars()) {
                mostPopular = repositories[i];
            }
        }
        
        return mostPopular;
    }
    
    /**
     * Transform repository names to uppercase (imperative implementation)
     * 
     * @param repositories array of repositories
     * @return array of uppercase repository names
     */
    private static String[] getUppercaseNames(Repository[] repositories) {
        String[] names = new String[repositories.length];
        for (int i = 0; i < repositories.length; i++) {
            names[i] = repositories[i].getName().toUpperCase();
        }
        return names;
    }
    
    /**
     * Print array of repositories
     * 
     * @param repositories array of repositories to print
     */
    private static void printRepositories(Repository[] repositories) {
        for (Repository repo : repositories) {
            System.out.println("  - " + repo);
        }
    }
    
    /**
     * Print array of names
     * 
     * @param names array of names to print
     */
    private static void printNames(String[] names) {
        for (String name : names) {
            System.out.println("  - " + name);
        }
    }
}

import java.util.List;
import java.util.Optional;

/**
 * Declarative GitHub-style Java example demonstrating:
 * - Stream processing
 * - Optional error handling
 * - Immutable data structures
 * - Lambda expressions
 */
public class GitHubStyleDeclarative {

    record Repository(String name, int stars, boolean isPublic) {}
    record Contributor(String name, int commits) {}

    public static void main(String[] args) {
        // Declarative data initialization
        List<Repository> repositories = List.of(
            new Repository("ai-project", 128, true),
            new Repository("core-library", 342, false),
            new Repository("learning-spring", 89, true)
        );

        List<Contributor> contributors = List.of(
            new Contributor("octocat", 42),
            new Contributor("torvalds", 189),
            new Contributor("alice", 76)
        );

        // Declarative processing pipeline (GitHub-style star filtering)
        repositories.stream()
            .filter(repo -> repo.stars() > 100)
            .filter(Repository::isPublic)
            .map(Repository::name)
            .map(String::toUpperCase)
            .forEach(System.out::println);

        // Declarative error handling with Optional
        findContributorWithMoreThan100Commits(contributors)
            .ifPresentOrElse(
                contributor -> System.out.println("Found: " + contributor.name()),
                () -> System.out.println("No heavy contributors found")
            );
    }

    // Declarative search with Optional
    private static Optional<Contributor> findContributorWithMoreThan100Commits(List<Contributor> contributors) {
        return contributors.stream()
            .filter(contributor -> contributor.commits() > 100)
            .findFirst();
    }
}

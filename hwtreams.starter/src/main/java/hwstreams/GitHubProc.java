package hwstreams;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GitHubProc {
  public static Long getWordCount(Stream<GitHubComment> stream, String word) {
    return (stream
      .flatMap(comment -> Stream.of(Util.getWords(comment.body())))
      .filter(wd -> wd.equals(word))
      .count());
  }

  public static Map<String, Long> getPerProjectCount(Stream<GitHubComment> stream) {
    return stream
      .collect(
        Collectors.groupingBy(comment -> Util.getProject(comment),
        Collectors.counting()));
  }

  public static Map<String, Long> getAuthorActivity(Stream<GitHubComment> stream) {
    return stream
      .collect(Collectors.groupingBy(GitHubComment::author, Collectors.counting()));
  }

  public static Map<String, Long> getCommentUrlAuthorCount(Stream<GitHubComment> stream) {
    return filterCommentsWithUrl(stream)
      .collect(Collectors.groupingBy(GitHubComment::author, Collectors.counting()));
  }

  public static Stream<GitHubComment> filterCommentsWithUrl(Stream<GitHubComment> comments) {
    return comments
      .filter(com -> com.body().contains("http://") || com.body().contains("https://"));
  }

  public static Map<String, Double> getAuthorAverageVerbosity(Stream<GitHubComment> stream) {
    return stream
      .collect(Collectors.groupingBy(
        GitHubComment::author,
        Collectors.averagingLong(
          comment -> Stream.of(Util.getWords(comment.body())).count())));
  }

  public static Map<String, Map<String, Long>> getAuthorWordCountPerProject(
      Stream<GitHubComment> stream, String word) {
    return null;
  }
}

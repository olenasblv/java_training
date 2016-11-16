package ua.qa.training.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by osoboleva on 11/16/2016.
 */
public class GithubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("80cf3b1095c4fe993af06d832184d12bc17200fe");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("olenasblv", "java_training")).commits();
        for (RepoCommit commit: commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }

}

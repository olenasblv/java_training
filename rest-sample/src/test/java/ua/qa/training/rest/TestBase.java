package ua.qa.training.rest;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * Created by osoboleva on 11/15/2016.
 */
public class TestBase {

    public Executor getExecutor() {
        return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
    }

    public boolean isIssueOpen(int issueId) throws IOException {
        String json = getExecutor()
                .execute(Request.Get(String.format("http://demo.bugify.com/api/issues/%s.json", issueId)))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        JsonElement issue = issues.getAsJsonArray().get(0);
        JsonElement state = issue.getAsJsonObject().get("state_name");
        String stateName = state.toString();
        if (!stateName.equals("Resolved") && !stateName.equals("Closed")) {
            return true;
        } else {
            return false;
        }
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}

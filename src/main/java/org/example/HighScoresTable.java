package org.example;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.*;

import javax.swing.*;
import java.util.List;

public class HighScoresTable extends JDialog {
    public HighScoresTable(JFrame parent) {
        super(parent);
        this.setSize(300, 300);
        this.setModal(true);
        this.setVisible(true);

        getHighScores();
    }

    public void getHighScores(){
        Region region = Region.US_EAST_1;
        LambdaClient client = LambdaClient.builder().region(region).build();

        try {
            InvokeRequest request = InvokeRequest.builder()
                    .functionName("HighScoreLeaderboardPython")
                    .build();

            InvokeResponse res = client.invoke(request);
            String value = res.payload().asUtf8String();
            System.out.println(value);

            Object jsonObject = JSONValue.parse(value);
            String name =

        } catch (LambdaException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}

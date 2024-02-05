package aws.example;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.costexplorer.CostExplorerClient;
import software.amazon.awssdk.services.costexplorer.model.*;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * @author laiw
 * @date 2024/1/25 14:31
 */
public class GetCostAndUsageExample {

    private static final String host = "https://ce.us-east-1.amazonaws.com";
    private static final String accessKey = "AKIAQHBP6CMUTAOYGIMC";
    private static final String secretKey = "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";
    private static final Region region = Region.US_EAST_1;

    private static final String start = "2024-01-22";
    private static final String end = "2024-01-23";


    public static void main(String[] args) {

        AwsCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);

        StaticCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(credentials);

        CostExplorerClient client = CostExplorerClient.builder()
                .credentialsProvider(credentialsProvider)
                .region(region)
                .build();

        GetCostAndUsageRequest request = GetCostAndUsageRequest.builder()
                .filter((Consumer<Expression.Builder>) null)
                .granularity(Granularity.DAILY)
                .groupBy((Collection<GroupDefinition>) null)
                .metrics("UnblendedCost", "UsageQuantity")
                .timePeriod(DateInterval.builder()
                        .start(start)
                        .end(end)
                        .build())
                .build();

        GetCostAndUsageResponse response = client.getCostAndUsage(request);

        System.out.println(response.toString());

    }

}

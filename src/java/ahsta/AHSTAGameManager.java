package ahsta;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class AHSTAGameManager {

	private final AHSTAGameDao ahstaGameDao;
	

    public AHSTAGameManager(final AmazonDynamoDBClient amazonDynamoDbClient) {
        ScoreKeeperDynamoDbClient dynamoDbClient =
                new ScoreKeeperDynamoDbClient(amazonDynamoDbClient);
        ahstaGameDao = new AHSTAGameDao(dynamoDbClient);
    }

	
}

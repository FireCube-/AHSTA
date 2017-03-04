package ahsta;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshaller;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshalling;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@DynamoDBTable(tableName = "AHSTAGameData")
public class AHSTAGameDataItem {
	
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private String customerId;

    private AHSTAGameData gameData;

    @DynamoDBHashKey(attributeName = "CustomerId")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @DynamoDBAttribute(attributeName = "Data")
    @DynamoDBMarshalling(marshallerClass = AHSTAGameDataMarshaller.class)
    public AHSTAGameData getGameData() {
        return gameData;
    }

    public void setGameData(AHSTAGameData gameData) {
        this.gameData = gameData;
    }

    /**
     * A {@link DynamoDBMarshaller} that provides marshalling and unmarshalling logic for
     * {@link AHSTAGameData} values so that they can be persisted in the database as String.
     */
    public static class AHSTAGameDataMarshaller implements
            DynamoDBMarshaller<AHSTAGameData> {

        @Override
        public String marshall(AHSTAGameData gameData) {
            try {
                return OBJECT_MAPPER.writeValueAsString(gameData);
            } catch (JsonProcessingException e) {
                throw new IllegalStateException("Unable to marshall game data", e);
            }
        }

        @Override
        public AHSTAGameData unmarshall(Class<AHSTAGameData> clazz, String value) {
            try {
                return OBJECT_MAPPER.readValue(value, new TypeReference<AHSTAGameData>() {
                });
            } catch (Exception e) {
                throw new IllegalStateException("Unable to unmarshall game data value", e);
            }
        }
    }
}


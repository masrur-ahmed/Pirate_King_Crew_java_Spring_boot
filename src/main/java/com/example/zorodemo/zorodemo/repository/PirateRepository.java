package com.example.zorodemo.zorodemo.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.zorodemo.zorodemo.model.Damage;
import com.example.zorodemo.zorodemo.model.Pirates;
import com.example.zorodemo.zorodemo.config.DynamoDbConf;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PirateRepository {

    private DynamoDBMapper dynamoDBMapper;

    public PirateRepository() {
        dynamoDBMapper = new DynamoDbConf().new DynamoDbConfiguration().dynamoDBMapper();
    }


    public Pirates save(Pirates pirates){
        dynamoDBMapper.save(pirates);
        return pirates;
    }
    public Pirates getCrewById(String crewid) {
        return dynamoDBMapper.load(Pirates.class, crewid);
    }

    public String delete(String crewid) {
        Pirates pirate = dynamoDBMapper.load(Pirates.class, crewid);
        dynamoDBMapper.delete(pirate);
        return "Kicked out of the crew!";
    }

    public String update(String ignoredCrewid, Pirates pirate) {
        dynamoDBMapper.save(pirate,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("crewid",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(ignoredCrewid)
                                )));
        return ignoredCrewid;
    }

}

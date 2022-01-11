package com.example.zorodemo.zorodemo.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.zorodemo.zorodemo.model.Damage;
import com.example.zorodemo.zorodemo.config.DynamoDbConf;
import org.springframework.stereotype.Repository;

@Repository
public class DamageRepository {
    private final DynamoDBMapper dynamoDBMapper;

    public DamageRepository() {
        dynamoDBMapper = new DynamoDbConf().new DynamoDbConfiguration().dynamoDBMapper();
    }


    public Damage save(Damage dmg){
        dynamoDBMapper.save(dmg);
        return dmg;
    }
    public Damage getMoveById(int damageid) {
        return dynamoDBMapper.load(Damage.class, damageid);
    }

    public String delete(int damageid) {
        Damage dmg = dynamoDBMapper.load(Damage.class, damageid);
        dynamoDBMapper.delete(dmg);
        return "Kicked out of the crew!";
    }

    public int update(int damageid, Damage dmg) {
        dynamoDBMapper.save(dmg,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("damageid",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withN(new String(damageid+""))
                                )));
        return damageid;
    }
}

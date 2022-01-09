package com.example.zorodemo.zorodemo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "strawhats")

public class Pirates {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String crewid;

    @DynamoDBAttribute
    private String firstname;

    @DynamoDBAttribute
    private String lastname;

    @DynamoDBAttribute
    private String weaponType;

    @DynamoDBAttribute
    private String specialAttack;

    @DynamoDBAttribute
    private boolean devilFruit;

    @DynamoDBAttribute
    private String devilFruitName;

    //@DynamoDBAttribute
    //private Damage dmg;


}

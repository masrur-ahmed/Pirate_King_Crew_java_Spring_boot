package com.example.zorodemo.zorodemo.util;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.example.zorodemo.zorodemo.model.Damage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DamageTypeConverter implements DynamoDBTypeConverter<String, Damage>{

    /*@Override
    public String convert(Damage damage) {
        String dmgValue = null;
        try{
            if(damage != null)dmgValue = String.format("%d, %s, %s, %d", damage.getDamageid(), damage.getMoveName(), damage.getCrewid(), damage.getDamagePerMove());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dmgValue;
    }

    @Override
    public Damage unconvert(String s) {
        Damage dmg = null;
        try{

            if(s != null && s.length()!=0){
                String [] data = s.split(",");
                if(data.length == 4)dmg = new Damage(Integer.valueOf(data[0]), String.valueOf(data[1]), String.valueOf(data[1]), Integer.valueOf(data[2]));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dmg;
    }*/
    ObjectMapper mapper;
    @Override
    public String convert(Damage damage){
        String dmgValue = null;
        mapper = new ObjectMapper();
        try{
            if(damage != null) {
                dmgValue = mapper.writeValueAsString(damage);
                System.out.println(dmgValue);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return dmgValue;
    }
    @Override
    public Damage unconvert(String s){
        Damage dmg = null;
        try{
            if(s != null && s.length()!=0){
                dmg = mapper.readValue(s, Damage.class);
            }

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return dmg;
    }
}

const redis = require('redis');
const redisConnectionOptions = {
    host: 'redis-11490.c14.us-east-1-3.ec2.cloud.redislabs.com',
    port: 11490,
    password: '15061980'
}
const redisClient = redis.createClient( redisConnectionOptions );
const quantity_type_set_key = 'quantity_type'

module.exports = {
    connectToRedis : function() {
        redisClient.on('connect', function( err ) {
            if ( err ) {
                console.error('An error occurred during connecting to the Redis: ' + err );
            } else {
                console.log('Redis DB is connected.');
            }
        });
    },

    addToQuantityType : function( newType, callbackFunction ) {
        addToSet( quantity_type_set_key, newType, callbackFunction );
    },

    returnAllQuantityTypes : function( callbackFunction ) {
        returnAllSetMembers( quantity_type_set_key, callbackFunction );
    }    
}

function addToSet( setKey, newItem, callbackFunction ) {    
    redisClient.sadd([setKey, newItem], function( err, reply ) {
        if ( err ) {
            console.error('An error occurred during adding to the set (' + setKey + ') : ' + err );
            callbackFunction( '', err );
        } else {
            console.log('New item (' + newItem + ') is successfully added to the set (' + setKey + '). Reply : ' + reply );
            callbackFunction( reply, null );
        }            
    });     
}

function returnAllSetMembers( setKey, callbackFunction ) {
    redisClient.smembers(setKey, function( err, reply ) {
        if ( err ) {
            console.error('An error occurred during returning all members in the set (' + setKey + ') : ' + err );
            callbackFunction( '', err );
        } else {
            console.log('All members in the set (' + setKey + ') are successfully returned. Reply : ' + reply );
            callbackFunction( reply, null );
        }                    
    });    
}

var dataLayer = require('./dataLayer')
dataLayer.connectToRedis();

exports.get_quantity_type_list = function( req, res ) {
    dataLayer.returnAllQuantityTypes( function( reply, err ) {
        if ( err != null ) {
            res.json( 'Error : ' + err );
        } else {
            res.json( JSON.stringify( reply ) );
        }        
    });
};

exports.create_a_quantity_type = function( req, res ) {
    dataLayer.addToQuantityType( req.body.name, function( reply, err ) {
        if ( err != null ) {
            res.json( 'Error : ' + err );
        } else if ( reply == 0 ) {            
            res.json( 'New quantity type (' + req.body.name + ') is already in the quantity set' );
        } else {
            res.json( 'New quantity type (' + req.body.name + ') is successfully added to the quantity set' );
        }       
    } )
}; 

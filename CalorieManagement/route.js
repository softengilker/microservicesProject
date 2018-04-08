module.exports = function(app) {
    var controller = require('./controller');

    app.route('/quantity_types')
        .get( controller.get_quantity_type_list )
        .post( controller.create_a_quantity_type );
}

const mongoose = require('mongoose');

mongoose.connect('link do mongo', { useMongoClient: true });
mongoose.Promise = global.Promise;

module.exports = mongoose;
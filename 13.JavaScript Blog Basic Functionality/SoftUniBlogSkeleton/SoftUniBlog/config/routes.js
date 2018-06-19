const userController = require('./../controllers/user');
const homeController = require('./../controllers/home');

// first we need to let this file know about our article controller:
const articleController = require('./../controllers/article');

module.exports = (app) => {
    app.get('/', homeController.index);

    app.get('/user/register', userController.registerGet);
    app.post('/user/register', userController.registerPost);

    app.get('/user/login', userController.loginGet);
    app.post('/user/login', userController.loginPost);

    // We add the paths to out get and post methods in the create action article controller!
    app.get('/article/create', articleController.createGet);
    app.post('/article/create', articleController.createPost);

    // We add the get metod to the details action in our article details page
    // And we secify that we need a parameter ID at the end of our link!
    app.get('/article/details/:id', articleController.details);

    app.get('/user/details/:id', userController.details)

    app.get('/user/logout', userController.logout);
};


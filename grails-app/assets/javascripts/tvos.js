// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require tvml/tvmlkit.js
//= require_self
var baseURL;

App.onLaunch = function(options) {
    baseURL = options.BASEURL;
    var extension = "tvml";
    getDocument(extension);
}
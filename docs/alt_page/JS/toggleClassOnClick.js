(function(){

var container = $(".container");
var header = $(".header");

/**
 * A function constructor to create a new instacnce of an Animation Object
 *
 * @param {jQuery Object} elementToShow -  a jquery object representing an element that will be shown/hidden when the elementContainer is clicked.
 * @param {jQuery Object} elementToToggle_1 - a jquery object representing an element that will have the classesToToggle toggled when the elementContainer is clicked.
 * @param {jQuery Object} elementToToggle_2 - a second jquery object representing an element that will also have the classesToToggle toggled when the elementContainer is clicked.
 */
ClickToggleObj = function(elementContainer, elementToShow, elementToToggle_1, elementToToggle_2) {
    this.elementContainer = elementContainer;
    this.elementToShow = elementToShow;
    this.elementToToggle_1 = elementToToggle_1;
    this.elementToToggle_2 = elementToToggle_2;
};

/**
 * A function to call either the showElements or the hideElements function.
 */
ClickToggleObj.prototype.showHide = function() {
    var self = this;
    self.elementContainer.click(function() {

      (self.elementToShow.css('display') === 'none') ? self.showElements() : self.hideElements();

    });
};

/**
 * A function to hide the ClickToggleObj's elements.
 */
ClickToggleObj.prototype.hideElements = function() {
    var self = this;
    this.elementToShow.slideUp(50);
    this.toggleClasses();
    header.slideDown(600, function() {
        $('html, body').animate({
            scrollTop: $(self.elementContainer).offset().top
        }, 600);
    });
};

/**
 * A function to show the ClickToggleObj's elements.
 */
ClickToggleObj.prototype.showElements = function() {
    var self = this;
    this.toggleClasses();
    header.slideUp(700, function() {
        $('html, body').animate({
            scrollTop: $(self.elementContainer).offset().top
        }, 400);
    });
    this.elementToShow.slideDown(1200);
};

ClickToggleObj.prototype.toggleClasses = function() {
    container.toggleClass("container-none");
    this.elementToToggle_1.toggleClass("gone");
    this.elementToToggle_2.toggleClass("gone");
};
})();
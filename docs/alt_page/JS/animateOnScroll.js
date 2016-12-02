(function(){

var jQwindow = $(window);
var viewBottom = jQwindow.scrollTop() + window.innerHeight;
var viewTop = jQwindow.scrollTop();

/**
 * A function constructor to create a new instacnce of an Animation Object
 *
 * @param {jQuery Object} elementContainer - a jquery object representing the element containing the element to animate.
 * @param {jQuery Object} elementToAnimate -  a jquery object representing an element to animate in when the elementContainer enters viewport.
 */
AnimaObj = function(elementToAnimate, elementContainer) {
    this.elementContainer = elementContainer;
    this.elTop = elementContainer.offset().top;
    this.elBottom = elementContainer.offset().top + elementContainer.outerHeight(true);
    this.inViewMem = false;
    this.elementToAnimate = elementToAnimate;
};

/**
 * A function to update the AnimaObj's top and bottom position with their respective current positions.
 *
 * @return {AnimaObj} - returns this modified instance of AnimaObj.
 */
AnimaObj.prototype.resetElSize = function() {

    this.elTop = this.elementContainer.offset().top;
    this.elBottom = this.elementContainer.offset().top + this.elementContainer.outerHeight(true);
    return this;
};


/**
 * A function to add the CSS animation.  Toggles the class "slide-in-right" which contains the translation animation.
 * Ensures the element is visible by removing the CSS class "gone" and toggling the class "display-block".
 */
AnimaObj.prototype.startAnimation = function() {
    var self = this;
        this.toggleAnimation();
        this.elementToAnimate.one(whichAnimationEvent(), function() {
            self.toggleAnimation();
        });
};

/**
 * A function to remove the CSS animation.  Toggles the class "slide-in-right" which contains the translation animation.
 * Ensures the element is visible by toggling the class "display-block".
 */
AnimaObj.prototype.toggleAnimation = function() {

        this.inViewMem = true;
        this.elementToAnimate.removeClass("gone");
        this.elementToAnimate.toggleClass("slide-in-right");
};

/**
 * A function added to the AnimaObj's prototype to check if the
 * elementToAnimate's container is in the viewport
 */
AnimaObj.prototype.isInView = function() {

        return (viewTop < this.elTop && viewBottom > this.elBottom);
};

/**
 * A function to check the browsers Animation Event.
 * This prevents jquerys "one" callback from being called more than once in the event that the browser supports more than one.
 *
 * @return {String} - Returns the browsers animation event.
 */
function whichAnimationEvent() {
    var a;
    var el = document.createElement('fakeelement');
    var animations = {
      'animation':'animationend',
      'OAnimation':'oAnimationEnd',
      'MozAnimation': 'animationend',
      'WebkitAnimation':'webkitAnimationEnd'
    };

    for(a in animations){
        if( el.style[a] !== undefined ){
            return animations[a];
        }
    }
}
/**
 * Creating a function as a property of the window object to initiate the on load, resize and scroll function call and abstract out the checkViewPort function.
 */
initAnimation = function() {
    /*
     * A function set the new window dimensions and the new element positions for each AnimaObj after load, resize and scroll.
     * Also checking if AnimaObj's containerElement is in view for each AnimaObj.
     */
    function checkViewPort() {
        viewBottom = jQwindow.scrollTop() + window.innerHeight;
        viewTop = jQwindow.scrollTop();

        animaObjs.forEach(function(element, index, array) {
            if(!element.inViewMem && element.resetElSize().isInView()){
                    element.startAnimation();
            }
        });
    }
    jQwindow.on("load resize scroll", checkViewPort);
};
})();
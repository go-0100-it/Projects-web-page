(function(){var container=$(".container");var header=$(".header");ClickToggleObj=function(elementContainer,elementToShow,elementToToggle_1,elementToToggle_2){this.elementContainer=elementContainer;this.elementToShow=elementToShow;this.elementToToggle_1=elementToToggle_1;this.elementToToggle_2=elementToToggle_2;};ClickToggleObj.prototype.showHide=function(){var self=this;self.elementContainer.click(function(){(self.elementToShow.css('display')==='none')?self.showElements():self.hideElements();});};ClickToggleObj.prototype.hideElements=function(){var self=this;this.elementToShow.slideUp(50);this.toggleClasses();header.slideDown(600,function(){$('html, body').animate({scrollTop:$(self.elementContainer).offset().top},600);});};ClickToggleObj.prototype.showElements=function(){var self=this;this.toggleClasses();header.slideUp(700,function(){$('html, body').animate({scrollTop:$(self.elementContainer).offset().top},400);});this.elementToShow.slideDown(1200);};ClickToggleObj.prototype.toggleClasses=function(){container.toggleClass("container-none");this.elementToToggle_1.toggleClass("gone");this.elementToToggle_2.toggleClass("gone");};})();
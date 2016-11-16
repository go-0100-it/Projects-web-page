+( function(){

    var jWindow    = $(window);
	var container  = $(".container");
	var header     = $(".header");
	var viewBottom = jWindow.scrollTop() + window.innerHeight;
    var viewTop    = jWindow.scrollTop();

    function OnScroll(elementContainer, elementToAnimate_1, elementToAnimate_2, elementToToggle_1, elementToToggle_2, scroller) {
        this.elementContainer   = elementContainer;
        this.elTop              = this.elementContainer.offset().top;
        this.elBottom           = this.elementContainer.offset().top + this.elementContainer.outerHeight(true);
        this.inViewMem          = false;
        this.classesToToggle    = "slide-in-right gone";
        this.elementToAnimate_1 = elementToAnimate_1;
        this.elementToAnimate_2 = elementToAnimate_2;
        this.showing            = false;
        this.elementToToggle_1  = elementToToggle_1;
        this.elementToToggle_2  = elementToToggle_2;
        this.scroller           = scroller;
    }

    OnScroll.prototype.resetElSize = function(){
                                		this.elTop = this.elementContainer.offset().top;
                                		this.elBottom = this.elementContainer.offset().top + this.elementContainer.outerHeight(true);
                                		return this;
                                     };

    OnScroll.prototype.addToggleSlide = function(){
                                         var self = this;
                                    	 self.elementContainer.click(function(){
                                    		 if(self.elementToAnimate_2.css('display') == 'none'){
                                    		     self.showRow();
                                	         }else{
                                	        	 self.hideRow();
                                	         }
                                    	 });
                                     };
    
    OnScroll.prototype.hideRow = function(){
                                    var self = this;
                                	this.showing = false;
                                    this.elementToAnimate_2.slideUp(50);
                                    container.removeClass("container-none");
                                    this.elementToToggle_1.toggleClass("gone");
                                	this.elementToToggle_2.toggleClass("gone");
                                	this.elementContainer.removeClass("fixed");
                                	this.elementToAnimate_1.toggleClass("gone");
                                	header.slideDown(600,function(){
                                                    	    $('html, body').animate({
                                                            scrollTop: $(self.scroller).offset().top
                                                            }, 600);
                                	                     });
        	                        setViewPort();
                                 };
                                 
    OnScroll.prototype.showRow = function (){
                                    var self = this;
                                    jWindow.off("scroll");
                                    this.showing = true;
                            	    this.elementToAnimate_1.toggleClass("gone");
                        		    this.elementToToggle_1.toggleClass("gone");
                        		    this.elementToToggle_2.toggleClass("gone");
                        		    header.slideUp(700,function(){
                                                    	  $('html, body').animate({
                                                          scrollTop: $(self.scroller).offset().top
                                                          }, 400);
                                	                   });
                        	        this.elementToAnimate_2.slideDown(1200);
                                };

    OnScroll.prototype.isInView = function () {
        
                                      if(!this.inViewMem && viewTop > this.elTop && viewTop < this.elBottom) {
                                          
                                          // Element is partially visible (above viewable area)
                                          this.inViewMem = true;
                                          this.elementToAnimate_1.toggleClass(this.classesToToggle);
                                
                                      }else if(this.inViewMem && viewTop > this.elBottom && viewTop > this.elTop ) {
                                        
                                          // Element is hidden (above viewable area)
                                          this.inViewMem = false;
                                          this.elementToAnimate_1.toggleClass(this.classesToToggle);
                                        
                                      }else if(this.inViewMem && viewBottom < this.elTop && viewBottom < this.elBottom ) {
                                        
                                          // Element is hidden (below viewable area)
                                          this.inViewMem = false;
                                          this.elementToAnimate_1.toggleClass(this.classesToToggle);
                            
                                      }else if(!this.inViewMem && viewBottom < this.elBottom && viewBottom > this.elTop ) {
                                        
                                          // Element is partially visible (below viewable area)
                                          this.inViewMem = true;
                                          this.elementToAnimate_1.toggleClass(this.classesToToggle);
                            
                                      }else if(!this.inViewMem && viewTop < this.elTop && viewBottom > this.elBottom){
                                        
                                          // Element is completely visible
                                          this.inViewMem = true;
                                          this.elementToAnimate_1.toggleClass(this.classesToToggle);
                                      }
                                  };

    var title1 = new OnScroll($(".animation-container1"), $(".add-animation1"), $(".row1"), $(".sec-2"), $(".sec-3"), $("#scroller-1"));
    var title2 = new OnScroll($(".animation-container2"), $(".add-animation2"), $(".row2"), $(".sec-1"), $(".sec-3"), $("#scroller-2"));
    var title3 = new OnScroll($(".animation-container3"), $(".add-animation3"), $(".row3"), $(".sec-1"), $(".sec-2"), $("#scroller-3"));

    function setViewPort() {
        
        function checkViewPort(){
            
            viewBottom   = jWindow.scrollTop() + window.innerHeight;
            viewTop      = jWindow.scrollTop();
    
            title3.resetElSize().isInView();
            title2.resetElSize().isInView();
            title1.resetElSize().isInView();
        }
        
        jWindow.on("load resize scroll", checkViewPort);
    }
    
    setViewPort();
    
    title1.addToggleSlide();
    title2.addToggleSlide();
    title3.addToggleSlide();
}());

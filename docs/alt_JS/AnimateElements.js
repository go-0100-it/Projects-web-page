+( function(){

    var jWindow    = $(window);
	var container  = $(".container");
	var header     = $(".header");
	var viewBottom = jWindow.scrollTop() + window.innerHeight;
    var viewTop    = jWindow.scrollTop();

    function OnScroll(elementContainer, elementToAnimate_1, elementToAnimate_2, elementToToggle_1, elementToToggle_2) {
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
    }

    OnScroll.prototype.resetElSize = function(){
                                		this.elTop = this.elementContainer.offset().top;
                                		this.elBottom = this.elementContainer.offset().top + this.elementContainer.outerHeight(true);
                                		return this;
                                     };

    OnScroll.prototype.toggleSlide = function(){
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
                                	this.showing = false;
                                    this.elementToAnimate_2.slideUp(50);
                                    container.removeClass("container-none");
                                    this.elementToToggle_1.toggleClass("gone");
                                	this.elementToToggle_2.toggleClass("gone");
                                	header.toggleClass("gone");
                                	this.elementContainer.removeClass("fixed");
                                	this.elementToAnimate_1.toggleClass("gone");
                                	resetViewPort();
                                 };
                                 
    OnScroll.prototype.showRow = function (){
                                    this.showing = true;
                            	    this.elementToAnimate_1.toggleClass("gone");
                        		    this.elementToToggle_1.toggleClass("gone");
                        		    this.elementToToggle_2.toggleClass("gone");
                        		    header.toggleClass("gone");
                        	        this.elementToAnimate_2.slideDown(2900);
                        	        jWindow.off("scroll");
                        	        if(window.innerWidth <= 768){
                        	            this.elementContainer.addClass("fixed");
                        	    	    container.addClass("container-none");
                        	        }
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

    var title1 = new OnScroll($(".animation-container1"), $(".add-animation1"), $(".row1"), $(".sec-2"), $(".sec-3"));
    var title2 = new OnScroll($(".animation-container2"), $(".add-animation2"), $(".row2"), $(".sec-1"), $(".sec-3"));
    var title3 = new OnScroll($(".animation-container3"), $(".add-animation3"), $(".row3"), $(".sec-1"), $(".sec-2"));

    function checkViewPort() {
        
        viewBottom   = jWindow.scrollTop() + window.innerHeight;
        viewTop      = jWindow.scrollTop();

        title3.resetElSize().isInView();
        title2.resetElSize().isInView();
        title1.resetElSize().isInView();
    }
    
 	jWindow.on("load resize", resetViewPort);

 	function resetViewPort(){
 		if(window.innerWidth > 768){
	 		jWindow.on("scroll", checkViewPort); 		
	 	}else{
	 		jWindow.off("scroll");
	 	}
 	}

    title1.toggleSlide();
    title2.toggleSlide();
    title3.toggleSlide();
}());


/*
 * A function to create the HTML for the project cards and add the created HTML to the DOM.
 */
(function(){
    AddHtml = {createProjectCard: function(projType, projNum, projName, imgSrc, a1href, a2href, btn1Content, btn2Content){
    /*
     *  This is an example of the HTML the code below will generate
     *
     *
     *      <div class="col-xs-12 col-sm-6 col-md-4">
     *          <article class="thumbnail radius">
     *              <img class="radius-top" src="#" alt="Project 1 image" data-toggle="modal" data-target="#project2_1">
     *              <div class="caption">
     *                  <h3>Project 1</h3>
     *                  <p><a href="#" class="btn btn-primary alt2-button-style" role="button">View on GitHub</a></p>
     *                  <p><a href="#" class="btn btn-default" role="button">View Website</a></p>
     *              </div>
     *          </article>
     *      </div>
     *
     */
    var div = document.createElement("div");
        div.className = "col-xs-12 col-sm-6 col-md-4";
        document.getElementsByClassName("row" + projType)[0].appendChild(div);

    var article = document.createElement("article");
        article.className = "thumbnail radius dim-on-hover";
        article.setAttribute("data-toggle", "modal");
        article.setAttribute("data-target", "#project" + projType + "_" + projNum);
        div.appendChild(article);

        var img = document.createElement("img");
            img.className = "radius-top";
            img.src = imgSrc;
            img.alt = projName + " image";
            article.appendChild(img);

        var div2 = document.createElement("div");
            div2.className = "caption";
            article.appendChild(div2);

            var h3 = document.createElement("h3");

            var h3Content = document.createTextNode(projName);
                h3.appendChild(h3Content);
                div2.appendChild(h3);

            var p1 = document.createElement("p");
                div2.appendChild(p1);

                var a1 = document.createElement("a");
                    a1.href = a1href;
                    a1.className = "btn btn-primary alt" + projType + "-button-style";
                    a1.setAttribute("role", "button");
                    a1.setAttribute("target", "_blank");

                var a1Content = document.createTextNode(btn1Content);
                    a1.appendChild(a1Content);
                    p1.appendChild(a1);

            var p2 = document.createElement("p");
                div2.appendChild(p2);

                var a2 = document.createElement("a");
                    a2.href = a2href;
                    a2.className = "btn btn-default";
                    a2.setAttribute("role", "button");
                    a2.setAttribute("target", "_blank");

                var a2Content = document.createTextNode(btn2Content);
                    a2.appendChild(a2Content);
                    p2.appendChild(a2);
},

    createModal: function (projType, projNum, projName, projTitle, imgSrc, comment){
/*
 *  This is an example of the HTML the code below will generate
 *
 *
 *          <div class="modal fade" id="project1_1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 *              <div class="modal-dialog">
 *                  <div class="modal-content">
 *                      <div class="modal-header">
 *                          <h4 class="modal-title" id="myModalLabel">Project 1</h4>
 *                          <div class="modal-body">
 *                              <img class="img-responsive radius" src="../Projects/Intro_to_programming_projects/Basic_HTML_page/Intro_to_programming_project_one.png" alt="Project 1 image">
 *                              <h3 class="modal-project_title">Project 1</h3>
 *                              <p class="modal-text">Spicy jalapeno bacon ipsum dolor amet corned beef meatball flank shoulder velit porchetta in beef sint sed. Shankle proident dolor venison, est prosciutto qui deserunt minim spare ribs ipsum consectetur pancetta.</p>
 *                          </div>
 *                          <div class="modal-footer">
 *                              <button class="btn btn-default" type="button" data-dismiss="modal">Close</button>
 *                          </div>
 *                      </div>
 *                  </div>
 *              </div>
 *          </div>
 *
 */
    var div = document.createElement("div");
        div.className = "modal fade";
        div.id = "project" + projType + "_" + projNum;
        div.setAttribute("tabindex", "-1");
        div.setAttribute("role", "dialog");
        div.setAttribute("aria-labelledby", "myModalLabel");
        div.setAttribute("aria-hidden", "true");
        document.getElementsByClassName("modal-container")[0].appendChild(div);

        var div2 = document.createElement("div");
            div2.className = "modal-dialog";
            div.appendChild(div2);

            var div3 = document.createElement("div");
                div3.className = "modal-content";
                div2.appendChild(div3);

                var div4 = document.createElement("div");
                    div4.className = "modal-header";
                    div3.appendChild(div4);

                    var h4 = document.createElement("h4");
                        h4.className = "modal-title";
                        h4.id = "myModalLabel";

                    var h4Content = document.createTextNode(projName);
                        h4.appendChild(h4Content);
                        div4.appendChild(h4);

                    var div5 = document.createElement("div");
                        div5.className = "modal-body";
                        div4.appendChild(div5);

                        var img = document.createElement("img");
                            img.className = "img-responsive radius";
                            img.src = imgSrc;
                            img.alt = projName + " image";
                            div5.appendChild(img);

                        var h3 = document.createElement("h3");
	                        h3.className = "project-title";

	                    var h3Content = document.createTextNode(projTitle);
	                        h3.appendChild(h3Content);
	                        div5.appendChild(h3);

                        var p = document.createElement("p");
                            p.className = "modal-text";

                        var pContent = document.createTextNode(comment);
                            p.appendChild(pContent);
                            div5.appendChild(p);

                    var div6 = document.createElement("div");
                        div6.className = "modal-footer";
                        div4.appendChild(div6);

                        var button = document.createElement("button");
                            button.className = "btn btn-default";
                            button.setAttribute("type", "button");
                            button.setAttribute("data-dismiss", "modal");

                        var btnContent = document.createTextNode("Close");
                            button.appendChild(btnContent);
                            div6.appendChild(button);
  }
};
})();